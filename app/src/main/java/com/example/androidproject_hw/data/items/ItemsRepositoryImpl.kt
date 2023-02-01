package com.example.androidproject_hw.data.items

import com.example.androidproject_hw.data.ApiService
import com.example.androidproject_hw.data.database.dao.ItemsEntity
import com.example.androidproject_hw.data.database.dao.ItemsDAO
import com.example.androidproject_hw.data.database.dao.faventity.FavoriteEntity
import com.example.androidproject_hw.domain.items.ItemsReposetory
import com.example.androidproject_hw.model.FavoriteModel
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    override suspend fun showData(): Flow<List<ItemsModel>> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntity()
            itemsEntity.map {itemsList ->
                itemsList.map { item->
                    ItemsModel(
                        item.id,
                        item.name,
                        item.username,
                        item.phone,
                        item.email,
                        item.website,
                        item.city,
                        item.zipcode,
                        item.lat,
                        item.bs,
                        item.phone,
                        item.catchPhrase,
                        item.lng,
                        item.nameCompany,
                        item.street
                    )
                }

            }
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO){
            itemsDAO.insetFavoritesEntity(
                FavoriteEntity(
                    itemsModel.id,
                    itemsModel.name,
                    itemsModel.username,
                    itemsModel.email,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.name,
                    itemsModel.catchPhrase,
                    itemsModel.bs,
                    itemsModel.lat,
                    itemsModel.lng
                )
            )
        }
    }

    override suspend fun deleteItemById(id: Int) {
        withContext(Dispatchers.IO){
            itemsDAO.deleteItemEntityById(id)
        }
    }

    override suspend fun deliteFavById(id: Int) {
        withContext(Dispatchers.IO){
            itemsDAO.deleteFavEntityById(id)
        }
    }

    override suspend fun getFavorites(): List<FavoriteModel> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDAO.getFavoritesEntities()
            favoritesEntity.map{
                FavoriteModel(
                    it.id,
                    it.name,
                    it.username,
                    it.email,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.nameCompany,
                    it.catchPhrase,
                    it.bs,
                    it.lat,
                    it.lng)
            }
        }
    }

    override suspend fun findItemById(id: Int): ItemsModel {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDAO.findItemEntityById(id)
            ItemsModel(
                itemsEntity.id,
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.name,
                itemsEntity.catchPhrase,
                itemsEntity.bs,
                itemsEntity.lat,
                itemsEntity.lng)
        }
    }
}





