package com.example.walk_a_mib.logic_layer.domain
import kotlin.math.*

class Coordinate() {
    var lat: Double = 0.0
    var lon: Double = 0.0
    var alt: Double = 0.0

    constructor(lat: Double, lon: Double, alt: Double) : this() {
        this.lat = lat;
        this.lon = lon;
        this.alt = lat;
    }

    fun distance(b: Coordinate): Double {
        val r = 6371
        val latDistance = Math.toRadians(b.lat - this.lat)
        val lonDistance = Math.toRadians(b.lon - this.lon)
        val k = (sin(latDistance / 2) * sin(latDistance / 2)
                + (cos(Math.toRadians(this.lat))
                * cos(Math.toRadians(b.lat))
                * sin(lonDistance / 2) * sin(lonDistance / 2)))
        val c = 2 * atan2(sqrt(k), sqrt(1 - k))
        var distance = r * c * 1000
        val height = this.alt - b.alt
        distance = distance.pow(2.0) + height.pow(2.0)
        return sqrt(distance)
    }
}