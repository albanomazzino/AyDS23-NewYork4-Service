package com.test.artist.external

import ayds.newyork.songinfo.moredetails.domain.entities.Artist.NYTimesArtist

interface NYTimesArtistService {
    fun getArtist(artistName: String): NYTimesArtist?
}
