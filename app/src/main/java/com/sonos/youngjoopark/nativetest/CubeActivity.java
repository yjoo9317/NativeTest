package com.sonos.youngjoopark.nativetest;

import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CubeActivity extends AppCompatActivity {

    private MyGLSurfaceView mGLView = null;
    private native void CreateObjectNative(AssetManager assetManager, String path);
    private native void DeleteObjectNative();
    Gestures mGesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AssetManager assetManager = getAssets();
        String path = getFilesDir().getAbsolutePath();

        CreateObjectNative(assetManager, path);

        setContentView(R.layout.cube_layout);
        mGLView = findViewById(R.id.cube_gl_surface_view);

        //-------------------------------------------------------------------------------------
        // touch events on GLView will be taken care of by mGesture.TwofingerGestureListener
        mGesture = new Gestures(this);
        mGLView.setOnTouchListener(mGesture.TwoFingerGestureListener);
        //-------------------------------------------------------------------------------------

    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mGLView != null) {
            mGLView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mGLView != null) {
            mGLView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        DeleteObjectNative();
    }
    static {
        System.loadLibrary("GLESNative");
    }
}
