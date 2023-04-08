package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(Binding.getRoot());

        Binding.SoftwareLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SoftwareLanguages.class);
                startActivity(intent);
            }
        });

        Binding.SoftwareLang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentgird = new Intent(getApplicationContext(),SoftwareLanguagesGrid.class);
                startActivity(intentgird);
            }
        });

        Binding.SoftwareLangHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSF = new Intent(getApplicationContext(),SoftwareLanguages2.class);
                startActivity(intentSF);
            }
        });


    }
}