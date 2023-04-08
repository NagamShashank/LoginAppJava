package com.example.loginapp.AdaptersPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.R;
import com.example.loginapp.databinding.RecyclergridviewLayoutBinding;
import com.example.loginapp.databinding.RecyclerviewLayoutBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    ArrayList<RecyclerViewModel> arrayList;
    Context context;





    public RecyclerViewAdapter(ArrayList<RecyclerViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout,parent,false);

        RecyclerviewLayoutBinding binding = RecyclerviewLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, int position) {

        RecyclerViewModel model = arrayList.get(position);

            holder.binding.LangImg.setImageResource(model.getPicture());
            holder.binding.LangText.setText(model.getLtext());
            holder.binding.LangID.setText(model.getID());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        //ImageView LangImg;
        //TextView Langtxt;

       /* public viewHolder(@NonNull View itemView) {

            super(itemView);

            LangImg = itemView.findViewById(R.id.LangImg);
            Langtxt = itemView.findViewById(R.id.LangText);
        }*/

        RecyclerviewLayoutBinding binding;

        public viewHolder(@NonNull RecyclerviewLayoutBinding recyclerviewLayoutBinding) {

            super(recyclerviewLayoutBinding.getRoot());

            binding = recyclerviewLayoutBinding;

            //LangImg = itemView.findViewById(R.id.LangImg);
            //Langtxt = itemView.findViewById(R.id.LangText);
        }

    }




}
