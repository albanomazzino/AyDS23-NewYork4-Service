package com.test.artist.external.artists

import ayds.newyork.songinfo.moredetails.domain.entities.Artist.NYTimesArtist
import com.test.artist.external.NYTimesArtistService
import retrofit2.Response

internal class NYTimesArtistServiceImpl(
    private val nyTimesApi: NYTimesArtistAPI,
    private val nyTimesToArtistResolver: NYTimesToArtistResolver
) : NYTimesArtistService {
    override fun getArtist(artistName: String): NYTimesArtist? {
        val callResponse = getArtistFromService(artistName)
        return nyTimesToArtistResolver.getArtistFromExternalData(callResponse.body(), artistName)
    }

    private fun getArtistFromService(artistName: String): Response<String> {
        return nyTimesApi.getArtist(artistName).execute()
    }
}