package com.sonos.youngjoopark.nativetest;

import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;

public class CubeActivity extends AppCompatActivity {

    private GLSurfaceView mGLView = null;
    private native void CreateObjectNative(AssetManager assetManager, String path);
    private native void DeleteObjectNative();
    Gestures mGesture;
}
