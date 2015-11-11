package com.out.outer.api.request;

public abstract class AbstractApiCallbacks<T> {




    protected void onRequestFail(ApiResponse<T> response) {

    }

    protected abstract void onSuccess(ApiResponse<T> response);

}
