package com.test.artist.external

import com.test.artist.external.entities.Artist

interface NYTimesArtistService {
    fun getArtist(artistName: String): Artist.NYTimesArtist?
}
