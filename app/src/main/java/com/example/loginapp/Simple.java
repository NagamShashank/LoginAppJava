package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;

import com.example.loginapp.databinding.ActivitySimpleBinding;

public class Simple extends AppCompatActivity {

    ActivitySimpleBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivitySimpleBinding.inflate(getLayoutInflater());
        setContentView(Binding.getRoot());
    }
}