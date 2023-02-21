package com.sapirgolan.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sapirgolan.myapplication.Adapters.AdapterKindPets;
import com.sapirgolan.myapplication.Adapters.AdapterQuestion;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.activity.Activity_menu;
import com.sapirgolan.myapplication.activity.object.KindPets;
import com.sapirgolan.myapplication.activity.object.Question;
import com.sapirgolan.myapplication.placeholder.PlaceholderContent;

import java.util.ArrayList;


public class Fragment_Question extends Fragment {

    private final DataManager dataManager = DataManager.getData();
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private AdapterQuestion adapterQuestion;




    CallBackList callBackQuestion = new CallBackList(){
        @Override
        public void onClicked() {
            getParentFragmentManager().beginTransaction().replace(R.id.menu_LAY_fragmant,Fragment_Question.class,null).commit();
        }

    };
    public Fragment setActivity(AppCompatActivity appCompatActivity){
        this.appCompatActivity=appCompatActivity;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__question, container, false);
        //dataManager.setQuestionByCategory("dog");
        findViews(view);

        return view;

    }
    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.question_LST_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.appCompatActivity));
        final ArrayList<Question> questionList = new ArrayList<>();


        adapterQuestion = new AdapterQuestion(this.appCompatActivity,dataManager.getQuestions(),callBackQuestion);
        recyclerView.setAdapter(adapterQuestion);


        FirebaseDatabase database=FirebaseDatabase.getInstance("https://happypets-fd8b0-default-rtdb.europe-west1.firebasedatabase.app/");

        DatabaseReference myRef=database.getReference("question");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot quesnapshot : snapshot.getChildren()) {

                    Question currentQuestion = new Question();

                    currentQuestion.setIdQ(quesnapshot.getKey());
                    String category = quesnapshot.child("category").getValue(String.class);
                    String title = quesnapshot.child("title").getValue(String.class);
                    String text = quesnapshot.child("text").getValue(String.class);
                    currentQuestion.setCategory(category);
                    currentQuestion.setTitle(title);
                    currentQuestion.setText(text);
                    questionList.add(currentQuestion);
                    Log.d("text", currentQuestion + "");
                }
                adapterQuestion.notifyDataSetChanged();
                dataManager.setQuestion(questionList);
                // Toast.makeText(appCompatActivity, " "+questionList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(appCompatActivity, "error reading from firebase ", Toast.LENGTH_SHORT).show();
            }});
        adapterQuestion = new AdapterQuestion(this.appCompatActivity,questionList,callBackQuestion);
        recyclerView.setAdapter(adapterQuestion);
    }


    //  }



}