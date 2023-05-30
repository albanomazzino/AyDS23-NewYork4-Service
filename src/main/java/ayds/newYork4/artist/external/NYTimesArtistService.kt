package ayds.newYork4.artist.external

import ayds.newYork4.artist.external.entities.Artist

interface NYTimesArtistService {
    fun getArtist(artistName: String): Artist.NYTimesArtist?
}
