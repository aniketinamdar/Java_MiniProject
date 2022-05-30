package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        EditText et_name = findViewById(R.id.name);
        EditText et_email = findViewById(R.id.emailid);
        EditText et_pass = findViewById(R.id.passwrd);
        EditText et_cnf = findViewById(R.id.cnfirmpasswrd);
        String s = "";
        if (et_pass.getText().equals(et_cnf.getText())) {
            try {
                S.dos.writeUTF("signup");
                S.dos.writeUTF("" + et_name.getText());
                S.dos.writeUTF("" + et_email.getText());
                S.dos.writeUTF("" + et_pass.getText());
                s = S.dis.readUTF();
                if (s.equals("ok")) {
                    startActivity(new Intent(this, Loginin.class));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "signed up successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
