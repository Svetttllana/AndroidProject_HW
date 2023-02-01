package com.example.androidproject_hw.Presentation.view.items.favorite.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject_hw.Presentation.view.items.favorite.adapter.listener.FavoriteListener
import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.databinding.ItemsFavoriteBinding

class FavoriteViewHolder(
    private val viewBinding: ItemsFavoriteBinding,
    private var favoriteListener: FavoriteListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(favItems: FavoriteModel) {

        viewBinding.tvName.text = "Name: " + favItems.name
        viewBinding.tvUsername.text = "Username: " + favItems.username
        viewBinding.tvEmail.text = "E-mail: " + favItems.email
        viewBinding.tvPhone.text = "Phone: " + favItems.phone
        viewBinding.tvAddress.text = "Address: " + favItems.city + ", " + favItems.street + "str., " + favItems.suite
        viewBinding.tvZipcode.text = "Zipcode: " + favItems.zipcode
        viewBinding.tvCompany.text = "Company: " + favItems.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + favItems.lat+ ", lng: " + favItems.lng
        viewBinding.tvWebsite.text = "Website " + favItems.website
        viewBinding.tvBs.text = "Business: " + favItems.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + favItems.catchPhrase

        viewBinding.btnDeleteFav.setOnClickListener {
            favoriteListener.onDeliteClicked(favItems.id)
        }

    }


}