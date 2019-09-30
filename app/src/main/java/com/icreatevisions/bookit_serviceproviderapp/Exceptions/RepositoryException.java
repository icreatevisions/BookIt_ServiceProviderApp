package com.icreatevisions.bookit_serviceproviderapp.Exceptions;

public class RepositoryException extends Exception {
    RepositoryExceptionCode code;

    public RepositoryException(RepositoryExceptionCode code) {
        this.code = code;
    }

    public RepositoryException(RepositoryExceptionCode code, String error) {
        super(error);
        this.code = code;
    }

    public RepositoryException(RepositoryExceptionCode code, String error, Throwable cause) {
        super(error, cause);
        this.code = code;
    }

    public RepositoryExceptionCode getExceptionCode() {
        return this.code;
    }
}

