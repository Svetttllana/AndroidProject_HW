package com.example.androidproject_hw.data.items

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidproject_hw.data.ApiService
import com.example.androidproject_hw.domain.items.ItemsReposetory
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): ItemsReposetory {
    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let {
                it.map {
                    ItemsModel(
                        it.id,
                        it.name,
                        it.username,
                        it.email,
                        it.phone,
                        it.website,
                        it.address.street,
                        it.address.suite,
                        it.address.city,
                        it.address.zipcode,
                        it.company.name,
                        it.company.catchPhrase,
                        it.company.bs,
                        it.address.geo.lat,
                        it.address.geo.lng,
                    )
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }
}





