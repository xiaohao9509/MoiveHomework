package com.nick.moivehomework.entities;

/**
 * Created by Administrator on 2016/3/30.
 */
public class ErrorResponse {
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
