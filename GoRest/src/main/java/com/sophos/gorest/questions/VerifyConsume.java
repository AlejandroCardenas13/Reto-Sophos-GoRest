package com.sophos.gorest.questions;

import com.sophos.gorest.models.Photo;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

/**
 *  Clase encargada de validar que el servicio POST si creo el registro photo correctamente.
 */

public class VerifyConsume implements Question<Boolean> {
    private Photo photo;
    private Photo responsePhoto = Serenity.sessionVariableCalled("photoModelResponse");

    private VerifyConsume(Photo photo) {
        this.photo = photo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(photo.getAlbumId()).isEqualTo(responsePhoto.getAlbumId()),
                Ensure.that(photo.getTitle()).isEqualTo(responsePhoto.getTitle()),
                Ensure.that(photo.getUrl()).isEqualTo(responsePhoto.getUrl()),
                Ensure.that(photo.getThumbnail()).isEqualTo(responsePhoto.getThumbnail())
        );

        return true;
    }

    public static VerifyConsume checkToResponse(Photo photo) {
        return new VerifyConsume(photo);
    }
}
