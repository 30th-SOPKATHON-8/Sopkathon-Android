package org.sopt.sopkathon_8_android.data

import retrofit2.http.*

interface Service {
    @GET("/record")
    suspend fun getList(
        @Query("category") category: String
    ): ResponseGetList

    @GET("/record/total")
    suspend fun getTotal(): ResponseTotalData

    @POST("/record")
    suspend fun post(
        @Body requestPost: RequestPost
    ): ResponsePost
}