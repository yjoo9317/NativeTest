package com.sonos.youngjoopark.nativetest;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class Gestures {

    private GestureDetectorCompat mTapScrollDetector;
    private ScaleGestureDetector mScaleDetector;

    private static final int INVALID_POINTER_ID = -100;
    private int mTwoFingerPointerId = INVALID_POINTER_ID;

    private native void doubleTapNative();
    private native void scrollNative(float distanceX, float distanceY, float positionX, float positionY);
    private native void scaleNative(float scaleFactor);
    private native void moveNative(float distanceX, float distanceY);

    public Gestures(Context context) {
        mTapScrollDetector = new GestureDetectorCompat(context, new TapScrollListener());
        mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    public View.OnTouchListener TwoFingerGestureListener = new View.OnTouchListener() {

        private float mLastX, mLastY;
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            mTapScrollDetector.onTouchEvent(event);
            mScaleDetector.onTouchEvent(event);
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    //------------------------------------------------------------------
                    // Track down the drag only when two fingers are on the screen
                    if(mTwoFingerPointerId != INVALID_POINTER_ID) {
                        final float x = event.getX(mTwoFingerPointerId);
                        final float y = event.getY(mTwoFingerPointerId);

                        final float dX = x - mLastX;
                        final float dY = y - mLastY;

                        mLastX = x;
                        mLastY = y;
                        moveNative(dX, dY);
                    }
                    //------------------------------------------------------------------
                    break;
                case MotionEvent.ACTION_UP:
                    mTwoFingerPointerId = INVALID_POINTER_ID;
                    break;
                case MotionEvent.ACTION_CANCEL:
                    mTwoFingerPointerId = INVALID_POINTER_ID;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    mTwoFingerPointerId = event.getActionIndex();
                    final float x = event.getX(mTwoFingerPointerId);
                    final float y = event.getY(mTwoFingerPointerId);

                    mLastX = x;
                    mLastY = y;
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    mTwoFingerPointerId = INVALID_POINTER_ID;
                    break;
            }

            return true;
        }
    };

    class TapScrollListener extends GestureDetector.SimpleOnGestureListener {

        public boolean onDoubleTap(MotionEvent event) {
            doubleTapNative();
            return true;
        }

        public boolean onScroll(MotionEvent event1, MotionEvent event2,
                                float distanceX, float distanceY) {
            // when two fingers or multiple fingers on the screen,
            // it ignores.
            if(mTwoFingerPointerId == INVALID_POINTER_ID) {
                scrollNative(distanceX, distanceY, event2.getX(), event2.getY());
            }
            return true;
        }
    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleNative(detector.getScaleFactor());
            return true;
        }
    }
}

