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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sapirgolan.myapplication.Adapters.AdapterQuestion;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;


public class Fragment_Question extends Fragment {

    private final DataManager dataManager = DataManager.getData();
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private AdapterQuestion adapterQuestion;
    //String dataValue = getIntent().getStringExtra("data_key");




    CallBackList callBackQuestion = new CallBackList(){
        @Override
        public void onClicked() {
//            Intent intent = new Intent(getActivity(), ActivityNewAnswer.class);
//          //  intent.putExtra("data_key", dataValue);
//            startActivity(intent);

            getParentFragmentManager().beginTransaction().replace(R.id.menu_LAY_fragmant,FragmentAnswer.class,null).commit();
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
        dataManager.setQuestionByCategory("category");
        findViews(view);
        return view;

    }
    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.question_LST_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.appCompatActivity));


        adapterQuestion = new AdapterQuestion(this.appCompatActivity,dataManager.getKindArrOrder(),callBackQuestion);
        recyclerView.setAdapter(adapterQuestion);

        //        adapterQuestion = new AdapterQuestion(this.appCompatActivity,questionList,callBackQuestion);
//        recyclerView.setAdapter(adapterQuestion);
    }
}