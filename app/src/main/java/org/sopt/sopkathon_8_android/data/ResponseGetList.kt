package org.sopt.sopkathon_8_android.data

data class ResponseGetList(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<ItemData>
)
