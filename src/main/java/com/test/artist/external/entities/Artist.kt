package com.test.artist.external.entities

sealed class Artist {
    data class NYTimesArtist(
        var url: String? = null,
        var info: String? = "",
        var isLocallyStored: Boolean = false,
    ): Artist()
    object EmptyArtist: Artist()
}