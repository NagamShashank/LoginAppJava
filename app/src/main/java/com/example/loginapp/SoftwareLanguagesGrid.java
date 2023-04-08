package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginapp.AdaptersPack.RecyclerGridViewAdapter;
import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.databinding.ActivitySoftwareLanguagesGridBinding;

import java.util.ArrayList;

public class SoftwareLanguagesGrid extends AppCompatActivity {

    ActivitySoftwareLanguagesGridBinding gridBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gridBinding = ActivitySoftwareLanguagesGridBinding.inflate(getLayoutInflater());
        setContentView(gridBinding.getRoot());

        ArrayList<RecyclerViewModel> GArrayList = new ArrayList<>();

        GArrayList.add(new RecyclerViewModel(R.drawable.java_logo,"JAVA","","1"));
        GArrayList.add(new RecyclerViewModel(R.drawable.cplusplus_logo,"C++","","2"));
        GArrayList.add(new RecyclerViewModel(R.drawable.python_logo,"Python","","3"));
        GArrayList.add(new RecyclerViewModel(R.drawable.ruby_logo,"Ruby","","4"));
        GArrayList.add(new RecyclerViewModel(R.drawable.javascript_logo,"JavaScript","","5"));
        GArrayList.add(new RecyclerViewModel(R.drawable.angularjs_logo,"Angular","","6"));
        GArrayList.add(new RecyclerViewModel(R.drawable.csharp_logo,"C#","","7"));
        GArrayList.add(new RecyclerViewModel(R.drawable.kotlin_logo,"Kotlin","","8"));
        GArrayList.add(new RecyclerViewModel(R.drawable.swift_logo,"Swift","","9"));
        GArrayList.add(new RecyclerViewModel(R.drawable.css_logo,"CSS","","10"));
        GArrayList.add(new RecyclerViewModel(R.drawable.matlab_logo,"MatLab","","11"));
        GArrayList.add(new RecyclerViewModel(R.drawable.nodejs_logo,"Node JS","","12"));

        RecyclerGridViewAdapter recyclerGridViewAdapter = new RecyclerGridViewAdapter(GArrayList,this);
        gridBinding.GridRecyclerView.setAdapter(recyclerGridViewAdapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        gridBinding.GridRecyclerView.setLayoutManager(layoutManager);
    }
}