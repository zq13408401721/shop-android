package com.client.app;

import android.app.Application;

import com.client.utils.SpUtils;
import com.live.MyApplication;

public class MyApp extends Application {
    private static String[] modules = {"com.live.MyApplication"};

    public static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        SpUtils.getInstance().setValue("image",true);

        initMoudles();
    }

    private void initMoudles() {
        for (String moduleImpl : modules){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof MyApplication){
                    ((MyApplication) obj).initApp(app);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
