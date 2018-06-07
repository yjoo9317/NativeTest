package com.sonos.youngjoopark.nativetest;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;

public class Gestures {

    private GestureDetectorCompat mTapScrollDetector;
    private ScaleGestureDetector mScaleDetector;

    private static final int INVALID_POINTER_ID = -100;

    private native void doubleTapNative();
    private native void scrollNative(float distanceX, float distanceY, float positionX, float positionY);
    private native void scaleNative(float scaleFactor);
    private native void moveNative(float distanceX, float distanceY);

    public Gestures(Context context) {
        mTapScrollDetector = new GestureDetectorCompat(context, new TapScrollListener());
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }


    class TapScrollListener extends GestureDetector.SimpleOnGestureListener {

    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    }
}

