package com.sonos.youngjoopark.nativetest;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private native void DrawFrameNative();
    private native void SurfaceCreatedNative();
    private native void SurfaceChangedNative(int width, int height);

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.w("MyGLRenderer", "surface created called..");
        SurfaceCreatedNative();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        SurfaceChangedNative(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        DrawFrameNative();
    }
}
