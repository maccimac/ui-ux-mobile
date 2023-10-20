package com.example.ux_mids_grocery_groovy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ux_mids_grocery_groovy.databinding.*;
import com.example.ux_mids_grocery_groovy.model.GroceryItem;
import com.example.ux_mids_grocery_groovy.adapters.GroceryAdapter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
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
 * 1. Populate list
 * 2. Create new adapter instance holding list: new GroceryAdapter(gList)
 * 3. Create layout manager or grid manager
 * 4. Apply layout manager to recyvclerView element
 * 5. Aplly adapter to recyclerView element
 *
 * SWIPING
 *
 *
 */


public class MainActivity extends AppCompatActivity {

    List<GroceryItem> gList;
    public int groceryImgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        groceryImgId = R.drawable.groocery_bag;

//        setContentView(R.layout.activity_main);

//        binding.mainFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "HI", Toast.LENGTH_SHORT).show();
//            }
//        });

        gList = new ArrayList<GroceryItem>();
        gList.add(new GroceryItem("tomatoes", R.drawable.tomato, groceryImgId));
        gList.add(new GroceryItem("cucumbers", R.drawable.cucumber, groceryImgId));
        gList.add(new GroceryItem("mushrooms", R.drawable.mushroom, groceryImgId));

        GroceryAdapter groceryAdapter = new GroceryAdapter(gList);
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        binding.recyclerViewGroceryList.setLayoutManager(lm);
        binding.recyclerViewGroceryList.setAdapter(groceryAdapter);

        // ITEM TOUCH HELPER: Swiping
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                return 0.1f;
//                return super.getSwipeThreshold(viewHolder);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }


            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                String groceryName = gList.get(viewHolder.getAdapterPosition()).name;
                int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.LEFT){
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    EditText editTextName = new EditText(MainActivity.this);
                    alertBuilder.setView(editTextName);
                    alertBuilder.setTitle("Add note");
                    alertBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            gList.get(position).note = editTextName.getText().toString();

                            groceryAdapter.notifyDataSetChanged();
                        }
                    });
                    alertBuilder.show();
                }else{
                    gList.remove(position);
                    groceryAdapter.notifyDataSetChanged();
                }

            }
        };
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(binding.recyclerViewGroceryList);

        // CUSTOM TOUCH LISTENER
//        binding.mainFab.setOnTouchListener(
//                new GrCustomTouchListener(MainActivity.this){
//
//                    @Override
//                    public void onSingleClick() {
//                        Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();
//                        super.onSingleClick();
//                    }
//
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        return super.onTouch(v, event);
//                    }
//
//                    @Override
//                    public void onDoubleClick(){
//                        Log.d(
//                                "MAC",
//                                "double click"
//                        );
//
//                        Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();
//                        super.onDoubleClick();
//                    }
//                }
//        );
    }
}