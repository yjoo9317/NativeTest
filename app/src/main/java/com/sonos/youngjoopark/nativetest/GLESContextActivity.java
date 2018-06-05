package com.sonos.youngjoopark.nativetest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GLESContextActivity extends AppCompatActivity {
    private static final String TAG = "GLESContextActivity";

    private TextView mTextView = null;
    private MyGLSurfaceView mGLView = null;
    private String version="";
    /*
    private native void CreateObjectNative();
    private native void DeleteObjectNative();
    private native String GetGLESVersionNative();
    private native boolean IsInitsDoneNative();
*/
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("GLESNative");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // CreateObjectNative();

        //mGLView = new MyGLSurfaceView(this);
        //setContentView(mGLView);
        setContentView(R.layout.gl_context);
        mGLView = (MyGLSurfaceView) findViewById(R.id.gl_surface_view);
        mTextView = (TextView) findViewById(R.id.gl_version_textview);
    }

    @Override
    protected  void onResume() {
        super.onResume();
        if (mGLView != null) {
           mGLView.onResume();
        }

        new AsyncDisplayText().execute();
    }

    @Override
    protected void onPause () {
        super.onPause();

        if(mGLView != null) {
            mGLView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    //    DeleteObjectNative();
    }


    class AsyncDisplayText extends AsyncTask<Void, String, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
         /*   while(!IsInitsDoneNative()){
                try {
                    Thread.sleep(100);
                    Log.w(TAG, "GL not initialized.");
                } catch (InterruptedException e) {

                } catch (Exception e) {

                }
            }*/
            return 0;
        }

        @Override
        protected void onPostExecute(Integer result) {
           // displayGLVersion(GetGLESVersionNative());
        }
    }

    void displayGLVersion(String version) {
        Log.w(TAG, "GLES Version: "+version);

        if (mTextView != null) {
           mTextView.setText(version);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
