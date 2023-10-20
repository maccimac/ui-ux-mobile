package com.example.bulbdemo;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    List<Room> roomList;

    public RoomAdapter(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
        notifyDataSetChanged();
    }

    @SuppressLint({"ClickableViewAccessibility", "NotifyDataSetChanged"})
    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_roomitem, parent, false);

        RoomViewHolder roomViewHolder = new RoomViewHolder(viewItem);
        roomViewHolder.imgViewBulb.setOnTouchListener(new CustomTouchListener(roomViewHolder.imgViewBulb.getContext()){
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                //Toast.makeText(parent.getContext(), "Custom touch listener works", Toast.LENGTH_SHORT).show();
                if(!(roomList.get(roomViewHolder.getAdapterPosition())).isBulbOne) {
                    roomList.get(roomViewHolder.getAdapterPosition()).setBulbOne(true);
                    notifyDataSetChanged();
                }
                else {
                    roomList.get(roomViewHolder.getAdapterPosition()).setBulbOne(false);
                    notifyDataSetChanged();
                }
            }
        });

//        roomViewHolder.imgViewBulb.setOnClickListener(v -> {
//            if(!(roomList.get(roomViewHolder.getAdapterPosition())).isBulbOne) {
//                roomList.get(roomViewHolder.getAdapterPosition()).setBulbOne(true);
//                notifyDataSetChanged();
//            }
//            else {
//                roomList.get(roomViewHolder.getAdapterPosition()).setBulbOne(false);
//                notifyDataSetChanged();
//            }
//        });

        return roomViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.txtViewRoom.setText(roomList.get(position).getRoomName());

        if(roomList.get(position).isBulbOne) {
            holder.imgViewBulb.setImageResource(R.drawable.bulbon);
        }
        else {
            holder.imgViewBulb.setImageResource(R.drawable.bulboff);
        }
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView txtViewRoom;
        ImageView imgViewBulb;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);

            txtViewRoom = itemView.findViewById(R.id.txtViewRoomName);
            imgViewBulb = itemView.findViewById(R.id.imgViewBulbOnOff);
        }
    }

}
