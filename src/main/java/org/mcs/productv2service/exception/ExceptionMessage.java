package org.mcs.productv2service.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum ExceptionMessage {

    NULL_POINTER("nothing to found");

    @Getter
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

}
