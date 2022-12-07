package com.kostenko.matrix.exceptions;

public class MatrixNotFound extends RuntimeException {
    public MatrixNotFound(Exception e) {
        super(e);
    }
}
