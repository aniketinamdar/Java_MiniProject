package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Finish(View view) {
        finish();
    }

    public void OpenLoginPage(View view) {
        EditText et_name = findViewById(R.id.name);
        EditText et_email = findViewById(R.id.emailid);
        EditText et_pass = findViewById(R.id.passwrd);
        EditText et_cnf = findViewById(R.id.cnfirmpasswrd);
        String s = "";
        if (et_pass.getText().toString().equals(et_cnf.getText().toString())) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(signup.this, "password matches", Toast.LENGTH_SHORT).show();
                }
            });

            new thrd1(et_name.getText().toString(), et_email.getText().toString(), et_pass.getText().toString()).start();
        }
    }

    class thrd1 extends Thread {
        private  String name, email, pass;
        thrd1(String n, String e, String p) {
            name = n;
            email = e;
            pass = p;
        }
        public void run() {
            String s = "";
            try {
                S.dos.writeUTF("signup");
                S.dos.writeUTF(name);
                S.dos.writeUTF(email);
                S.dos.writeUTF(pass);
                s = S.dis.readUTF();
                if (s.equals("ok")) {
                    startActivity(new Intent(signup.this, Loginin.class));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(signup.this, "signed up successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}