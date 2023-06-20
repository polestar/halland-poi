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
                Row.Builder().setOnClickListener { screenManager.push(PlaceListScreen(carContext, subCat.points, subCat.title)) }
                    .setTitle(subCat.title).build()
//                    .setImage(
//                        CarIcon.Builder(
//                            IconCompat.createWithResource(
//                                carContext,
//                                subCat.iconRes
//                            )
//                        ).build(), Row.IMAGE_TYPE_ICON
//                    ).build()
            )
                .build()
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
            .setTitle(screenTitle)
            .setHeaderAction(Action.BACK)
            .setActionStrip(
                ActionStrip.Builder()
                    .addAction(settings)
                    .build()
            )
            .build()
    }

//    private fun onClick(text: String) {
//        CarToast.makeText(carContext, text, CarToast.LENGTH_LONG).show()
//    }

    companion object {
        private const val MAX_LIST_ITEMS = 100
    }
}