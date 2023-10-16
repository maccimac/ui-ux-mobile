

package com.example.ux_mids_grocery_groovy;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;

public class GrCustomTouchListener implements View.OnTouchListener{

    Context context;
    GestureDetectorCompat gestureDetectorCompat;

    // CONSTRUCTOR 1:
    public GrCustomTouchListener(Context context){
        this.context = context;
        this.gestureDetectorCompat = new GestureDetectorCompat(
                context, new CustomGestureListener()
        );

    }

    public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(@NonNull MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(@NonNull MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return false;
//            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(@NonNull MotionEvent e) {
            return super.onContextClick(e);
        }
//        public CustomGestureListener() {
//            super();
//        }

    }


    // CONSTRUCTOR 2:
//    public GrCustomTouchListener extends GestureDetector.SimpleOnGestureListener{
//
//    }

    public void onDoubleClick(){
        Toast.makeText(context, "I just wanted to show a toast. DoubleClick", Toast.LENGTH_SHORT).show();
    }

    public void onSingleClick(){
        Toast.makeText(context, "I just wanted to show a toast", Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        return false;
        return gestureDetectorCompat.onTouchEvent(event);
    }


}
   