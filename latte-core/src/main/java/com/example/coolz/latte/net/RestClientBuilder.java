package com.example.coolz.latte.net;

import com.example.coolz.latte.net.callback.IError;
import com.example.coolz.latte.net.callback.IFailure;
import com.example.coolz.latte.net.callback.IRequest;
import com.example.coolz.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by zpw on 2019/1/4.
 */

public class RestClientBuilder {
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private String mUrl = null;
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String, Object> params) {
        this.PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String k, Object v) {
        this.PARAMS.put(k, v);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mIError = error;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request){
        this.mIRequest = request;
        return this;
    }

    public final RestClient build(){
        return  new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIError,mIFailure,mBody);
    }
}
