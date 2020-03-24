package com.sophos.gorest.tasks;

import com.sophos.gorest.exceptions.MyException;
import com.sophos.gorest.integration.ConsumeApiPhoto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.sophos.gorest.exceptions.ExceptionsMessages.EXCEPTIONS_ERROR_API_RESPONSE;
import static com.sophos.gorest.exceptions.ExceptionsMessages.EXCEPTIONS_ERROR_API_RESPONSE_USER_QUERY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/***
 * Está clase se encarga de consumir el servicio GET de Photo
 */

public class GetApi implements Task {
    private CloseableHttpClient clienteHTTP = HttpClients.createDefault();
    private ConsumeApiPhoto consumeApiPhoto = new ConsumeApiPhoto();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            ResponseHandler<String> responseHandler = response -> {
                if (response.getStatusLine().getStatusCode() >= 400) {
                    throw new MyException(EXCEPTIONS_ERROR_API_RESPONSE_USER_QUERY.getMessage());
                }
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            };
            String responseBody = this.clienteHTTP.execute(consumeApiPhoto.setGetAuthorization(), responseHandler);
            consumeApiPhoto.responseHttpGetMethod(responseBody);
        } catch (IOException ex) {
            throw new MyException(EXCEPTIONS_ERROR_API_RESPONSE.getMessage());
        }
    }

    public static GetApi method() {
        return instrumented(GetApi.class);
    }
}