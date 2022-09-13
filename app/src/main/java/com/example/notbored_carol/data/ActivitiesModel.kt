package com.example.notbored_carol.data

//data class ActivitiesModel(val type: String, val image: Int)

data class Category(
    val title: String,
    val activities: List<Activity> = emptyList()
    )

data class Activity(
    val action: String,
    val price: Double,
    val participants: Int
)