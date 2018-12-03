package com.example.coolz.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by zpw on 2018/12/3.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
