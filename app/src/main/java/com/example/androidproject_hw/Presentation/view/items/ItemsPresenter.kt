package com.example.androidproject_hw.Presentation.view.items


import android.util.Log
import com.example.androidproject_hw.R


import com.example.androidproject_hw.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {
    private lateinit var itemsView: ItemsView

    fun setVIew(itemsFragment1: ItemsFragment1) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsView = itemsFragment1
                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }


    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    val listItems = itemsInteractor.getData()

                    itemsView.dataReceived(listItems)
                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }



    }

    fun imageViewClicked() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsView.imageViewClicked(R.string.imageview_clicked)
                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }





    }

    fun elementSelected(
        name: String,
        userName: String,
        email: String,
        id: Int,
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsView.goToDetails(name, userName, email, id)

                }catch (e:Exception){
                    Log.w("exeption", " checkOnBoardFragm FAILED")
                }

            }
            job.join()
            job.cancel()
        }





    }

}