package com.example.varbergpoi


/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.constraints.ConstraintManager
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarIcon
import androidx.car.app.model.CarText
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.ParkedOnlyOnClickListener
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.versioning.CarAppApiLevels
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.DefaultLifecycleObserver
import com.example.varbergpoi.dummydata.SubCategory


/**
 * Creates a screen that demonstrates usage of the full screen [ListTemplate] to display a
 * full-screen list.
 */
class SubCategoryListScreen(
    carContext: CarContext,
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
                Row.Builder()
                    .setOnClickListener(
                        ParkedOnlyOnClickListener.create {

                        })
                    .setTitle(subCat.title).setImage(
                        CarIcon.Builder(
                            IconCompat.createWithResource(
                                carContext,
                                R.drawable.restaurants_icon
                            )
                        ).build()
                    ).build()
            )
                .build()
        }
//         Some hosts may allow more items in the list than others, so create more.
        if (carContext.carAppApiLevel > CarAppApiLevels.LEVEL_1) {
            val listLimit = Math.min(
                MAX_LIST_ITEMS,
                carContext.getCarService(ConstraintManager::class.java).getContentLimit(
                    ConstraintManager.CONTENT_LIMIT_TYPE_LIST
                )
            )
            for (i in 2..listLimit) {
                // For row text, set text variants that fit best in different screen sizes.
                val secondTextStr = ("Second line text")
                val secondText = CarText.Builder(
                    "================= $secondTextStr ================"
                )
                    .addVariant(
                        "--------------------- " + secondTextStr
                                + " ----------------------"
                    )
                    .addVariant(secondTextStr)
                    .build()
                val onClickText = "Clicked row: $i"
                val rowBuilder = Row.Builder()
                    .setOnClickListener { onClick(onClickText) }
                    .setTitle(
                        "Title prefix $i"
                    )
                if (i % 2 == 0) {
                    rowBuilder.addText("Long line text")
                } else {
                    rowBuilder
                        .addText("First Line text")
                        .addText(secondText)
                }
                listBuilder.addItem(rowBuilder.build())
            }
        }
        val settings = Action.Builder()
            .setTitle(
                "Action title"
            )
            .setOnClickListener {
                CarToast.makeText(
                    carContext,
                    "Settings toast Message",
                    CarToast.LENGTH_LONG
                )
                    .show()
            }
            .build()
        return ListTemplate.Builder()
            .setSingleList(listBuilder.build())
            .setTitle("Mat & Dryck")
            .setHeaderAction(Action.BACK)
            .setActionStrip(
                ActionStrip.Builder()
                    .addAction(settings)
                    .build()
            )
            .build()
    }

    private fun onClick(text: String) {
        CarToast.makeText(carContext, text, CarToast.LENGTH_LONG).show()
    }

    companion object {
        private const val MAX_LIST_ITEMS = 100
    }
}