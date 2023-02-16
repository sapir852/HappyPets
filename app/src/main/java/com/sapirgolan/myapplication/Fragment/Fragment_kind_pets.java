package com.sapirgolan.myapplication.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sapirgolan.myapplication.Adapters.AdapterKindPets;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
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
          //  getParentFragmentManager().beginTransaction().replace(R.id.menu_LAY_fragmant,Fragment_kind_pets,null).commit();
        }

    };



public Fragment setActivity(AppCompatActivity appCompatActivity){
    this.appCompatActivity=appCompatActivity;
    return this;
}


    private void initAdapter() {
        ArrayList<KindPets> kind = dataManager.geKindPett();
        adapterKindPets = new AdapterKindPets(this.appCompatActivity, kind);
        recyclerView.setLayoutManager(new GridLayoutManager(this.appCompatActivity,2));
        recyclerView.setAdapter(adapterKindPets);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind_pets, container, false);
    //        dataManager.setCallBackList(callBackKind); זה של שאלה צריך להיות
        findViews(view);
        initAdapter();
        return view;

    }
    private void findViews(View view) {
        recyclerView = view.findViewById(R.id.kindPets_LST_recyclerView);
    }
}