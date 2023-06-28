package com.example.varbergpoi

import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarIcon
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.DefaultLifecycleObserver
import com.example.varbergpoi.dummydata.SubCategory


/**
 * Creates a screen that demonstrates usage of the full screen [ListTemplate] to display a
 * full-screen list.
 */
class SubCategoryListScreen(
    carContext: CarContext,
    private val screenTitle: String,
    private val subCategories: List<SubCategory> = listOf()
) : Screen(carContext),
    DefaultLifecycleObserver {
    init {
        lifecycle.addObserver(this)
    }

    override fun onGetTemplate(): Template {
        val listBuilder = ItemList.Builder()
        subCategories.forEach { subCat ->
            listBuilder.addItem(
                Row.Builder().setBrowsable(true).setOnClickListener {
                    screenManager.push(
                        PlaceListScreen(
                            carContext,
                            subCat.points,
                            subCat.title
                        )
                    )
                }
                    .setTitle(subCat.title).build()
            )
                .build()
        }

        val settings = Action.Builder()
            .setIcon(
                CarIcon.Builder(
                    IconCompat.createWithResource(carContext, R.drawable.baseline_favorite_border_24)
                ).build()
            )
            .setOnClickListener {
                CarToast.makeText(
                    carContext,
                    "Sparad",
                    CarToast.LENGTH_LONG
                )
                    .show()
            }
            .build()
        return ListTemplate.Builder()
            .setSingleList(listBuilder.build())
            .setTitle(screenTitle)
            .setHeaderAction(Action.BACK)
            .setActionStrip(
                ActionStrip.Builder()
                    .addAction(settings)
                    .build()
            )
            .build()
    }

    companion object {
        private const val MAX_LIST_ITEMS = 100
    }
}