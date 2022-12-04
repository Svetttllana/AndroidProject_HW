package com.example.androidproject_hw

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clswrk_androidprojekt.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemsViewModel:ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items


    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

   // @RequiresApi(Build.VERSION_CODES.O)
    fun getData() {


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
        _items.value = listItems
}
    fun imageViewClicked() {

        _msg.value = "ImageView clicked"
    }

    fun elementClicked(title: String, description: String, imageView: Int, time:String) {

        _bundle.value = NavigateWithBundle(title = title, description = description, image = imageView, time = time)
    }

}

data class NavigateWithBundle(
    val image:Int,
    val title:String,
    val description:String,
    val time: String
)

