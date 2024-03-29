package ru.random_user.data.retrofit.dto

import ru.random_user.data.retrofit.dto.Timezone

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: Street,
    val timezone: Timezone
)