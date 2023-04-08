package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginapp.AdaptersPack.RecyclerViewHorizoneAdapter;
import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.databinding.ActivitySoftwareLanguages2Binding;

import java.util.ArrayList;

public class SoftwareLanguages2 extends AppCompatActivity {

    ActivitySoftwareLanguages2Binding bindingSF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingSF = ActivitySoftwareLanguages2Binding.inflate(getLayoutInflater());
        setContentView(bindingSF.getRoot());

        ArrayList<RecyclerViewModel> arraylistH = new ArrayList<>();

        arraylistH.add(new RecyclerViewModel(R.drawable.java_logo,"JAVA",
                "Java is a general-purpose, class-based, object-oriented programming " +
                        "language designed for having lesser implementation dependencies. " +
                        "It is a computing platform for application development. Java is fast, " +
                        "secure, and reliable, therefore. It is widely used for developing Java " +
                        "applications in laptops, data centers, game consoles, scientific supercomputers, " +
                        "cell phones, etc.","1"));
        arraylistH.add(new RecyclerViewModel(R.drawable.cplusplus_logo,"C++","","2"));
        arraylistH.add(new RecyclerViewModel(R.drawable.python_logo,"Python","","3"));
        arraylistH.add(new RecyclerViewModel(R.drawable.ruby_logo,"Ruby","","4"));
        arraylistH.add(new RecyclerViewModel(R.drawable.javascript_logo,"JavaScript","","5"));
        arraylistH.add(new RecyclerViewModel(R.drawable.angularjs_logo,"Angular","","6"));
        arraylistH.add(new RecyclerViewModel(R.drawable.csharp_logo,"C#","","7"));
        arraylistH.add(new RecyclerViewModel(R.drawable.kotlin_logo,"Kotlin","","8"));
        arraylistH.add(new RecyclerViewModel(R.drawable.swift_logo,"Swift","","9"));
        arraylistH.add(new RecyclerViewModel(R.drawable.css_logo,"CSS","","10"));
        arraylistH.add(new RecyclerViewModel(R.drawable.matlab_logo,"MatLab","","11"));
        arraylistH.add(new RecyclerViewModel(R.drawable.nodejs_logo,"Node JS","","12"));

        RecyclerViewHorizoneAdapter recyclerViewHorizoneAdapter = new RecyclerViewHorizoneAdapter(arraylistH,this);
        bindingSF.SLangHRecyclerView.setAdapter(recyclerViewHorizoneAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        bindingSF.SLangHRecyclerView.setLayoutManager(layoutManager);



    }
}