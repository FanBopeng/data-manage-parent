package com.master.slave.config;

public class RouteContext implements AutoCloseable {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setRouteKey (String key){
        threadLocal.set(key);
    }

    public static String getRouteKey() {
        String key = threadLocal.get();
        return key == null ? "masterDataSource" : key;
    }

    @Override
    public void close() {
        threadLocal.remove();
    }
}
