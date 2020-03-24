package com.sophos.gorest.integration;

import com.google.gson.Gson;
import com.sophos.gorest.models.Photo;
import net.serenitybdd.core.Serenity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.sophos.gorest.util.constants.PhotoConstants.*;

public class ConsumeApiPhoto {

    /**
     * Metodo que configura la autorizacion de acceso a la api.
     *
     * @return Retorna un metodo httpGet.
     */
    public HttpGet setGetAuthorization() {
        HttpGet httpGet = new HttpGet(BASE_URL + PATH_GET + Serenity.sessionVariableCalled("id").toString());
        httpGet.setHeader("Authorization", "Bearer " + TOKEN_ACCES);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return httpGet;
    }

    /**
     * Metodo donde se captura los valores de la respuesta del apiGet.
     */
    public void responseHttpGetMethod(String responseBody) {
        Photo photo = new Photo();
        Gson gson = new Gson();
        Map<String, Object> result = (Map<String, Object>) gson.fromJson(responseBody, Map.class).get("result");
        photo.setAlbumId(result.get("album_id").toString());
        photo.setTitle(result.get("title").toString());
        photo.setUrl(result.get("url").toString());
        photo.setThumbnail(result.get("thumbnail").toString());
        Serenity.setSessionVariable("photoModelResponse").to(photo);
    }

    /**
     * Metodo que setea los header y la autorizacion para el consumo de la api.
     *
     * @param json = cuerpo del mansaje.
     * @return Retorna un metodo httpPost.
     */
    public HttpPost setPostAuthorization(String json) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(BASE_URL + PATH_POST);
        httpPost.setHeader("Authorization", "Bearer " + TOKEN_ACCES);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        return httpPost;
    }

    /**
     * Metodo que mapea la respuesta de la api, guardando el id del usuario creado.
     */
    public void responseHttpPostMethod(String responseBody) {
        Gson gson = new Gson();
        Map<String, Object> result = (Map<String, Object>) gson.fromJson(responseBody, Map.class).get("result");
        Serenity.setSessionVariable("id").to(result.get("id"));
    }
}
