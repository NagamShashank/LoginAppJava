package com.example.loginapp.MyPermissions;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginapp.MainActivity;
import com.example.loginapp.R;
import com.example.loginapp.databinding.ActivityPermissionsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Permissions extends AppCompatActivity {

    ActivityPermissionsBinding binding;

//    ActivityResultLauncher<String[]> mPermissionsResultLauncher;
//    private boolean isCameraPermissionGranted = false;
//    private boolean isWriteExternalStoragePermissionGranted = false;
//    private boolean isRecordAudioPermissionGranted = false;

    private static final int Camera_Permission_Request_Code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPermissionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.permission1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCameraPermission();
            }
        });

//        mPermissionsResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
//            @Override
//            public void onActivityResult(Map<String, Boolean> result) {
//                if(result.get(Manifest.permission.CAMERA)!=null){
//                    isCameraPermissionGranted = result.get(Manifest.permission.CAMERA);
//                }
//                if(result.get(Manifest.permission.WRITE_EXTERNAL_STORAGE)!=null){
//                    isWriteExternalStoragePermissionGranted = result.get(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                }
//                if(result.get(Manifest.permission.RECORD_AUDIO)!=null){
//                    isRecordAudioPermissionGranted = result.get(Manifest.permission.RECORD_AUDIO);
//                }
//
//            }
//        });
//
//        requestPermission();
    }

    private void checkCameraPermission() {
        if(ContextCompat.checkSelfPermission(
                Permissions.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Permissions.this,new String[]{Manifest.permission.CAMERA},Camera_Permission_Request_Code);
        }else{
            Toast.makeText(getApplicationContext(),"Permission Already Granted ",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== Camera_Permission_Request_Code){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    //    private void requestPermission(){
//        isCameraPermissionGranted = ContextCompat.checkSelfPermission(
//                Permissions.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED;
//
//        isRecordAudioPermissionGranted = ContextCompat.checkSelfPermission(
//                Permissions.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED;
//
//        isWriteExternalStoragePermissionGranted = ContextCompat.checkSelfPermission(
//                Permissions.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
//
//        List<String> permissionRequest = new ArrayList<String>();
//
//        if(!isCameraPermissionGranted){
//            permissionRequest.add(Manifest.permission.CAMERA);
//        }
//
//        if(!isWriteExternalStoragePermissionGranted){
//            permissionRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//
//        if(!isRecordAudioPermissionGranted){
//            permissionRequest.add(Manifest.permission.RECORD_AUDIO);
//        }
//
//        if(permissionRequest.isEmpty()){
//            mPermissionsResultLauncher.launch(permissionRequest.toArray(new String[0]));
//        }
//    }

}