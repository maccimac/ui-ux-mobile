/**
 * STEPS
 * 1. View binding: Attach binding to Gradle; Sync
 * 2. Create CustomTouchListener >  With GestureDetectorListener
 * 3. GestureDetector.SimpleOnGestureListener : Right click > Generate all methods
 * 4. Ensure onDown returns false = If this is not false, the rest will not show
 * 5. Create custom method onDoubleClick and attach to onDoubleTap
 * 5.1. Apply #5 to onSingleClick, onSwipeLeft, onSwipeRight
 *
 */



package com.example.ux_mids_grocery_groovy;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ux_mids_grocery_groovy.databinding.*;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);

//        binding.mainFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "HI", Toast.LENGTH_SHORT).show();
//            }
//        });


        binding.mainFab.setOnTouchListener(
                new GrCustomTouchListener(MainActivity.this){

                    @Override
                    public void onSingleClick() {
                        Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();
                        super.onSingleClick();
                    }

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return super.onTouch(v, event);
                    }

                    @Override
                    public void onDoubleClick(){
                        Log.d(
                                "MAC",
                                "double click"
                        );

                        Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();
                        super.onDoubleClick();
                    }
                }
        );
    }
}