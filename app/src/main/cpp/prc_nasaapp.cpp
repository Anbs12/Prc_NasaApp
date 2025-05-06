// Write C++ code here.
//
// Do not forget to dynamically load the C++ library into your application.
//
// For instance,
//
// In MainActivity.java:
//    static {
//       System.loadLibrary("prc_nasaapp");
//    }
//
// Or, in MainActivity.kt:
//    companion object {
//      init {
//         System.loadLibrary("prc_nasaapp")
//      }
//    }
#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_prc_1nasaapp_ConfigApp_getApiKey(JNIEnv *env, jobject instance) {
    return env->NewStringUTF("yJPcDJNN6F62JFCeqdOU6mPc7wWpmAa9CEc6p8Gt");
}