package com.example.loginapp.AdaptersPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.databinding.RecyclergridviewLayoutBinding;

import java.util.ArrayList;

public class RecyclerGridViewAdapter extends RecyclerView.Adapter<RecyclerGridViewAdapter.ViewHolder> {

    ArrayList<RecyclerViewModel> gridArrayList;

    Context context;

    public RecyclerGridViewAdapter(ArrayList<RecyclerViewModel> gridArrayList, Context context) {
        this.gridArrayList = gridArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerGridViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclergridviewLayoutBinding GLbinding = RecyclergridviewLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(GLbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerGridViewAdapter.ViewHolder holder, int position) {


        RecyclerViewModel gModel = gridArrayList.get(position);
        holder.Gbinding.GridLangImg.setImageResource(gModel.getPicture());
        holder.Gbinding.GridLangText.setText(gModel.getLtext());

    }

    @Override
    public int getItemCount() {
        return gridArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        RecyclergridviewLayoutBinding Gbinding;
        public ViewHolder(@NonNull RecyclergridviewLayoutBinding recyclergridviewLayoutBinding) {
            super(recyclergridviewLayoutBinding.getRoot());

            Gbinding = recyclergridviewLayoutBinding;
        }
    }
}
