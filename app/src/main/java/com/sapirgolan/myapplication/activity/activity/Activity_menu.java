package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.sapirgolan.myapplication.Fragment.Fragment_kind_pets;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.FullScreen;

public class Activity_menu extends AppCompatActivity {
    private final DataManager dataManager = DataManager.getData();
   private AppCompatImageView menu_IMG_background;
    private MaterialButton menu_BTN_addQ;
    private Fragment_kind_pets fragment_kind_pets;


    CallBackList callBackList = new CallBackList() {
        @Override
        public void onClicked() {

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findView();
        initViews();



        fragment_kind_pets = (Fragment_kind_pets) new Fragment_kind_pets().setActivity(this);

       getSupportFragmentManager().beginTransaction().add(R.id.menu_LAY_fragmant,fragment_kind_pets).commit();
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