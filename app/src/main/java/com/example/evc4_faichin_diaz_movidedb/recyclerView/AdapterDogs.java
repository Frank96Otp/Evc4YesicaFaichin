package com.example.evc4_faichin_diaz_movidedb.recyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evc4_faichin_diaz_movidedb.databinding.ItemDogsBinding;

import java.util.List;

public class AdapterDogs extends RecyclerView.Adapter<AdapterDogs.ViewHolderDogs> {

    private List<String> dogsList;

    public AdapterDogs(List<String> dogs) {
        this.dogsList = dogs;
    }

    @NonNull
    @Override
    public ViewHolderDogs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemDogsBinding binding = ItemDogsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        return  new ViewHolderDogs(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDogs holder, int position) {
            holder.bind(dogsList.get(position));
    }

    @Override
    public int getItemCount() {
        return dogsList.size();
    }



    public class ViewHolderDogs extends RecyclerView.ViewHolder{

        private  ItemDogsBinding binding;

        public ViewHolderDogs(ItemDogsBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String dogResponse) {

            Glide.with(itemView.getContext()).load(dogResponse).into(binding.ivDogs);

        }
    }
}
