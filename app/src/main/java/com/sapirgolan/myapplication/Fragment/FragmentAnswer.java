package com.sapirgolan.myapplication.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sapirgolan.myapplication.Adapters.AdapterAnswer;
import com.sapirgolan.myapplication.Adapters.AdapterQuestion;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.Answer;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;


public class FragmentAnswer extends Fragment {

    private final DataManager dataManager = DataManager.getData();
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private AdapterAnswer adapterAnswer;

    public FragmentAnswer() {
    }

    public Fragment setActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        return this;
    }

//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_answer, container, false);
//        ViewGroup parent = (ViewGroup) view.getParent();
//        if (parent != null) {
//            parent.removeView(view);
//        }
//        Log.d("FragmentAnswer", "View hierarchy: " + view);
//        return view;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        findViews(view);
        Log.d("FragmentAnswer", "View hierarchy: " + view);

        return view;

    }

    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.answer_LST_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.appCompatActivity));
//        String tit = "ddd";
//        String tex = "ddddddd";
//        Answer an = new Answer();
//        an.setText(tit);
//        an.setTitle(tex);
//

        final ArrayList<Answer> answersList = new ArrayList<>();
        FirebaseDatabase database=FirebaseDatabase.getInstance("https://happypets-fd8b0-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef=database.getReference("answer");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot quesnapshott : snapshot.getChildren()) {
                    Answer currentAnswer = new Answer();
                    currentAnswer.setIdQuestion(quesnapshott.getKey());
                    // String id = quesnapshott.child("idQuestion").getValue(String.class);
                    String text = quesnapshott.child("text").getValue(String.class);
                    String title = quesnapshott.child("title").getValue(String.class);


                    //currentAnswer.setTitle(id);
                    currentAnswer.setTitle(title);
                    currentAnswer.setText(text);
                    answersList.add(currentAnswer);
                    Log.d("text", currentAnswer + "");

                }
                adapterAnswer.notifyDataSetChanged();
                dataManager.setAnswers(answersList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        //adapterAnswer.notifyDataSetChanged();
        adapterAnswer = new AdapterAnswer(this.appCompatActivity, dataManager.getAnswers());
        recyclerView.setAdapter(adapterAnswer);
    }
}