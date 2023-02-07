package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.FullScreen;

import java.util.ArrayList;

public class Activity_New_Question extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private MaterialButton questionNew_BTN_finish,questionNew_BTN_Back;
   private EditText questionNew_EDXT_Titel,questionNew_EDXT_Text;
   private AutoCompleteTextView questionNew_AutoTextViewCat;
    private String setCategorySelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        findView();
        initViews();

    }

    private void initViews() {
        questionNew_AutoTextViewCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setCategorySelect(adapterView.getItemAtPosition(i).toString());
            }
        });

        questionNew_BTN_Back.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_New_Question.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
        questionNew_BTN_finish.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////////////////////////////////////////////////change the lock

                Intent intent = new Intent(Activity_New_Question.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
    }

    public Activity_New_Question setCategorySelect(String setCategorySelect) {
        this.setCategorySelect = setCategorySelect;
        return this;
    }


    private void findView() {
        questionNew_BTN_finish = findViewById(R.id.questionNew_BTN_finish );
        questionNew_BTN_Back = findViewById(R.id.questionNew_BTN_Back );
        questionNew_EDXT_Text = findViewById(R.id.questionNew_EDXT_Text );
        questionNew_AutoTextViewCat = findViewById(R.id.questionNew_AutoTextViewCat );





    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }

}