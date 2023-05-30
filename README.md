# AyDS23-NewYork4-Service

New York Times External Service provided by AyDS23-NewYork4 Team.

## Available methods

```kotlin
package ayds.newYork4.artist.external

import ayds.newYork4.artist.external.entities.Artist.NYTimesArtist

interface NYTimesArtistService {
    fun getArtist(artistName: String): NYTimesArtist?
}
```

- `NYTimesArtistService` is an interface designed to search an article of the given artist in The New York Times newspaper, and return an object of type `NYTimesArtist?`.
- It is implemented by `ayds.newYork4.artist.external.artists.NYTimesArtistServiceImpl`.
- If the method returns `null`, then your implementation must identify this and use the `EmptyArtist` object instead, or whichever implementation you prefer.
- To access the implementation, you may use the corresponding injector: `ayds.newYork4.artist.external.artists.NYTimesArtistInjector`. This injector is a Singleton object and provides the service as a public constant.

## The Artist class

```kotlin
package ayds.newYork4.artist.external.entities.Artist

import ayds.newYork4.artist.external.entities.Artist.NYTimesArtist
import ayds.newYork4.artist.external.entities.Artist.EmptyArtist
import ayds.newYork4.artist.external.entities.NY_TIMES_LOGO_URL
```

- `Artist` is a `sealed class` encapsulating `NYTimesArtist` and `EmptyArtist`. The former has 2 attributes: `url` and `info`, whilst the latter has none.
  - `NYTimesArtist`
    - `info: String` contains a brief description of the artist.
    - `url: String?` contains the URL to a full article on The New York Times website. Use this URL in a button or anchor to link to more information about the artist. The default value is `null`.
- Find the newspaper's logo URL in the corresponding constant: `ayds.newYork4.artist.external.entities.NY_TIMES_LOGO_URL`.
