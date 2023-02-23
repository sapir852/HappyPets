package com.sapirgolan.myapplication.Adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.DataBase.DataManager;
import com.sapirgolan.myapplication.activity.object.Answer;

import java.util.ArrayList;

public class AdapterAnswer extends RecyclerView.Adapter<AdapterAnswer.saveHolder> {
    private DataManager dataManager = DataManager.getData();
    private ArrayList<Answer> answers;
    private Context context;

    public AdapterAnswer(Context context, ArrayList<Answer> answers){
        this.answers = answers;
        this.context = context;

    }
    @Override
    public int getItemCount()  {
        return answers == null ? 0 : answers.size();
    }


    @Override
    public AdapterAnswer.saveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_answer, parent, false);
        AdapterAnswer.saveHolder saveHolder =new AdapterAnswer.saveHolder(view);
        return saveHolder;
    }


    @Override
    public void onBindViewHolder( AdapterAnswer.saveHolder holder, int position) {
        Answer answer =answers.get(position);

        holder.answer_LBL_title.setText("Title: "+answer.getTitle());
        holder.answer_LBL_text.setText("Answer: "+ answer.getText());

    }



    public class saveHolder extends RecyclerView.ViewHolder {
        private MaterialTextView answer_LBL_title,answer_LBL_text;


        public saveHolder(final View itemView) {
            super(itemView);
            answer_LBL_title = itemView.findViewById(R.id.answer_LBL_title);
            answer_LBL_text = itemView.findViewById(R.id.answer_LBL_text);

        }

    }

}