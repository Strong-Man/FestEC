package com.example.coolz.latte.net;


import android.content.Context;

import com.example.coolz.latte.net.callback.IError;
import com.example.coolz.latte.net.callback.IFailure;
import com.example.coolz.latte.net.callback.IRequest;
import com.example.coolz.latte.net.callback.ISuccess;
import com.example.coolz.latte.net.callback.RequestCallbacks;
import com.example.coolz.latte.ui.LatteLoader;
import com.example.coolz.latte.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.RequestBody;

public class RestClient {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;

     RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IError error, IFailure failure, RequestBody body,Context context, LoaderStyle loaderStyle) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
    }

    private void request(HttpMethod method){
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if(REQUEST != null){
            REQUEST.onRequestStart();
        }

        if(LOADER_STYLE != null){
            LatteLoader.showLoading(CONTEXT,LOADER_STYLE);
        }
        switch (method){
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
//                final RequestBody requestBody =
//                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
//                final MultipartBody.Part body =
//                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
//                call = service.upload(URL, body);
                break;
            default:
                break;
        }

        if(call != null){
            call.enqueue(getRequestCallback());
        }
    }

    public static RestClientBuilder builder(){
        return  new RestClientBuilder();
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(REQUEST,SUCCESS,FAILURE,ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }
}
