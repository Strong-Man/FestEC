package com.example.coolz.latte.net;


import com.example.coolz.latte.net.callback.IError;
import com.example.coolz.latte.net.callback.IFailure;
import com.example.coolz.latte.net.callback.IRequest;
import com.example.coolz.latte.net.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

public class RestClient {
    private final String URL;
    private final Map<String, Object>  PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;

     RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IError error, IFailure failure, RequestBody body) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
    }

    public static RestClientBuilder builder(){
        return  new RestClientBuilder();
    }
}
