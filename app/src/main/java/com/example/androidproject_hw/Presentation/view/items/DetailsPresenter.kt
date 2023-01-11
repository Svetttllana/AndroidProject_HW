package com.example.androidproject_hw.Presentation.view.items

import android.util.Log
import com.example.androidproject_hw.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment1: DetailsFragment1) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    detailsView = detailsFragment1
                } catch (e: Exception) {
                    Log.w("exeption", " saveOnBoarding FAILED")
                }

            }
            job.join()
            job.cancel()
        }

    }

    fun logoutUser() {

        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    authInteractor.logoutUser()

                    detailsView.logoutUser()
                } catch (e: Exception) {
                    Log.w("exeption", " saveOnBoarding FAILED")
                }

            }
            job.join()
            job.cancel()
        }

    }

    fun getArguments(title: String?, description: String?, time: String?, image: Int) {

        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    detailsView.displayItemData(
                        when (title.isNullOrBlank()) {

                            true -> "no data"
                            false -> title
                        },
                        when (description.isNullOrEmpty()) {
                            true -> " no date"
                            false -> description

                        },
                        when (time.isNullOrEmpty()) {
                            true -> "no date"
                            false -> time
                        },
                        image
                    )
                } catch (e: Exception) {
                    Log.w("exeption", " getArguments FAILED")
                }

            }
            job.join()
            job.cancel()
        }


    }

}