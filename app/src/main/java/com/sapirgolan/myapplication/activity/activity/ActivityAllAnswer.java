package com.sapirgolan.myapplication.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sapirgolan.myapplication.Fragment.FragmentAnswer;
import com.sapirgolan.myapplication.Fragment.Fragment_kind_pets;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.Answer;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;

public class ActivityAllAnswer extends AppCompatActivity {
    private final DataManager dataManager = DataManager.getData();
    private MaterialButton allAn_BTN_addA,allAn_BTN_Back;
    private MaterialTextView allAn_LBL_titleQuestion,allAn_LBL_textQuestion;
    private FragmentAnswer fragmentAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_answer);

        findView();
        initViews();
        fragmentAnswer = (FragmentAnswer) new FragmentAnswer().setActivity(this);

        getSupportFragmentManager().beginTransaction().add(R.id.allAn_LAY_fragmant, fragmentAnswer).commit();

//        final ArrayList<Answer> answersList = new ArrayList<>();
//        FirebaseDatabase database=FirebaseDatabase.getInstance("https://happypets-fd8b0-default-rtdb.europe-west1.firebasedatabase.app/");
//        DatabaseReference myRef=database.getReference("answer");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot quesnapshott : snapshot.getChildren()) {
//                    Answer currentAnswer = new Answer();
//                    currentAnswer.setIdQuestion(quesnapshott.getKey());
//                   // String id = quesnapshott.child("idQuestion").getValue(String.class);
//                    String text = quesnapshott.child("text").getValue(String.class);
//                    String title = quesnapshott.child("title").getValue(String.class);
//
//
//                    //currentAnswer.setTitle(id);
//                    currentAnswer.setTitle(title);
//                    currentAnswer.setText(text);
//                    answersList.add(currentAnswer);
//                    Log.d("text", currentAnswer + "");
//
//                }
//
//                //notifyDataSetChanged();
//                dataManager.setAnswers(answersList);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(ActivityAllAnswer.this, "error reading from firebase ", Toast.LENGTH_SHORT).show();
//            }});
//


    }


    private void initViews() {
        allAn_BTN_Back.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityAllAnswer.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
        allAn_BTN_addA.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityAllAnswer.this, ActivityNewAnswer.class);
                startActivity(intent);
                finish();


            }
        }));
    }

    private void findView() {
        allAn_BTN_addA = findViewById(R.id.allAn_BTN_addA);
        allAn_BTN_Back = findViewById(R.id.allAn_BTN_Back);
        allAn_LBL_titleQuestion = findViewById(R.id.allAn_LBL_titleQuestion);
        allAn_LBL_textQuestion = findViewById(R.id.allAn_LBL_textQuestion);
        Question tempQuestion = dataManager.getOneQuestin();

        allAn_LBL_titleQuestion.setText("Question Title:  " + tempQuestion.getTitle());
        allAn_LBL_textQuestion.setText("Text Question:  " + tempQuestion.getText());


    }

}