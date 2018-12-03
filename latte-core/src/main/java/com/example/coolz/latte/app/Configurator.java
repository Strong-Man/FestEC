package com.example.coolz.latte.app;

import java.util.WeakHashMap;

/**
 * Created by zpw on 2018/12/3.
 */

public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    final WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public final void configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
