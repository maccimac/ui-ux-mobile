package com.example.ux_mids_grocery_groovy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.ux_mids_grocery_groovy.databinding.GroceryListItemBinding;

import com.example.ux_mids_grocery_groovy.model.GroceryItem;

import java.util.List;


/**
 * 1. Extend adapter
 * 2. Implement all methods
 * 3. Create a ViewHolder: GroceryViewHolder (uses the pre-made grocery_list_item)
 * 4. Populate on CreateViewHolder by inflating binding
 * 4.1. Inflate, bind, return ViewHolder
 * 4.2. Ensure getItemCount()
 * 5.
 * 6.
 *
 *
 */
public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    List<GroceryItem> groceryList;
    public GroceryAdapter(List<GroceryItem> groceryList) {
        this.groceryList = groceryList;
//        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GroceryAdapter.GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }


    public class GroceryViewHolder extends RecyclerView.ViewHolder{

        GroceryListItemBinding holderBinding;

        public GroceryViewHolder(@NonNull View itemView, GroceryListItemBinding holderBinding ){

            super(itemView);
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