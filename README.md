# AyDS23-NewYork4-Service

New York Times External Service provided by AyDS23-NewYork4 Team.

## Available methods

`com.test.artist.external.NYTimesArtistService::getArtist(artistName: String): NYTimesArtist?`

- `NYTimesArtistService` is an interface designed to search an article of the given artist in The New York Times newspaper, and return an object of type `NYTimesArtist?`.
- It is implemented by `com.test.artist.external.artists.NYTimesArtistServiceImpl`.
- If the method return `null`, then your implementation must identify this and use the `EmptyArtist` object instead.

## The Artist class

`com.test.artist.external.entities.Artist`

- `Artist` is a sealed class encapsulating `NYTimesArtist` and `EmptyArtist`. The former has 3 attributes: `url`, `info`, and `isLocallyStored`, whilst the latter has none.
  - `NYTimesArtist`
    - `url: String?` contains the URL to a full article on The New York Times website. Use this URL in a button or anchor to link to more information about the artist. The default value is `null`.
    - `info: String?` contains a brief description of the artist, pre-formatted to highlight the name of the artist <ins>**in HTML**</ins>. The default value is `""` (an empty string).
    - `isLocallyStored: Boolean` allows you to manage whether this information is loaded from local storage or our service. Our service will always set this value to `false`.

