package com.example.rickandmortykotlin1.data.network.dto

import com.google.gson.annotations.SerializedName

data class Info (
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("prev")
    val prev: String?
)