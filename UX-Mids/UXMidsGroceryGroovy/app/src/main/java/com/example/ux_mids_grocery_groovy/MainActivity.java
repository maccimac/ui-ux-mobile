package com.example.ux_mids_grocery_groovy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ux_mids_grocery_groovy.databinding.*;
import com.example.ux_mids_grocery_groovy.model.GroceryItem;
import com.example.ux_mids_grocery_groovy.adapters.GroceryAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * TOUCH LISTENERS
 * 0. Create Recycler View .xml layout (grocery_list_item)
 * 1. View binding: Attach binding to Gradle; Sync
 * 2. Create CustomTouchListener >  With GestureDetectorListener
 * 3. GestureDetector.SimpleOnGestureListener : Right click > Generate all methods
 * 4. Ensure onDown returns false = If this is not false, the rest will not show
 * 5. Create custom method onDoubleClick and attach to onDoubleTap
 * 5.1. Apply #5 to onSingleClick, onSwipeLeft, onSwipeRight
 *
 * RECYCLER VIEW
 * I. Create GroceryAdapter, see file
 * II. Create simple GroceryItem class
 * III. Attach adapter
 *
 */


public class MainActivity extends AppCompatActivity {

    List<GroceryItem> gList;

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

        gList = new ArrayList<GroceryItem>();
        gList.add(new GroceryItem("tomatoes", R.drawable.tomato));
        gList.add(new GroceryItem("cucumbers", R.drawable.cucumber));
        gList.add(new GroceryItem("mushrooms", R.drawable.mushroom));

        GroceryAdapter groceryAdapter = new GroceryAdapter(gList);
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        binding.recyclerViewGroceryList.setLayoutManager(lm);
        binding.recyclerViewGroceryList.setAdapter(groceryAdapter);


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