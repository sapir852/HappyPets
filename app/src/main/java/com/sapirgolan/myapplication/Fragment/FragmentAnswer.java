package com.sapirgolan.myapplication.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sapirgolan.myapplication.Adapters.AdapterAnswer;
import com.sapirgolan.myapplication.Adapters.AdapterQuestion;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;


public class FragmentAnswer extends Fragment {

    private final DataManager dataManager = DataManager.getData();
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private AdapterAnswer adapterAnswer;


    public Fragment setActivity(AppCompatActivity appCompatActivity){
        this.appCompatActivity=appCompatActivity;
        return this;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        findViews(view);

        return view;

    }

    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.animation_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.appCompatActivity));

        adapterAnswer = new AdapterAnswer(this.appCompatActivity,dataManager.getAnswers());
        recyclerView.setAdapter(adapterAnswer);
    }
}