package com.sapirgolan.myapplication.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sapirgolan.myapplication.Adapters.AdapterKindPets;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.CallBack.CallBackQuestion;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.KindPets;

import java.util.ArrayList;

public class Fragment_kind_pets extends Fragment {

    private final DataManager dataManager = DataManager.getData();
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private AdapterKindPets adapterKindPets;


    CallBackList callBackKind = new CallBackList(){
        @Override
        public void onClicked() {

            getParentFragmentManager().beginTransaction().replace(R.id.menu_LAY_fragmant,Fragment_Question.class,null).commit();
        }

    };

    CallBackQuestion callBackQuestion = new CallBackQuestion() {
        @Override
        public void question() {
            adapterKindPets.notifyDataSetChanged();

        }


    };

    public Fragment setActivity(AppCompatActivity appCompatActivity){
        this.appCompatActivity=appCompatActivity;
        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind_pets, container, false);
          dataManager.setCallBackQuestion(callBackQuestion);
        findViews(view);
        return view;

    }
    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.kindPets_LST_recyclerView);

     //   ArrayList<KindPets> kind = dataManager.getKindPett();
        adapterKindPets = new AdapterKindPets(this.appCompatActivity, dataManager.getKindPets(),callBackKind);
        recyclerView.setLayoutManager(new GridLayoutManager(this.appCompatActivity,2));
        recyclerView.setAdapter(adapterKindPets);

    }
}