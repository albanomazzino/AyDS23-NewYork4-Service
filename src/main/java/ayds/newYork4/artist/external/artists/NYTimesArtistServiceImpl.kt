package ayds.newYork4.artist.external.artists

import ayds.newYork4.artist.external.entities.Artist.NYTimesArtist
import ayds.newYork4.artist.external.NYTimesArtistService
import retrofit2.Response

internal class NYTimesArtistServiceImpl(
    private val nyTimesApi: NYTimesArtistAPI,
    private val nyTimesToArtistResolver: NYTimesToArtistResolver
) : NYTimesArtistService {
    override fun getArtist(artistName: String): NYTimesArtist? {
        val callResponse = getArtistFromService(artistName)
        return nyTimesToArtistResolver.getArtistFromExternalData(callResponse.body())
    }

    private fun getArtistFromService(artistName: String): Response<String> {
        return nyTimesApi.getArtist(artistName).execute()
    }
}