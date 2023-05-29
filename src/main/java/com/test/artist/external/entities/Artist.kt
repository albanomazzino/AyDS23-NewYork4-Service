package com.test.artist.external.entities

import com.google.gson.JsonElement

const val NY_TIMES_LOGO_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"

sealed class Artist {
    data class NYTimesArtist(
        var url: String? = null,
        var info: JsonElement,
        var isLocallyStored: Boolean = false,
        var logoImageUrl: String = NY_TIMES_LOGO_URL,
    ): Artist()
    object EmptyArtist: Artist()
}
