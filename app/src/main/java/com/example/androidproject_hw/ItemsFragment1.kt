package com.example.androidproject_hw

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.listener.ItemsListener
import com.example.clswrk_androidprojekt.adapter.ItemsAdapter
import com.example.clswrk_androidprojekt.model.ItemsModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ItemsFragment1 : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items1, container, false)
    }



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        // у фрагмента нет контекста. закрепляем как фрагмнт
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.main_kyn, "Main Khyn", "this is clever cat",time),
            ItemsModel(R.drawable.abyssinian, " Abyssinian cat,", "this is beautifyle cat",time),
            ItemsModel(R.drawable.bengal, "Bengal cat", "very affectionate cat",time),
            ItemsModel(R.drawable.blue_kit, "Russian Blue", "very kind cat", time),
            ItemsModel(R.drawable.britan, "British Shorthair", "This is britan cat", time),
            ItemsModel(R.drawable.oriental_shorthair, "Oriental Shorthair", "This is fluffy cat", time),
            ItemsModel(R.drawable.shotland, "Shortland", "This is active", time),
            ItemsModel(R.drawable.siamese, "Siamse", "This is right", time),
            ItemsModel(R.drawable.pers_kit, "Persid", "This is active", time),
            ItemsModel(R.drawable.cornish_rex, "Cornish-rex", "very kind cat", time),
            ItemsModel(R.drawable.siamese, "Siamse", "this is clever cat", time),
            ItemsModel(R.drawable.sphynx, "Sphynx", "very affectionate cat", time)

        )
        itemsAdapter.submitList(listItems.toList())


    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_SHORT).show()
    }


    override fun onElementSelected(
        title: String,
        description: String,
        imageView: Int,
        time: String ) {

        val detailsFragment = DetailsFragment1()
        // в бвндле храми маленькие данные и плюс можно там прописать ключик и имя ключика,
        // которые мы сможем передать в аргументы
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("description", description)
        bundle.putInt("imageView", imageView)
        bundle.putString("time", time)

        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}

//        //TODO add метод мы больше не используем
//        // теперь всегда используем replase
//        //replace всегда будет иметь или аддТоБукстек, чтобы мы могли вернутся назад или же его не будет,
//        // чтобы мы вернулись назад
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.activity_container,detailsFragment)
//            .addToBackStack("Details")
//            .commit()


