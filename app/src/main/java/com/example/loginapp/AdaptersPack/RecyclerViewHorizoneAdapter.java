package com.example.loginapp.AdaptersPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.databinding.RecyclerviewLayoutHorizontalBinding;

import java.util.ArrayList;

public class RecyclerViewHorizoneAdapter extends RecyclerView.Adapter<RecyclerViewHorizoneAdapter.ViewHolder> {

    ArrayList<RecyclerViewModel> arrayHlist;

    Context context;

    public RecyclerViewHorizoneAdapter(ArrayList<RecyclerViewModel> arrayHlist, Context context) {
        this.arrayHlist = arrayHlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHorizoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerviewLayoutHorizontalBinding binding = RecyclerviewLayoutHorizontalBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHorizoneAdapter.ViewHolder holder, int position) {

        RecyclerViewModel Hmodel = arrayHlist.get(position);

        holder.Hbinding.HorizoneLangImg.setImageResource(Hmodel.getPicture());
        holder.Hbinding.HorizoneLangText.setText(Hmodel.getLtext());
        holder.Hbinding.HorizoneDescription.setText(Hmodel.getDescrption());

    }

    @Override
    public int getItemCount() {
        return arrayHlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewLayoutHorizontalBinding Hbinding;

        public ViewHolder(@NonNull RecyclerviewLayoutHorizontalBinding recyclerviewLayoutHorizontalBinding) {
            super(recyclerviewLayoutHorizontalBinding.getRoot());

            Hbinding = recyclerviewLayoutHorizontalBinding;
        }
    }
}
