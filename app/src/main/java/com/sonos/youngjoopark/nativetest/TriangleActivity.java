package com.sonos.youngjoopark.nativetest;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TriangleActivity extends AppCompatActivity {

    private native void CreateObjectNative(AssetManager assetManager, String path);
    private native void DeleteObjectNative();

    private MyGLSurfaceView mGLView = null;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        AssetManager assetManager = getAssets();
        String path = getFilesDir().getAbsolutePath();

        CreateObjectNative(assetManager, path);

        setContentView(R.layout.triangle_layout);
        mGLView = (MyGLSurfaceView) findViewById(R.id.triangle_gl_surface_view);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mGLView != null) {
           mGLView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGLView != null) {
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
