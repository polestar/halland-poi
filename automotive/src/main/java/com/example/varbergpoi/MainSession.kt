package com.example.varbergpoi

import android.content.Intent
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.model.CarIcon
import androidx.car.app.model.GridItem
import androidx.car.app.model.GridTemplate
import androidx.car.app.model.ItemList
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat


class MainSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return MainScreen(carContext)
    }

}

class MainScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val gridItemListBuilder = ItemList.Builder()
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Restaurants").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.restaurants_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Charging stations")
                .setOnClickListener { onPreviewClicked() }.setImage(
                CarIcon.Builder(
                    IconCompat.createWithResource(carContext, R.drawable.charging_stations_icon)
                ).build()
            ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Hiking areas").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.hiking_areas_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Beaches").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.beaches_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Hotels").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.hotels_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Parking spaces").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.parking_spaces_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Bike rental").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.bike_rental_icon)
                    ).build()
                ).build()
        )
        gridItemListBuilder.addItem(
            GridItem.Builder().setTitle("Museums").setOnClickListener { onPreviewClicked() }
                .setImage(
                    CarIcon.Builder(
                        IconCompat.createWithResource(carContext, R.drawable.museums_icon)
                    ).build()
                ).build()
        )

        return GridTemplate.Builder().setTitle("Points of interest")
            .setSingleList(gridItemListBuilder.build()).build()
    }

    private fun onPreviewClicked() {
        CarToast.makeText(carContext, "Button Clicked", CarToast.LENGTH_LONG).show()
    }
}
