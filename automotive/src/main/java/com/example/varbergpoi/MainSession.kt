package com.example.varbergpoi

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Intent
import android.content.pm.PackageManager
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.ScreenManager
import androidx.car.app.Session
import androidx.car.app.model.CarIcon
import androidx.car.app.model.GridItem
import androidx.car.app.model.GridTemplate
import androidx.car.app.model.ItemList
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import com.example.varbergpoi.dummydata.DummyHandler


class MainSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return if (hasLocationPermission())
            MainScreen(carContext)
        else {
            carContext.getCarService(ScreenManager::class.java).push(MainScreen(carContext))
            LocationPermissionScreen(carContext)
        }
    }


    private fun hasLocationPermission() =
        (carContext.checkSelfPermission(ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
}

class MainScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val dHandler = DummyHandler.getInstance()

        val gridItemListBuilder = ItemList.Builder()

        dHandler.categories.forEach { data ->
            val gridItemBuilder = GridItem.Builder()
                .setTitle(data.title)
                .setOnClickListener {
                    if (data.subCategories.isNotEmpty())
                        screenManager.push(
                            SubCategoryListScreen(
                                carContext,
                                data.title,
                                data.subCategories
                            )
                        )
                }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(
                            carContext,
                            data.iconRes ?: R.drawable.restaurants_icon
                        )
                    ).build()
                )
                .build()

            gridItemListBuilder.addItem(gridItemBuilder)
        }

        return GridTemplate.Builder()
            .setTitle("Halland points of interests")
            .setSingleList(gridItemListBuilder.build())
            .build()
    }

    // Data class to hold POI information
    data class PoiData(val title: String, val iconResId: Int)
}
