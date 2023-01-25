package com.example.androidproject_hw.data.items

import com.example.androidproject_hw.data.ApiService
import com.example.androidproject_hw.data.ItemsEntity
import com.example.androidproject_hw.data.database.dao.ItemsDAO
import com.example.androidproject_hw.domain.items.ItemsReposetory
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO
) : ItemsReposetory {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDAO.doesItemsEntityExist()) {
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(
                            it.id,
                            it.name,
                            it.username,
                            it.phone,
                            it.email,
                            it.website,
                            it.phone,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.company.name,
                            it.company.catchPhrase,
                            it.company.bs,
                            it.address.geo.lat,

                        )

                        itemsDAO.insertItemsEntity(itemsEntity)

                    }
                }

            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntity()
            itemsEntity.map {
                ItemsModel(
                    it.id,
                    it.name,
                    it.username,
                    it.phone,
                    it.email,
                    it.website,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.bs,
                    it.phone,
                    it.catchPhrase,
                    it.lng,
                    it.nameCompany,
                    it.street
                )
            }
        }
    }
}





