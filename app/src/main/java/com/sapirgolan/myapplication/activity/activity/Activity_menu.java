package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.FullScreen;

public class Activity_menu extends AppCompatActivity {
   private AppCompatImageView menu_IMG_background;
    private MaterialButton menu_BTN_addQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findView();
        initViews();


        Glide
                .with(Activity_menu.this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPQtbWlOYDJoXbQIozPZZCDpm7PhEMuu9Osw&usqp=CAU")
                .into(menu_IMG_background);


    }

    private void initViews() {

        menu_BTN_addQ.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_menu.this, Activity_New_Question.class);

                startActivity(intent);
                finish();

            }
        }));

    }

    private void findView() {
        menu_IMG_background = findViewById(R.id.menu_IMG_background);
        menu_BTN_addQ= findViewById(R.id.menu_BTN_addQ);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }
}