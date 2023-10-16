package com.coolrinet.photogallery.api

import com.coolrinet.photogallery.FlickrResponse
import retrofit2.http.GET

private const val API_KEY = "a31717e733d55b0a10a0bd2a17ab5682"

interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}