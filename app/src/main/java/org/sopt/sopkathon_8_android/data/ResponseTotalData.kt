package org.sopt.sopkathon_8_android.data

data class ResponseTotalData(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val nickname: String,
        val totalPrice: String,
        val xibalPrice: String,
        val sibalPrice: String
    )
}
