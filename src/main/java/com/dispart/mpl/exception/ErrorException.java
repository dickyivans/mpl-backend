package com.dispart.mpl.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorException extends RuntimeException {
    private final String message;
}
