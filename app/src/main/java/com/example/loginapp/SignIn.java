package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmRights;
import android.drm.DrmStore;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.loginapp.databinding.ActivitySigninBinding;

public class SignIn extends AppCompatActivity {

    ActivitySigninBinding binding;
    //boolean checkUser = false;
    //boolean checkPassword = false;

    boolean checkUser = false;
    boolean checkPassword = false;

    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.SignInBtn.setEnabled(false);

        //binding.Username.addTextChangedListener(SignInTextWatcher);
        //binding.Password.addTextChangedListener(SignInTextWatcher);

        //binding.layoutPassword.setErrorIconDrawable(null);

        binding.SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

            }
        });




        binding.SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This is Sign Up ",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });


        binding.Password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP){
                   final int Right = 2;
                    if(event.getRawX()>=binding.Password.getRight()-binding.Password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = binding.Password.getSelectionEnd();
                        if(passwordVisible){
                            binding.Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_invisible,0);
                            binding.Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else{
                            binding.Password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_visible,0);
                            binding.Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        binding.Password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        String Name = binding.EditTextUsername.getText().toString();
        String pass = binding.Password.getText().toString();

        binding.EditTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String Username = s.toString();
                if(Username.isEmpty()){
                    binding.userError.setText("Username Cannot be Empty");
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    checkUser = false;
                } else if (!Username.matches(".*[a-z].*")) {
                    binding.userError.setText("Missing Lowercase");
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    checkUser = false;
                } else if (!Username.matches(".*[A-Z].*")) {
                    binding.userError.setText("Missing Uppercase");
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    checkUser = false;
                } else if (Username.matches("[0-9]")){
                    binding.userError.setText("No letters with Uppercase and Lowercase Present");
                    binding.LayoutUsername.setBackgroundResource(R.drawable.error_border_line);
                    checkUser = false;
                } else{
                    binding.userError.setText("");
                    binding.LayoutUsername.setBackgroundResource(R.drawable.border_line);
                    checkUser = true;
                }

                binding.SignInBtn.setEnabled((checkUser) && (checkPassword));
            }
        });

        binding.Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String UserPassword = s.toString();

                if(UserPassword.isEmpty()){
                    binding.passwordError.setText("Password cannot be Empty");
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    checkPassword = false;
                } else if (!UserPassword.matches(".*[a-z].*")) {
                   binding.passwordError.setText("Missing Lowercase");
                   binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                   checkPassword = false;
                } else if (!UserPassword.matches(".*[A-Z].*")) {
                    binding.passwordError.setText("Missing Uppercase");
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    checkPassword =false;
                } else if (!UserPassword.matches(".*[0-9].*")) {
                    binding.passwordError.setText("Missing Number");
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    checkPassword =false;
                } else if (!UserPassword.matches(".*[!@#$%&*].*")) {
                    binding.passwordError.setText("Missing Special Character");
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    checkPassword =false;
                } else if (UserPassword.length() < 6) {
                    binding.passwordError.setText("Password to Short");
                    binding.LayoutPassword.setBackgroundResource(R.drawable.error_border_line);
                    checkPassword =false;
                } else{
                    binding.passwordError.setText(null);
                    binding.LayoutPassword.setBackgroundResource(R.drawable.border_line);
                    checkPassword = true;
                }

                binding.SignInBtn.setEnabled((checkUser) && (checkPassword));

            }
        });

    }



}
