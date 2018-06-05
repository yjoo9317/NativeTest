//
// Created by Youngjoo Park on 6/4/18.
//

#include <jni.h>
#include <shapes/triangle.h>

#include "glesNative.h"

#ifdef __cplusplus
extern "C" {
#endif

//extern GLESNative *gGLObject;
extern Triangle *gGLObject;

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_DrawFrameNative(JNIEnv *env,
                                                         jobject instance) {
    if (gGLObject == NULL) {
        return;
    }
    gGLObject->Render();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_SurfaceCreatedNative(JNIEnv *env,
                                                              jobject instance) {

    MyLOGW("Native Surface created called..");
    if (gGLObject == NULL) {
        MyLOGE("[SurfaceCreatedNative] GLESNative instance is null. ");
        return;
    }
    gGLObject->initGL();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_SurfaceChangedNative(JNIEnv *env,
                                                              jobject instance,
                                                              jint width,
                                                              jint height) {
    if (gGLObject == NULL) {
        return;
    }
    gGLObject->SetViewport(width, height);
}
#ifdef __cplusplus
};
#endif


