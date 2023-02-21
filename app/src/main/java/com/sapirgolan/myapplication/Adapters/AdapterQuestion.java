package com.sapirgolan.myapplication.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.CallBack.CallBackQuestion;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.KindPets;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;

public class AdapterQuestion extends RecyclerView.Adapter<AdapterQuestion.saveHolder> {

    private DataManager dataManager = DataManager.getData();
    private CallBackList callBackList;
    private ArrayList<Question> questions;
    private Context context;

    public AdapterQuestion( Context context, ArrayList<Question> questions, CallBackList callBackLis){
        this.questions = questions;
        this.context = context;
        this.callBackList=callBackLis;
    }
    @Override
    public int getItemCount()  {
        return questions == null ? 0 : questions.size();
    }

    @Override
    public AdapterQuestion.saveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_question, parent, false);
        AdapterQuestion.saveHolder saveHolder =new AdapterQuestion.saveHolder(view);
        return saveHolder;
    }
    @Override
    public void onBindViewHolder(final AdapterQuestion.saveHolder holder, int position) {

        Question question =questions.get(position);

        holder.question_LBL_title.setText("Title : "+question.getTitle());
        holder.question_LBL_text.setText("Text : "+question.getText());


    }


    public class saveHolder extends RecyclerView.ViewHolder {
        private MaterialTextView question_LBL_title,question_LBL_text;


        public saveHolder(final View itemView) {
            super(itemView);
            question_LBL_title = itemView.findViewById(R.id.question_LBL_title);
            question_LBL_text= itemView.findViewById(R.id.question_LBL_text);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //if (callBackList!= null) {

                        dataManager.setOneQuestion(questions.get(getBindingAdapterPosition()));
                    Log.d("text",questions.get(getBindingAdapterPosition()) + "");

                    callBackList.onClicked();

                  //  }
                }
            });

        }}




}
