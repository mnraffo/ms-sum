package com.tenpo.sum.constant;

import org.springframework.http.HttpStatus;

import java.net.URI;

public enum ProblemType {

    HTTP_BAD_REQUEST(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400"),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            HttpStatus.BAD_REQUEST.name(),
            HttpStatus.BAD_REQUEST.value()
    ),

    HTTP_MESSAGE_NOT_READABLE(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400"),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            HttpStatus.BAD_REQUEST.name(),
            HttpStatus.BAD_REQUEST.value()
    ),

    HTTP_MEDIA_TYPE_NOT_SUPPORTED(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/415"),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase(),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.name(),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()
    ),

    HTTP_METHOD_NO_FOUND(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404"),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            HttpStatus.NOT_FOUND.name(),
            HttpStatus.NOT_FOUND.value()
    ),

    HTTP_REQUEST_METHOD_NOT_SUPPORTED(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/405"),
            HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
            HttpStatus.METHOD_NOT_ALLOWED.name(),
            HttpStatus.METHOD_NOT_ALLOWED.value()
    ),

    COMMUNICATION_ERROR(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/502"),
            HttpStatus.BAD_GATEWAY.getReasonPhrase(),
            HttpStatus.BAD_GATEWAY.name(),
            HttpStatus.BAD_GATEWAY.value()
    ),

    RESOURCE_NOT_FOUND(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404"),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            HttpStatus.NOT_FOUND.name(),
            HttpStatus.NOT_FOUND.value()
    ),

    BUSINESS_ERROR(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/422"),
            HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(),
            HttpStatus.UNPROCESSABLE_ENTITY.name(),
            HttpStatus.UNPROCESSABLE_ENTITY.value()
    ),

    TOO_MANY_REQUESTS(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429"),
            HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase(),
            HttpStatus.TOO_MANY_REQUESTS.name(),
            HttpStatus.TOO_MANY_REQUESTS.value()
    ),

    INTERNAL_SERVER_ERROR(
            URI.create("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500"),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            HttpStatus.INTERNAL_SERVER_ERROR.name(),
            HttpStatus.INTERNAL_SERVER_ERROR.value()
    );

    public final URI type;
    public final String title;
    public final String code;
    public final int status;

    ProblemType(URI type, String title, String code, int status) {
        this.type = type;
        this.title = title;
        this.code = code;
        this.status = status;
    }
}
