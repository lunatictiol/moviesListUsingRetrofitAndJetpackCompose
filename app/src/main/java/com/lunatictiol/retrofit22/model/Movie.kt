package com.lunatictiol.retrofit22.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val category: String,
    val imageUrl: String,
    val name: String,
    val desc: String

)
