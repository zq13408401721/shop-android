package com.client.app;

import android.app.Application;
import android.provider.MediaStore;
import android.util.Log;

import com.client.utils.SpUtils;
import com.live.MyApplication;
import com.myvideo.VideoPrase;
import com.myvideo.YVideo;

public class MyApp extends Application {
    private static String[] modules = {"com.live.MyApplication"};

    public static MyApp app;

    //加载so库
    static {
        System.loadLibrary("YVideo");
        System.loadLibrary("VideoPrase");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        SpUtils.getInstance().setValue("image",true);

        initMoudles();
        testSo();
    }

    private void testSo(){
        Log.i("TAG",YVideo.getVideoKey());
        YVideo yVideo = new YVideo();
        yVideo.callJni();
        yVideo.callParam();

        String name = VideoPrase.parseName();
        Log.i("TAG",name);
        VideoPrase videoPrase = new VideoPrase();
        videoPrase.callJni();
    }

    private void initMoudles() {
        for (String moduleImpl : modules){
            try {
                Class<?> clazz = Class.forName(moduleImpl);
                Object obj = clazz.newInstance();
                if (obj instanceof MyApplication){
                    ((MyApplication) obj).initApp(app);
                    String token = SpUtils.getInstance().getString("token");
                    ((MyApplication) obj).initToken(token);
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
