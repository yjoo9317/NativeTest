//
// Created by Youngjoo Park on 6/5/18.
//

#include <jni.h>
#include "triangle.h"
#include "MyJNIShaderHelper.h"

#ifdef __cplusplus
extern "C" {
#endif

MyJNIShaderHelper *gHelper = NULL;
Triangle *gGLObject = NULL;

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_TriangleActivity_CreateObjectNative(JNIEnv *env,
                                                                           jobject instance,
                                                                           jobject assetManager,
                                                                           jstring pathToInternalDir) {
    gHelper = new MyJNIShaderHelper(env, instance, assetManager, pathToInternalDir);
    gGLObject = new Triangle();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_TriangleActivity_DeleteObjectNative(JNIEnv *env,
                                                                           jobject instance) {
    if (gGLObject != NULL) {
       delete gGLObject;
    }
    gGLObject = NULL;

    if (gHelper != NULL) {
       delete gHelper;
    }
    gHelper = NULL;
}


#ifdef __cplusplus
};
#endif