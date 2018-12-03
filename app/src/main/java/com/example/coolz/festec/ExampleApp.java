package com.example.coolz.festec;

import android.app.Application;
import com.example.coolz.latte.app.Latte;

/**
 * Created by zpw on 2018/12/3.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).configurator();
    }
}
