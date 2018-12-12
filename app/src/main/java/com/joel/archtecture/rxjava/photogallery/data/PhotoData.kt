package com.joel.archtecture.rxjava.photogallery.data
import com.google.gson.annotations.SerializedName



data class PhotoData(
		@SerializedName("name") val name: String,
		@SerializedName("small") val small: String,
		@SerializedName("medium") val medium: String,
		@SerializedName("large") val large: String,
		@SerializedName("description") val description: String,
		@SerializedName("timestamp") val timestamp: String
)