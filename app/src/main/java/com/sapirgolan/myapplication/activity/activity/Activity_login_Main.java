package com.sapirgolan.myapplication.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.FullScreen;

public class Activity_login_Main extends AppCompatActivity {

    AppCompatImageView logMain_IMG_background;
    MaterialButton logMain_BTN_Login;
    MaterialButton logMain_BTN_signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);


        initViews();
        findView();


        Glide
                .with(Activity_login_Main.this)
                .load("https://img.freepik.com/free-vector/animal-background-with-cute-pets-illustration_53876-99291.jpg?w=2000")
                .into(logMain_IMG_background);



    }

    private void initViews() {
        logMain_IMG_background = findViewById(R.id.logMain_IMG_background);
        logMain_BTN_signUp = findViewById(R.id.logMain_BTN_signUp);
        logMain_BTN_Login = findViewById(R.id.logMain_BTN_Login);

    }

    private void findView() {
        logMain_BTN_Login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_login_Main.this, Activity_Login.class);

                startActivity(intent);
                finish();


            }
        }));
        logMain_BTN_signUp.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_login_Main.this, Activity_SingUp.class);

                startActivity(intent);
                finish();

            }
        }));
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }

}