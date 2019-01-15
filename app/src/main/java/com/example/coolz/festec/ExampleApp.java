package com.example.coolz.festec;

import android.app.Application;
import android.util.Log;

import com.example.coolz.latte.app.Latte;

/**
 * Created by zpw on 2018/12/3.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Example","onCreate");
        Latte.init(this).withApiHost("http://127.0.0.1/").configurator();
    }
}
