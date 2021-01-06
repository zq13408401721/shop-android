//
// Created by lenovo on 2021/1/5.
//
#include "com_myvideo_YVideo.h"

JNIEXPORT jstring JNICALL Java_com_myvideo_YVideo_getVideoKey(JNIEnv *env, jclass class){
    return (*env)->NewStringUTF(env,"这是jni返回的数据");
}

JNIEXPORT void JNICALL Java_com_myvideo_YVideo_callJni(JNIEnv *env, jobject obj){
    //找到需要回调的类
    jclass cla = (*env)->FindClass(env,"com/myvideo/YVideo");
    //判断是否存在
    if(cla == 0){
        return;
    }
    //找该类中对应的方法
    jmethodID methodId = (*env)->GetMethodID(env,cla,"callFromJni","()V");
    if(methodId == 0){
        return;
    }
    //调用方法
    (*env)->CallVoidMethod(env,obj,methodId);
}

//带参数的调用
JNIEXPORT void JNICALL Java_com_myvideo_YVideo_callParam(JNIEnv *env, jobject obj){
  //找到需要回调的类
    jclass cla = (*env)->FindClass(env,"com/myvideo/YVideo");
    //判断是否存在
    if(cla == 0){
        return;
    }
    //找该类中对应的方法
    jmethodID methodId = (*env)->GetMethodID(env,cla,"callFromJniParam","(Ljava/lang/String;)V");
    if(methodId == 0){
        return;
    }
    //调用方法
    (*env)->CallVoidMethod(env,obj,methodId,(*env)->NewStringUTF(env,"这是jni返回的参数"));
}


