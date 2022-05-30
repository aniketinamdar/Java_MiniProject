package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.collegeconnect.S;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        S.connect();
        while (true) {
            try {
                if (S.sock.isConnected()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "connected", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
    public void OpenGetStarted(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void OpenSignUpPage(View view) {
        startActivity(new Intent(this,signup.class));
    }

    public void OpenLoginPage(View view) {
        startActivity(new Intent(this,Loginin.class));
    }

    public void OpenMainPage(View view) {

        startActivity(new Intent(this,mainscreen.class));
    }

    public void OpenForgotPassword(View view) { startActivity(new Intent(this,forgotpassword.class));}
    public void Finish(View view) {
        finish();
    }
    public void Edit(View view){startActivity(new Intent(this,EditProfile.class));}

}
