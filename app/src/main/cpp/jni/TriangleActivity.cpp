//
// Created by Youngjoo Park on 6/5/18.
//

#include <jni.h>
#include "triangle.h"
#include "MyJNIShaderHelper.h"

#ifdef __cplusplus
extern "C" {
#endif

MyJNIShaderHelper *gHelperObject = NULL;
Triangle *gTriangleObject = NULL;

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_TriangleActivity_CreateObjectNative(JNIEnv *env,
                                                                           jobject instance,
                                                                           jobject assetManager,
                                                                           jstring pathToInternalDir) {
    gHelperObject = new MyJNIShaderHelper(env, instance, assetManager, pathToInternalDir);
    gTriangleObject = new Triangle();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_TriangleActivity_DeleteObjectNative(JNIEnv *env,
                                                                           jobject instance) {
    if (gTriangleObject != NULL) {
       delete gTriangleObject;
    }
    gTriangleObject = NULL;

    if (gHelperObject != NULL) {
       delete gHelperObject;
    }
    gHelperObject = NULL;

}


#ifdef __cplusplus
};
#endif