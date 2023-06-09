package com.example.varbergpoi

//import androidx.car.app.sample.showcase.common.R

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.HandlerThread
import androidx.annotation.Nullable
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.CarLocation
import androidx.car.app.model.ItemList
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.location.LocationListenerCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class PlaceListScreen(carContext: CarContext) : Screen(carContext) {
    val mLocationListener: LocationListenerCompat
    val mLocationUpdateHandlerThread: HandlerThread
    var mHasPermissionLocation: Boolean

    @Nullable
    private var mCurrentLocation: Location? = null

    init {
        mHasPermissionLocation = (carContext.checkSelfPermission(ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || carContext.checkSelfPermission(ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
        mLocationUpdateHandlerThread = HandlerThread("LocationThread")
        mLocationListener = LocationListenerCompat { location: Location? ->
            mCurrentLocation = location
            invalidate()
        }
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                mHasPermissionLocation = (carContext.checkSelfPermission(ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED
                        || carContext.checkSelfPermission(ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED)
                if (mHasPermissionLocation) {
                    val locationManager = carContext.getSystemService(
                        LocationManager::class.java
                    )
                    locationManager.requestLocationUpdates(
                        LocationManager.FUSED_PROVIDER,
                        LOCATION_UPDATE_MIN_INTERVAL_MILLIS.toLong(),
                        LOCATION_UPDATE_MIN_DISTANCE_METER.toFloat(),
                        mLocationListener,
                        mLocationUpdateHandlerThread.looper
                    )
                } else {
                    CarToast.makeText(
                        carContext,
                        getCarContext().getString(R.string.grant_location_permission_toast_msg),
                        CarToast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onPause(owner: LifecycleOwner) {
                val locationManager = getCarContext().getSystemService(
                    LocationManager::class.java
                )
                locationManager.removeUpdates(mLocationListener)
            }
        })
    }

    override fun onGetTemplate(): Template {
        val builder = PlaceListMapTemplate.Builder()
            .setItemList(
                ItemList.Builder()
                    .addItem(
                        Row.Builder()
                            .setTitle(carContext.getString(R.string.browse_places_title))
                            .setBrowsable(true)
                            .setOnClickListener {
                            }.build()
                    )
                    .build()
            )
            .setTitle(carContext.getString(R.string.place_list_template_demo_title))
            .setHeaderAction(Action.BACK)
            .setCurrentLocationEnabled(mHasPermissionLocation)
        if (mCurrentLocation != null) {
            builder.setAnchor(Place.Builder(CarLocation.create(mCurrentLocation!!)).build())
        }
        return builder.build()
    }

    companion object {
        private const val LOCATION_UPDATE_MIN_INTERVAL_MILLIS = 1000
        private const val LOCATION_UPDATE_MIN_DISTANCE_METER = 1
    }
}