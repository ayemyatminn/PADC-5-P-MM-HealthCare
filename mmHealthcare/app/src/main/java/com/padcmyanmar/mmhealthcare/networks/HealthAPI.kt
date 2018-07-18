package com.padcmyanmar.mmhealthcare.networks


import com.padcmyanmar.mmhealthcare.networks.responses.GetHealthResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

interface HealthAPI {

    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealth(@Field("access_token") accessToken: String): Observable<GetHealthResponse>

}