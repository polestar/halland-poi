package com.example.varbergpoi.dummydata

class POIItem {
    var description: String = ""
    var coordinates: Pair<Double, Double> = Pair(0.0, 0.0)
    var title: String = ""

    override fun toString(): String {
        return title + " (" + coordinates.first.toString() + ", " + coordinates.second.toString() + ")"
    }
}