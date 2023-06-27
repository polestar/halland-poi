package com.example.varbergpoi

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Address
import android.location.Geocoder
import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.HostException
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.car.app.model.ForegroundCarColorSpan
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.Locale

/** A screen that displays a the details for a given place.  */
class PlaceDetailsScreen constructor(carContext: CarContext) :
    Screen(carContext),
    DefaultLifecycleObserver {

    // Loaded asynchronously from the network.
    private var mPhoto: Bitmap? = null
    private var mGeocoder: Geocoder? = null
    override fun onCreate(owner: LifecycleOwner) {
        mGeocoder = Geocoder(carContext)
    }

    override fun onGetTemplate(): Template {
        val paneBuilder = Pane.Builder()
        val mDetails = listOf(
            "Detail one",
            "Detail two",
        )

        // If we don't have any places yet, show a loading progress indicator.
        if (mDetails == null) {
            paneBuilder.setLoading(true)
        } else {
            val row1Builder = Row.Builder().setTitle("Address")

            // Add the address, split in multiple lines.
            val addressLines = listOf(
                "Fredsgatan 5",
                "302 46 Halmstad",
            )
            for (line in addressLines) {
                row1Builder.addText(line)
            }
            if (mPhoto != null) {
                row1Builder.setImage(
                    CarIcon.Builder(IconCompat.createWithBitmap(mPhoto!!)).build(),
                    Row.IMAGE_TYPE_LARGE
                )
            }
            paneBuilder.addRow(row1Builder.build())
            var hasSecondRow = false
            val row2Builder = Row.Builder().setTitle("Phone Number and Rating")

            // Add the phone number.
            val phoneNumber: String = "+46 700 51 55 36"
            if (phoneNumber != null) {
                hasSecondRow = true
                row2Builder.addText(phoneNumber)
            }

            // Add the place's ratings.
            val ratings: Double = 3.5
            if (ratings >= 0) {
                hasSecondRow = true
                row2Builder.addText(getRatingsString(ratings))
            }
            if (hasSecondRow) {
                paneBuilder.addRow(row2Builder.build())
            }

            // Add a button with a navigate action.
            paneBuilder.addAction(
                Action.Builder()
                    .setTitle("Navigate")
                    .setOnClickListener { onClickNavigate() }
                    .build())
        }
        return PaneTemplate.Builder(paneBuilder.build())
            .setTitle("Vald Plats")
            .setHeaderAction(Action.BACK)
            .build()
    }

    private fun onClickNavigate() {
        val intent = Intent(CarContext.ACTION_NAVIGATE)
        try {
            carContext.startCarApp(intent)
        } catch (e: HostException) {
            CarToast.makeText(
                carContext,
                "Failure starting navigation",
                CarToast.LENGTH_LONG
            )
                .show()
        }
    }


    companion object {
        private const val FULL_STAR = "\u2605"
        private const val HALF_STAR = "\u00BD"

        /** Returns a screen showing the details of the given [PlaceInfo].  */
//        fun create(carContext: CarContext, place: PlaceInfo): PlaceDetailsScreen {
        fun create(carContext: CarContext): PlaceDetailsScreen {
            return PlaceDetailsScreen(carContext,)
        }

        private fun getAddressLines(address: Address): List<CharSequence> {
            val list: MutableList<CharSequence> = ArrayList()

            // First line: [street number address].
            var separator = " "
            var s = append(address.subThoroughfare, address.thoroughfare, separator)
            if (s != null) {
                list.add(s)
            }

            // Second line: [city, state, postal code].
            separator = ", "
            s = append(
                append(address.locality, address.adminArea, separator),
                address.postalCode,
                separator
            )
            if (s != null) {
                list.add(s)
            }
            return list
        }

        private fun append(a: String?, b: String?, separator: String): String? {
            return if (a == null) b else if (b == null) a else a + if (a.isEmpty()) b else separator + b
        }

        private fun getRatingsString(ratings: Double): CharSequence {
            var s: String
            var r: Double
            s = ""
            r = ratings
            while (r > 0) {
                s += if (r < 1) HALF_STAR else FULL_STAR
                --r
            }
            val ss = SpannableString(s + " ratings: " + String.format(Locale.US, "%.2f", ratings))
            if (!s.isEmpty()) {
                colorize(ss, CarColor.YELLOW, 0, s.length)
            }
            return ss
        }

        fun colorize(s: SpannableString, color: CarColor?, index: Int, length: Int) {
            s.setSpan(
                ForegroundCarColorSpan.create(color!!),
                index,
                index + length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
}
