package com.example.coolz.festec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.coolz.latte.delegates.LatteDelegate;
import com.example.coolz.latte.net.RestClient;
import com.example.coolz.latte.net.RestClientBuilder;
import com.example.coolz.latte.net.callback.IError;
import com.example.coolz.latte.net.callback.IFailure;
import com.example.coolz.latte.net.callback.ISuccess;

/**
 * Created by zpw on 2018/12/7.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    private void testRestClient() {
        RestClient.builder().url("")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onErrod(int code, String msg) {

            }
        }).build();
    }
}
