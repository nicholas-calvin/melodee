package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView errormess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVar();
        buttonListener();

    }

    private void initVar() {
        this.username = findViewById(R.id.uname);
        this.password = findViewById(R.id.pw);
        this.login = findViewById(R.id.loginBtn);
        this.errormess = findViewById(R.id.errorMess);
    }

    private void buttonListener() {
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                validate();

            }
        });
    }

    private void validate() {
        String uname = this.username.getText().toString();
        String pw = this.password.getText().toString();
        Intent goTo = new Intent(MainActivity.this, Home.class);

        if(uname.isEmpty()){
            errormess.setVisibility(View.VISIBLE);
            errormess.setText("Username must not be empty");
        }
        else if(pw.isEmpty()){
            errormess.setVisibility(View.VISIBLE);
            errormess.setText("Password must not be empty");
        }
        else if(!pw.matches("^[a-zA-Z0-9]+$")){
            errormess.setVisibility(View.VISIBLE);
            errormess.setText("Password must be alphanumeric");
        }
        else{
            errormess.setVisibility(View.INVISIBLE);
            goTo.putExtra("USERNAME_KEY", uname);
            startActivity(goTo);
        }

    }
}