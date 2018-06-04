package com.sonos.youngjoopark.nativetest;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

public class MyGLSurfaceView extends GLSurfaceView {
    private static final int VERSION2 = 2;
    private MyGLRenderer mRenderer;
    public MyGLSurfaceView(Context context, AttributeSet attr) {
        super(context);
        try {

            setEGLContextClientVersion(VERSION2);
            mRenderer = new MyGLRenderer();
            setRenderer(mRenderer);

            setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        } catch (Exception e) {
            Log.e("MyGLSurfaceView", "unable to create GLES context: ", e);
        }

        Log.w("MyGLSurfaceView", "successfully created GLES context.");
    }
}
