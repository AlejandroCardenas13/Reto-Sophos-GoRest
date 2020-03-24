package com.sophos.gorest.util.load;

import com.google.gson.Gson;
import com.sophos.gorest.models.Photo;
import com.sophos.gorest.util.CommonFunctions;
import net.serenitybdd.core.Serenity;

import java.util.HashMap;
import java.util.Map;

import static com.sophos.gorest.util.constants.PhotoConstants.THUMBNAIL_MEDELLIN;
import static com.sophos.gorest.util.constants.PhotoConstants.URL_MEDELLIN;

/***
 * Está clase se encarga de setear el modelo photo y el Body para el servicio
 */

public class ServicePhotoData {
    private Photo photo;
    private CommonFunctions commonFunctions;
    private Map<String, String> request = new HashMap<>();
    private Gson gson = new Gson();

    public ServicePhotoData() {
        this.photo = new Photo();
        this.commonFunctions = new CommonFunctions();
    }

    /***
     * Este método se encarga de setear el modelo photo y el Body que será usado para crear Photo
     * @param dataTable es un Map <String,String> que contiene los valores traidos del feature
     * @return un String que contiene el Body necesario para el servicio
     */
    public String loadData(Map<String, String> dataTable) {
        photo.setAlbumId(commonFunctions.getRandomNumberInterval(2000, 1));
        photo.setTitle(dataTable.get("Title") + commonFunctions.getRandomNumberInterval(100, 0));
        photo.setUrl(URL_MEDELLIN);
        photo.setThumbnail(THUMBNAIL_MEDELLIN);
        Serenity.setSessionVariable("photoModel").to(photo);
        request.put("album_id", photo.getAlbumId());
        request.put("title", photo.getTitle());
        request.put("url", photo.getUrl());
        request.put("thumbnail", photo.getThumbnail());
        return gson.toJson(request);
    }

}
