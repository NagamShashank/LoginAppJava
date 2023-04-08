package com.example.loginapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.AdaptersPack.RecyclerViewAdapter;
import com.example.loginapp.Model.RecyclerViewModel;
import com.example.loginapp.databinding.ActivitySoftwareLanguagesBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class SoftwareLanguages extends AppCompatActivity {

     ActivitySoftwareLanguagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySoftwareLanguagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<RecyclerViewModel> list = new ArrayList<>();

        list.add(new RecyclerViewModel(R.drawable.java_logo,"JAVA","","1")); //
        list.add(new RecyclerViewModel(R.drawable.java_logo,"JAVA","","1")); //
        list.add(new RecyclerViewModel(R.drawable.java_logo,"JAVA","","1"));
        list.add(new RecyclerViewModel(R.drawable.cplusplus_logo,"C++","","2"));
        list.add(new RecyclerViewModel(R.drawable.python_logo,"Python","","3"));
        list.add(new RecyclerViewModel(R.drawable.ruby_logo,"Ruby","","4"));
        list.add(new RecyclerViewModel(R.drawable.javascript_logo,"JavaScript","","5"));
        list.add(new RecyclerViewModel(R.drawable.angularjs_logo,"Angular","","6"));
        list.add(new RecyclerViewModel(R.drawable.csharp_logo,"C#","","7"));
        list.add(new RecyclerViewModel(R.drawable.kotlin_logo,"Kotlin","","8"));
        list.add(new RecyclerViewModel(R.drawable.swift_logo,"Swift","","9"));
        list.add(new RecyclerViewModel(R.drawable.css_logo,"CSS","","10"));
        list.add(new RecyclerViewModel(R.drawable.css_logo,"CSS","","10"));
        list.add(new RecyclerViewModel(R.drawable.matlab_logo,"MatLab","","11"));
        list.add(new RecyclerViewModel(R.drawable.nodejs_logo,"Node JS","","12"));


        // Filtered the List and Removed the Duplicates from the Filtered List //
//       ArrayList<RecyclerViewModel> newList = new ArrayList<>();
//        for (RecyclerViewModel item : list){
//            if(item.getLtext().equals("JAVA")){
//                newList.clear();
//                if(!newList.contains(item)){
//                    newList.add(item);
//                }
//            }
//        }

        //To Remove Duplicate Elements From Array...............//
        ArrayList<RecyclerViewModel> newList2 = new ArrayList<>();
        for(RecyclerViewModel item : list){
            if(!newList2.contains(item)){
                newList2.add(item);
            }
        }


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list,this);
        binding.LangRecyclerView.setAdapter(recyclerViewAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.LangRecyclerView.setLayoutManager(layoutManager);

    }
}












//RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
//binding.LangRecyclerView.setLayoutManager(layoutManager);

//RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//binding.LangRecyclerView.setLayoutManager(layoutManager);

//        HashSet<RecyclerViewModel> set = new HashSet<>(list);
//        ArrayList<RecyclerViewModel> newList2 = new ArrayList<>(set);