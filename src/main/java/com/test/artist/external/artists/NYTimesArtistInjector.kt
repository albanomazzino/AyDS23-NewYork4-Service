package com.test.artist.external.artists

import com.test.artist.external.NYTimesArtistService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object NYTimesArtistInjector {

    private const val NY_TIMES_API_URL = "https://api.nytimes.com/svc/search/v2/"
    private val nyTimesApiRetrofit = Retrofit.Builder()
        .baseUrl(NY_TIMES_API_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val nyTimesApi: NYTimesArtistAPI = nyTimesApiRetrofit.create(NYTimesArtistAPI::class.java)
    private val nyTimesToArtistResolver: NYTimesToArtistResolver = JsonToArtistResolver()

    val nyTimesArtistService: NYTimesArtistService = NYTimesArtistServiceImpl(
        nyTimesApi,
        nyTimesToArtistResolver
    )
}