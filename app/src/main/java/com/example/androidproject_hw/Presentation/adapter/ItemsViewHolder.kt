package com.example.clswrk_androidprojekt.adapter


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.example.androidproject_hw.Presentation.adapter.listener.ItemsListener
import com.example.clswrk_androidprojekt.databinding.ItemsCatsBinding
import com.example.clswrk_androidprojekt.model.ItemsModel


class ItemsViewHolder(
    private var viewBinding: ItemsCatsBinding,
    private var itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(itemsModel: ItemsModel) {

        viewBinding.tvName.text = "Name: " + itemsModel.name
        viewBinding.tvUsername.text = "Username: " + itemsModel.username
        viewBinding.tvEmail.text = "Email: " + itemsModel.email
        viewBinding.tvPhone.text = "Phone: " + itemsModel.phone
        viewBinding.tvAddress.text = "Address: " + itemsModel.city + ", " + itemsModel.street + "str., " + itemsModel.suite
        viewBinding.tvZipcode.text = "Zipcode: " + itemsModel.zipcode
        viewBinding.tvCompany.text = "Company: " + itemsModel.nameCompany
        viewBinding.tvGeo.text = "lat: " + itemsModel.lat+ " , lng: " + itemsModel.lng
        viewBinding.tvWebsite.text = "website " + itemsModel.website
        viewBinding.tvBs.text = "bs: " + itemsModel.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + itemsModel.catchPhrase

      itemView.setOnClickListener {
          itemsListener.onElementSelected(
              itemsModel.name,
              itemsModel.username,
              itemsModel.email,
          itemsModel.id)

        }
viewBinding.ivFav.isSelected = itemsModel.fav
        viewBinding.ivFav.setOnClickListener{
          viewBinding.ivFav.isSelected = !it.isSelected
            itemsListener.onFavClicked(itemsModel.id,it.isSelected)
        }

viewBinding.ivDelite.setOnClickListener {
    itemsListener.onDeliteClicked(itemsModel.id)
}
    }

}


