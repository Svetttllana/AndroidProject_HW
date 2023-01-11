package com.example.androidproject_hw.data.items

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidproject_hw.R
import com.example.androidproject_hw.domain.items.ItemsReposetory
import com.example.clswrk_androidprojekt.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor() : ItemsReposetory {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {


            val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
            val listItems = listOf<ItemsModel>(
                ItemsModel(R.drawable.main_kyn, "Main Khyn", "this is clever cat", time),
                ItemsModel(
                    R.drawable.abyssinian,
                    " Abyssinian cat,",
                    "this is beautifyle cat",
                    time
                ),
                ItemsModel(R.drawable.bengal, "Bengal cat", "very affectionate cat", time),
                ItemsModel(R.drawable.blue_kit, "Russian Blue", "very kind cat", time),
                ItemsModel(R.drawable.britan, "British Shorthair", "This is britan cat", time),
                ItemsModel(
                    R.drawable.oriental_shorthair,
                    "Oriental Shorthair",
                    "This is fluffy cat",
                    time
                ),
                ItemsModel(R.drawable.shotland, "Shortland", "This is active", time),
                ItemsModel(R.drawable.siamese, "Siamse", "This is right", time),
                ItemsModel(R.drawable.pers_kit, "Persid", "This is active", time),
                ItemsModel(R.drawable.cornish_rex, "Cornish-rex", "very kind cat", time),
                ItemsModel(R.drawable.siamese, "Siamse", "this is clever cat", time),
                ItemsModel(R.drawable.sphynx, "Sphynx", "very affectionate cat", time)
            )
            return@withContext listItems
        }
    }
}