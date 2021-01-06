package com.myvideo;


import android.util.Log;

public class YVideo {

    public static native String getVideoKey();

    public native void callJni();

    public native void callParam();

    private void callFromJni(){
        Log.i("TAG","jni");
    }

    private void callFromJniParam(String param){
        Log.i("TAG",param);
    }

}
