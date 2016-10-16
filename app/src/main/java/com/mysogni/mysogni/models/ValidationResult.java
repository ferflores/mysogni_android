package com.mysogni.mysogni.models;

public class ValidationResult {
    public boolean isError;
    public String message;

    public ValidationResult(boolean isError, String message){
        this.isError = isError;
        this.message = message;
    }
}
