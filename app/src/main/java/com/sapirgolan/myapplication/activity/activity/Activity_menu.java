package com.sapirgolan.myapplication.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sapirgolan.myapplication.Adapters.AdapterQuestion;
import com.sapirgolan.myapplication.Fragment.Fragment_kind_pets;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.FullScreen;
import com.sapirgolan.myapplication.activity.object.Question;

import java.net.HttpCookie;
import java.util.ArrayList;

public class Activity_menu extends AppCompatActivity {
    private final DataManager dataManager = DataManager.getData();
    private final FirebaseDatabase realtimeDB = dataManager.getFirebaseDatabase();
    private AppCompatImageView menu_IMG_background;
    private MaterialButton menu_BTN_addQ, menu_BTN_backQ;
    private Fragment_kind_pets fragment_kind_pets;
    private Fragment[] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findView();
        initViews();


        fragment_kind_pets = (Fragment_kind_pets) new Fragment_kind_pets().setActivity(this);

        getSupportFragmentManager().beginTransaction().add(R.id.menu_LAY_fragmant, fragment_kind_pets).commit();
        Glide
                .with(Activity_menu.this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPQtbWlOYDJoXbQIozPZZCDpm7PhEMuu9Osw&usqp=CAU")
                .into(menu_IMG_background);




//        DatabaseReference databaseReferenceQues =realtimeDB.getReference("user").child(FirebaseAuth.getInstance().
//                getCurrentUser().getUid()).child("categories");
//                //realtimeDB.getReference("user").child("categories");
//        for (int i = 0; i < dataManager.getKindName().size(); i++) {
//            DatabaseReference databaseReferenceKind = databaseReferenceQues.child(dataManager.getKindName().get(i));
//            ArrayList<Question> questionList = new ArrayList<>();
//            databaseReferenceQues.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.exists()) {
//                        // Get the array from the snapshot
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            Question tempQ = new Question();
//                            //add answer
//
//                            tempQ.setIdQ(dataSnapshot.getKey());
//                            String category = dataSnapshot.child("category").getValue(String.class);
//                            String title = dataSnapshot.child("title").getValue(String.class);
//                            String text = dataSnapshot.child("text").getValue(String.class);
//                            tempQ.setCategory(category);
//                            tempQ.setTitle(title);
//                            tempQ.setText(text);
//                            questionList.add(tempQ);
//                            for (DataSnapshot ds : dataSnapshot.child("children").getChildren()) {
//                                Log.d("TAGd", ds.getValue(String.class));
//                            }
//                        }
//                        dataManager.setQuestion(questionList);
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//        }
    }


        private void initViews() {

        menu_BTN_addQ.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_menu.this, Activity_New_Question.class);

                startActivity(intent);
                finish();

            }
        }));
        menu_BTN_backQ.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_menu.this, Activity_menu.class);

                startActivity(intent);
                finish();

            }
        }));

    }

    private void findView() {
        menu_IMG_background = findViewById(R.id.menu_IMG_background);
        menu_BTN_addQ = findViewById(R.id.menu_BTN_addQ);
        menu_BTN_backQ = findViewById(R.id.menu_BTN_backQ);


    }




    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }
}