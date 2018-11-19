package com.majimo.dev.starwarsinfo.repository

data class PlanetRepository (
    val name: String,
    val rotation_period: Int,
    val orbital_period: Int,
    val diameter: Int,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surface_water: Int,
    val population: Int,
    val residents: Array<String>,
    val films: Array<String>,
    val created: String,
    val edited: String,
    val url: String
)