//
// Created by lenovo on 2021/1/6.
//

#include "com_myvideo_VideoPrase.h"

JNIEXPORT jstring JNICALL Java_com_myvideo_VideoPrase_parseName(JNIEnv *env, jclass cla){
    return (*env)->NewStringUTF(env,"来至于JNI的数据");
}

JNIEXPORT void JNICALL Java_com_myvideo_VideoPrase_callJni(JNIEnv *env, jobject obj){
    //找类
    jclass cla = (*env)->FindClass(env,"com/myvideo/VideoPrase");
    if(cla == 0){
        return;
    }
    //找方法
    jmethodID mid = (*env)->GetMethodID(env,cla,"callJava","()V");
    if(mid == 0){
        return;
    }
    (*env)->CallVoidMethod(env,obj,mid);
}
