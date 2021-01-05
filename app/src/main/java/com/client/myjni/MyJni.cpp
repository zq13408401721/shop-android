//
// Created by lenovo on 2021/1/5.
//

#include "com_client_myjni_MyJni.h"
JNIEXPORT jstring JNICALL Java_com_client_myjni_MyJni_sum
  (JNIEnv *, jclass){
    return  (*env)->NewStringUTF(env,"Hellow World，这是隔壁老李头的NDK的第一行代码");
}
