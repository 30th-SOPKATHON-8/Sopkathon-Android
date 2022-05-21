package org.sopt.sopkathon_8_android.data

data class ResponsePost(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val title: String,
        val price: String,
        val isXibal: Boolean,
        val content: String,
        val createdAt: String
    )
}
