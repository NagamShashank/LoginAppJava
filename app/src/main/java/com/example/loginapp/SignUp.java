package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.loginapp.databinding.ActivitySignUpBinding;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding signUpBinding;

    Boolean CheckUser = false;
    Boolean CheckPassword = false;
    Boolean CheckEmail = false;
    Boolean CheckContact = false;

    boolean VisiblePassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signUpBinding.getRoot());




        signUpBinding.SignUpBtn.setEnabled(false);

        signUpBinding.SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Welcome To App",Toast.LENGTH_SHORT).show();
                Intent a = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(a);
            }
        });




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        signUpBinding.Spinner.setAdapter(adapter);
        signUpBinding.Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                signUpBinding.countryCode.setText(country);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}

        });


        signUpBinding.SignUpPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                    final int Right = 2;
                    if(event.getRawX()>=signUpBinding.SignUpPassword.getRight()-signUpBinding.SignUpPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = signUpBinding.SignUpPassword.getSelectionEnd();
                        if(VisiblePassword){
                            signUpBinding.SignUpPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_invisible,0);
                            signUpBinding.SignUpPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            VisiblePassword = false;
                        }else{
                            signUpBinding.SignUpPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_visible,0);
                            signUpBinding.SignUpPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            VisiblePassword = true;
                        }
                        signUpBinding.SignUpPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });


        //Username.....
        signUpBinding.SignUpUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

                String User = s.toString();
                if(User.isEmpty()){
                    signUpBinding.userErrorText.setText("Username Cannot be Empty");
                    signUpBinding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    CheckUser = false;
                } else if (!User.matches(".*[a-z].*")) {
                    signUpBinding.userErrorText.setText("Missing Lowercase");
                    signUpBinding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    CheckUser = false;
                } else if (!User.matches(".*[A-Z].*")) {
                    signUpBinding.userErrorText.setText("Missing Uppercase");
                    signUpBinding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    CheckUser = false;
                } else if (User.matches("[0-9]")){
                    signUpBinding.userErrorText.setText("No letters with Uppercase and Lowercase Present");
                    signUpBinding.SignUpLayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    CheckUser = false;
                } else{
                    signUpBinding.userErrorText.setText(null);
                    signUpBinding.SignUpLayoutUsername.setBackgroundResource(R.drawable.border_line);
                    CheckUser = true;
                }

                if(((CheckUser)&&(CheckEmail))&&((CheckContact)&&(CheckPassword))){
                    signUpBinding.SignUpBtn.setEnabled(true);
                }else {
                    signUpBinding.SignUpBtn.setEnabled(false);
                }

            }
        });

        //Email........
        signUpBinding.SignUpEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

                String email = s.toString();
                if(email.isEmpty()){
                    signUpBinding.EmailErrorText.setText("Email cannot be Empty");
                    signUpBinding.SighUpLayoutEmail.setBackgroundResource(R.drawable.error_border_line);
                    CheckEmail = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    signUpBinding.EmailErrorText.setText("Invalid Email-ID");
                    signUpBinding.SighUpLayoutEmail.setBackgroundResource(R.drawable.error_border_line);
                    CheckEmail = false;
                } else {
                    signUpBinding.EmailErrorText.setText(null);
                    signUpBinding.SighUpLayoutEmail.setBackgroundResource(R.drawable.border_line);
                    CheckEmail = true;
                }

                if(((CheckUser==true)&&(CheckEmail==true))&&((CheckContact==true)&&(CheckPassword==true))){
                    signUpBinding.SignUpBtn.setEnabled(true);
                }else {
                    signUpBinding.SignUpBtn.setEnabled(false);
                }

            }
        });

        //Contact......
        signUpBinding.SignUpContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String Contact = s.toString();
                if(Contact.isEmpty()){
                    signUpBinding.ContactErrorText.setText("Contact cannot be Empty");
                    signUpBinding.SignUpLayoutContact.setBackgroundResource(R.drawable.error_border_line);
                    CheckContact = false;
                } else if (!Contact.matches(".*(\\d{10}$).*")) {
                    signUpBinding.ContactErrorText.setText("Invalid Contact Number");
                    signUpBinding.SignUpLayoutContact.setBackgroundResource(R.drawable.error_border_line);
                    CheckContact = false;
                }else {
                    signUpBinding.ContactErrorText.setText(null);
                    signUpBinding.SignUpLayoutContact.setBackgroundResource(R.drawable.border_line);
                    CheckContact = true;
                }

                if(((CheckUser==true)&&(CheckEmail==true))&&((CheckContact==true)&&(CheckPassword==true))){
                    signUpBinding.SignUpBtn.setEnabled(true);
                }else {
                    signUpBinding.SignUpBtn.setEnabled(false);
                }

            }
        });

        //Password.....
        signUpBinding.SignUpPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String Password = s.toString();
                if(Password.isEmpty()){
                    signUpBinding.PasswordErrorText.setText("Password cannot be Empty");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                } else if (!Password.matches(".*[A-Z].*")) {
                    signUpBinding.PasswordErrorText.setText("Uppercase Missing");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                } else if (!Password.matches(".*[a-z].*")) {
                    signUpBinding.PasswordErrorText.setText("Lowercase Missing");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                } else if (!Password.matches(".*[0-9].*")) {
                    signUpBinding.PasswordErrorText.setText("Missing Number");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                } else if (!Password.matches(".*[!@#$%&*].*")) {
                    signUpBinding.PasswordErrorText.setText("Missing Special Character");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                } else if (Password.length() <= 7) {
                    signUpBinding.PasswordErrorText.setText("Password is less than 6");
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    CheckPassword = false;
                }else {
                    signUpBinding.PasswordErrorText.setText(null);
                    signUpBinding.SighUpLayoutPassword.setBackgroundResource(R.drawable.border_line);
                    CheckPassword = true;
                }

                if(((CheckUser==true)&&(CheckEmail==true))&&((CheckContact==true)&&(CheckPassword==true))){
                    signUpBinding.SignUpBtn.setEnabled(true);
                }else {
                    signUpBinding.SignUpBtn.setEnabled(false);
                }

            }
        });

    }
}