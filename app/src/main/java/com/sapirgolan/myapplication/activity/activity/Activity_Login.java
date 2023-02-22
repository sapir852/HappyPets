package com.sapirgolan.myapplication.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.FullScreen;

public class Activity_Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    AppCompatImageView login_IMG_background;
    private EditText login_ETXT_password, login_ETXT_email;
    private MaterialButton login_BTN_Login;
    private MaterialButton login_BTN_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        findView();
        initViews();


//        Glide
//                .with(Activity_Login.this)
//                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPQtbWlOYDJoXbQIozPZZCDpm7PhEMuu9Osw&usqp=CAU")
//                .into(login_IMG_background);


    }

    private void initViews() {
        login_BTN_Login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        }));

        login_BTN_back.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }
        }));
    }

    private void findView() {
        login_IMG_background = findViewById(R.id.login_IMG_background);
        login_ETXT_password = findViewById(R.id.login_ETXT_password);
        login_ETXT_email = findViewById(R.id.login_ETXT_email);
        login_BTN_Login = findViewById(R.id.login_BTN_Login);
        login_BTN_back = findViewById(R.id.login_BTN_back);
    }

    private void signIn() {
        String email = login_ETXT_email.getText().toString();
        String password = login_ETXT_password.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Activity_Login.this, "Please full all the fields ", Toast.LENGTH_LONG).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login_ETXT_email.setError("Please provide valid email!");
            login_ETXT_email.requestFocus();
            return;
        }

        if (password.length() < 6) {
            login_ETXT_password.setError("Minmum password lenght should be 6 characters");
            login_ETXT_password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Activity_Login.this, "logIn", Toast.LENGTH_LONG).show();
                    openMenu();
                } else {
                    Toast.makeText(Activity_Login.this, "One or more of the fields you entered are incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    private void openMenu() {
        Intent intent = new Intent(Activity_Login.this, Activity_menu.class);
        startActivity(intent);
        finish();
    }

    private void signOut() {
        Intent intent = new Intent(Activity_Login.this, Activity_login_Main.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            FullScreen.hideSystemUI(this);
        }
    }


}