package com.sapirgolan.myapplication.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.FullScreen;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;
import java.util.UUID;

public class Activity_New_Question extends AppCompatActivity {
    private final DataManager dataManager = DataManager.getData();
    private FirebaseAuth mAuth;
    private MaterialButton questionNew_BTN_finish,questionNew_BTN_Back;
   private EditText questionNew_EDXT_Titel,questionNew_EDXT_Text;
   private AutoCompleteTextView questionNew_AutoTextViewCat;
    private String choseKindPet;
    private DatabaseReference mDatabase;

    private ArrayAdapter<String> adapterKindPets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        findView();
        initViews();

    }

    private void initViews() {
        questionNew_AutoTextViewCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setChoseKindPet(adapterView.getItemAtPosition(i).toString());
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
                Question tempQuestion = new Question();
                tempQuestion.setTitle(questionNew_EDXT_Titel.getText().toString());
                tempQuestion.setText(questionNew_EDXT_Text.getText().toString());
                tempQuestion.setIdQ(UUID.randomUUID().toString());
                tempQuestion.setCategory(getChoseKindPet());
                dataManager.addNewQuestion(tempQuestion);
                dataManager.getQuestions().add(tempQuestion);
                dataManager.getCallBackQuestion().question();
                for (int i = 0; i <dataManager.getQuestions().size() ; i++) {
                    Log.d("roman" + i, dataManager.getQuestions().get(i).toString());
                }
                Intent intent = new Intent(Activity_New_Question.this, Activity_menu.class);

                startActivity(intent);
                finish();


            }
        }));
    }




    private void findView() {
        questionNew_BTN_finish = findViewById(R.id.questionNew_BTN_finish );
        questionNew_BTN_Back = findViewById(R.id.questionNew_BTN_Back );
        questionNew_EDXT_Titel=findViewById(R.id.questionNew_EDXT_Titel );
        questionNew_EDXT_Text = findViewById(R.id.questionNew_EDXT_Text );
        questionNew_AutoTextViewCat = findViewById(R.id.questionNew_AutoTextViewCat );
         String[] options ={"cat","dog","fish","parrot","rabbit","hamster"};

        adapterKindPets = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options);

        questionNew_AutoTextViewCat.setAdapter(adapterKindPets);

    }


    public String getChoseKindPet() {
        return choseKindPet;
    }

    public Activity_New_Question setChoseKindPet(String choseKindPet) {
        this.choseKindPet = choseKindPet;
        return this;
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }

}