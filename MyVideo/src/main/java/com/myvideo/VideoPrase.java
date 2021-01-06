package com.myvideo;

import android.util.Log;

public class VideoPrase {

    public static native String parseName();

    public native void callJni();

    private void callJava(){
        Log.i("TAG","callJava");
    }

}
