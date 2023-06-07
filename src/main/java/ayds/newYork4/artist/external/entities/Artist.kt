package ayds.newYork4.artist.external.entities

const val NY_TIMES_LOGO_URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"

sealed class Artist {
    data class NYTimesArtist(
        var info: String,
        var url: String
    ): Artist()
    object EmptyArtist: Artist()
}
