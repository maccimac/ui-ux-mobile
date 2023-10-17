package com.example.ux_mids_grocery_groovy.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.ux_mids_grocery_groovy.databinding.GroceryListItemBinding;
import com.example.ux_mids_grocery_groovy.GrCustomTouchListener;

import com.example.ux_mids_grocery_groovy.model.GroceryItem;

import java.util.List;


/**
 * 1. Extend adapter
 * 2. Implement all methods
 * 3. Create a ViewHolder: GroceryViewHolder (uses the pre-made grocery_list_item)
 *  3.1. ensure tp set holderBinding
 * 4. Populate on CreateViewHolder by inflating binding
 *  4.1. Inflate, bind, return ViewHolder
 *  4.2. Ensure getItemCount()
 * 5. Use onBindViewHolder to apply texts and images
 *  5.1. Use holder.holderBinding
 *
 *
 */
public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    List<GroceryItem> groceryList;
    ViewGroup parent;
    Context context;
    public GroceryAdapter(List<GroceryItem> groceryList) {
        this.groceryList = groceryList;
//        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GroceryAdapter.GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        this.context = parent.getContext();

        // return fully created holder object:

        // create inflater = cabinet
        // binding = attachment of parent and inglater
        // specify where to attach
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        GroceryListItemBinding binding = GroceryListItemBinding.inflate(layoutInflater, parent, false);

        // create the View Holder to return
        GroceryViewHolder groceryViewHolder = new GroceryViewHolder(binding.getRoot(), binding);
        return groceryViewHolder;
    };

    @Override
    public void onBindViewHolder(@NonNull GroceryAdapter.GroceryViewHolder holder, int position) {
        holder.holderBinding.listImage.setImageResource(
                groceryList.get(position).imageId
        );
        holder.holderBinding.listTitle.setText( groceryList.get(position).name);
//        holder.holderBinding.listTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(), "HI", Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.holderBinding.listImage.setOnTouchListener(
//                new GrCustomTouchListener(context)
//        );
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }


    public class GroceryViewHolder extends RecyclerView.ViewHolder{

        GroceryListItemBinding holderBinding;

        public GroceryViewHolder(@NonNull View itemView, GroceryListItemBinding holderBinding ){


            super(itemView);
            this.holderBinding = holderBinding;
//            this.holderBinding.getRoot().setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                        }
//                    }
//            );

        }


    }


}
