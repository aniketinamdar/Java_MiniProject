package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Loginin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);
    }
    public void Finish(View view) {
        finish();
    }

    public void OpenMainPage(View view) {
        startActivity(new Intent(this,mainscreen.class));
    }

}