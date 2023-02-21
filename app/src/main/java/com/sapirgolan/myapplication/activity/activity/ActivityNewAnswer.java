package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.sapirgolan.myapplication.Fragment.FragmentAnswer;
import com.sapirgolan.myapplication.Fragment.Fragment_kind_pets;
import com.sapirgolan.myapplication.R;

public class ActivityNewAnswer extends AppCompatActivity {
    private TextView answer_TXT_title,answer_TXT_text;
    private MaterialButton answer_BTN_backA,answer_BTN_addA;
    private FragmentAnswer fragmentAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_answer);
        fragmentAnswer = (FragmentAnswer) new FragmentAnswer().setActivity(this);
        getSupportFragmentManager().beginTransaction().add(R.id.answer_LAY_fragmant, fragmentAnswer).commit();


        findView();
        initViews();

    }

    private void initViews() {

        answer_BTN_addA.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Activity_menu.this, Activity_New_Question.class);
//
//                startActivity(intent);
//                finish();

            }
        }));
        answer_BTN_backA.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNewAnswer.this, Activity_menu.class);

                startActivity(intent);
                finish();

            }
        }));
    }

    private void findView() {
        answer_TXT_title=findViewById(R.id.answer_TXT_title);
        answer_TXT_text=findViewById(R.id.answer_TXT_text);
        answer_BTN_backA=findViewById(R.id.answer_BTN_backA);
        answer_BTN_addA=findViewById(R.id.answer_BTN_addA);

    }
}