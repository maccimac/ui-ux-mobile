package com.example.bulbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    List<String> roomNames = new ArrayList<>(Arrays.asList("Master Bedroom", "Guest Bedroom", "Kitchen", "Garage", "Patio"));

    List<Room> AllRooms = new ArrayList<>();
    List<Room> IndoorRooms = new ArrayList<>();
    List<Room> OutdoorRooms = new ArrayList<>();

    TextView myTextView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayoutRooms);
        
        loadData();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewBulbs);
        RoomAdapter roomAdapter = new RoomAdapter(AllRooms);

        LinearLayoutManager rlm = new LinearLayoutManager(this);

        recyclerView.setAdapter(roomAdapter);
        recyclerView.setLayoutManager(rlm);

        myTextView = findViewById(R.id.txtViewRoomName);

        Drawable img = ResourcesCompat.getDrawable(getResources(), R.drawable.border, getTheme());
        Objects.requireNonNull(img);
        img.setBounds(0,0,img.getIntrinsicWidth(), img.getIntrinsicHeight());

        myTextView.setCompoundDrawables(img, null, img, null);
        myTextView.setCompoundDrawablePadding(8);

        myTextView.setOnTouchListener(new CustomTouchListener(MainActivity.this){
            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                Toast.makeText(MainActivity.this, "It workeddd", Toast.LENGTH_SHORT).show();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        roomAdapter.setRoomList(AllRooms);
                        Toast.makeText(MainActivity.this, AllRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        roomAdapter.setRoomList(IndoorRooms);
                        Toast.makeText(MainActivity.this, IndoorRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        roomAdapter.setRoomList(OutdoorRooms);
                        Toast.makeText(MainActivity.this, OutdoorRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Toast.makeText(MainActivity.this, AllRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, IndoorRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, OutdoorRooms.size() + " items", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void loadData() {
        for(int i = 0; i < roomNames.size(); i++) {
            Room eachRoom = new Room(roomNames.get(i));
            AllRooms.add(eachRoom);
        }
        //Log.d("CHECKLENGTH", "Length is " + AllRooms.size());

        IndoorRooms = AllRooms.subList(0, 3);
        OutdoorRooms = AllRooms.subList(3, 5);
    }
}