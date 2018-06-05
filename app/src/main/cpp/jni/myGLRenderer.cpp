//
// Created by Youngjoo Park on 6/4/18.
//

#include <jni.h>

#include "glesNative.h"

#ifdef __cplusplus
extern "C" {
#endif

extern GLESNative *gGlesObject;

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_DrawFrameNative(JNIEnv *env,
                                                         jobject instance) {
    if (gGlesObject == NULL) {
        return;
    }
    gGlesObject->Render();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_SurfaceCreatedNative(JNIEnv *env,
                                                              jobject instance) {

    MyLOGW("Native Surface created called..");
    if (gGlesObject == NULL) {
        MyLOGE("[SurfaceCreatedNative] GLESNative instance is null. ");
        return;
    }
    gGlesObject->PerformGLInits();
}

JNIEXPORT void JNICALL
Java_com_sonos_youngjoopark_nativetest_MyGLRenderer_SurfaceChangedNative(JNIEnv *env,
                                                              jobject instance,
                                                              jint width,
                                                              jint height) {
    if (gGlesObject == NULL) {
        return;
    }
    gGlesObject->SetViewport(width, height);
}
#ifdef __cplusplus
};
#endif


