package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText et_email = findViewById(R.id.username);
        EditText et_pass = findViewById(R.id.password);
        new thrd2(et_email.getText().toString(), et_pass.getText().toString());
    }
    public void OpenForgotPassword(View view) {
        startActivity(new Intent(this,forgotpassword.class));}

    class thrd2 extends Thread {
        private String user, pass;
        thrd2(String u, String p) {
            user = u;
            pass = p;
        }
        public void run() {
            String s = "";
            try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Loginin.this, "checking...", Toast.LENGTH_SHORT).show();
                    }
                });
                S.dos.writeUTF("login");
                S.dos.writeUTF(user);
                S.dos.writeUTF(pass);
                s = S.dis.readUTF();
                if (s.equals("ok")) {
                    S.name = S.dis.readUTF();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Loginin.this, "welcome" + S.name, Toast.LENGTH_SHORT).show();
                        }
                    });
                    startActivity(new Intent(Loginin.this,mainscreen.class));
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Loginin.this, "username or password incorrect", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}