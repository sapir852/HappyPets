package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.DataBase.DataManager;
import com.sapirgolan.myapplication.activity.FullScreen;
import com.sapirgolan.myapplication.activity.object.Answer;

import java.util.UUID;

public class ActivityNewAnswer extends AppCompatActivity {
    private final DataManager dataManager = DataManager.getData();
    private MaterialButton answerNew_BTN_finish,answerNew_BTN_Back;
    private EditText answerNew_EDXT_Titel,answerNew_EDXT_Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_answer);
        findView();
        initViews();

    }

    private void initViews() {
        answerNew_BTN_Back.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityNewAnswer.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
        answerNew_BTN_finish.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer tempAnswer = new Answer();
                tempAnswer.setIdQuestion(UUID.randomUUID().toString());
                tempAnswer.setTitle(answerNew_EDXT_Titel.getText().toString());
                tempAnswer.setText(answerNew_EDXT_Text.getText().toString());
                dataManager.addNewAnswer(tempAnswer);
                dataManager.getAnswers().add(tempAnswer);
                Intent intent = new Intent(ActivityNewAnswer.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
    }

    private void findView() {
        answerNew_BTN_finish = findViewById(R.id.answerNew_BTN_finish );
        answerNew_BTN_Back = findViewById(R.id.answerNew_BTN_Back );
        answerNew_EDXT_Titel=findViewById(R.id.answerNew_EDXT_Titel );
        answerNew_EDXT_Text = findViewById(R.id.answerNew_EDXT_Text );
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }
}





















