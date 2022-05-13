package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenSignUpPage(View view) {
        startActivity(new Intent(this,signup.class));
    }

    public void OpenLoginPage(View view) {
        startActivity(new Intent(this,Loginin.class));
    }


    public void Finish(View view) {
        finish();
    }

    public void OpenMainPage(View view) {
        startActivity(new Intent(this,mainscreen.class));
    }
}