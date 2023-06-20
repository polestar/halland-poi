package com.example.varbergpoi

import android.content.Intent
import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
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
        return MainScreen(carContext)
    }
}

class MainScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val dHandler = DummyHandler.getInstance()

        val gridItemListBuilder = ItemList.Builder()
        val poiData = listOf(
            PoiData("Restaurants", R.drawable.restaurants_icon),
            PoiData("Charging stations", R.drawable.charging_stations_icon),
            PoiData("Hiking areas", R.drawable.hiking_areas_icon),
            PoiData("Beaches", R.drawable.beaches_icon),
            PoiData("Hotels", R.drawable.hotels_icon),
            PoiData("Parking spaces", R.drawable.parking_spaces_icon),
            PoiData("Bike rental", R.drawable.bike_rental_icon),
            PoiData("Museums", R.drawable.museums_icon)
        )

        dHandler.categories.forEach { data ->
            val gridItemBuilder = GridItem.Builder()
                .setTitle(data.title)
                .setOnClickListener {
                    if(data.subCategories.isNotEmpty())
                        screenManager.push(SubCategoryListScreen(carContext, data.subCategories))
                }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, data.iconRes ?: R.drawable.restaurants_icon)
                    ).build()
                )
                .build()

            gridItemListBuilder.addItem(gridItemBuilder)
        }

        return GridTemplate.Builder()
            .setTitle("Points of interest")
            .setSingleList(gridItemListBuilder.build())
            .build()
    }

    // Data class to hold POI information
    data class PoiData(val title: String, val iconResId: Int)
}
