package org.example.dto;


import org.example.enums.BillStatus;
import org.example.enums.ResponseType;
import org.example.models.Token;

public class IssueTokenResponseDTO {

    private Token token;
    private String failureMessage;
    private ResponseType responseType;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
}
