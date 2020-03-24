package com.sophos.gorest.exceptions;

/**
 * enum para manejar los mensajes que se mostraran en caso que falle en una ejecucion
 */
public enum ExceptionsMessages {

    EXCEPTIONS_ERROR_API_RESPONSE_USER_QUERY("Photo query failed."),
    EXCEPTIONS_ERROR_API_RESPONSE_USER_CREATE("Photo creation failed."),
    EXCEPTIONS_ERROR_API_RESPONSE("Api execution failed.");

    private final String message;

    ExceptionsMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}