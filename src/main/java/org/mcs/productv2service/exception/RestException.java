package org.mcs.productv2service.exception;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException {

    private Long productId;

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Long productId) {
        super(message);
        this.productId = productId;
    }
}
