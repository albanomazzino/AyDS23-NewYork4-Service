package ayds.newYork4.artist.external.artists

import ayds.newYork4.artist.external.entities.Artist.NYTimesArtist
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

interface NYTimesToArtistResolver {
    fun getArtistFromExternalData(serviceData: String?): NYTimesArtist?
}

internal class JsonToArtistResolver : NYTimesToArtistResolver {
    companion object {
        const val JSON_OBJECT_DOCS = "docs"
        const val JSON_OBJECT_WEB_URL = "web_url"
        const val JSON_OBJECT_RESPONSE = "response"
        const val JSON_OBJECT_ABSTRACT = "abstract"
    }

    override fun getArtistFromExternalData(serviceData: String?): NYTimesArtist? =
        try {
            val responseInJson = apiResponseToJsonObject(serviceData)
            NYTimesArtist(
                getDocumentAbstract(responseInJson),
                getArtistUrl(responseInJson)
            )
        } catch (e: Exception){
            null
        }

    private fun apiResponseToJsonObject(serviceData: String?): JsonObject {
        val jsonObject = Gson().fromJson(serviceData, JsonObject::class.java)
        return jsonObject[JSON_OBJECT_RESPONSE].asJsonObject
    }

    private fun getDocumentAbstract(responseInJson: JsonObject): String {
        return getDocument(responseInJson)[JSON_OBJECT_ABSTRACT].asString
    }

    private fun getDocument(responseInJson: JsonObject): JsonObject {
        val documents = responseInJson[JSON_OBJECT_DOCS].asJsonArray
        return documents[0].asJsonObject
    }

    private fun getArtistUrl(responseInJson: JsonObject?):String {
        return if(responseInJson != null){
            getDocumentUrl(responseInJson).asString
        } else {
            ""
        }
    }

    private fun getDocumentUrl(responseInJson: JsonObject): JsonElement {
        return getDocument(responseInJson)[JSON_OBJECT_WEB_URL]
    }
}