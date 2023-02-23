package com.sapirgolan.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.DataBase.DataManager;
import com.sapirgolan.myapplication.activity.activity.ActivityAllAnswer;
import com.sapirgolan.myapplication.activity.object.Answer;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;

public class AdapterQuestion extends RecyclerView.Adapter<AdapterQuestion.saveHolder> {

    private DataManager dataManager = DataManager.getData();
    private CallBackList callBackList;
    private ArrayList<Question> questions;
    private ArrayList<Answer>answers;
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
//    private void initViews() {
//
//        question_BTN_addA.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(appCompatActivity, ActivityNewAnswer.class);
//                startActivity(intent);
//                appCompatActivity.finish();
//
//            }
//        }));
//    }


    public class saveHolder extends RecyclerView.ViewHolder {
        private MaterialTextView question_LBL_title,question_LBL_text;



        public saveHolder(final View itemView) {
            super(itemView);
            question_LBL_title = itemView.findViewById(R.id.question_LBL_title);
            question_LBL_text= itemView.findViewById(R.id.question_LBL_text);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // notifyDataSetChanged();
                    dataManager.setOneQuestion(questions.get(getBindingAdapterPosition()));
//                    Log.d("text",questions.get(getBindingAdapterPosition()) + "");
//
                 //   dataManager.setAnswerByCategory(dataManager.getOneQuestin().getIdQ());

                     KindArr();
                    dataManager.setAnswerArrOrder(answers);

                    view.getContext().startActivity(new Intent(view.getContext(), ActivityAllAnswer.class));
                    // Intent intent = new Intent(this, AdapterAnswer.class);
//                startActivity(intent);
//                appCompatActivity.finish();





                }
            });

        }}

    public void KindArr(){
        answers = new ArrayList<>();
        for(int i=0; i<dataManager.getAnswers().size(); i++) {
            if(dataManager.getAnswers().get(i).getIdQuestion().equals(dataManager.getOneQuestin().getIdQ())){
                answers.add(dataManager.getAnswers().get(i));

            }
        }
        notifyDataSetChanged();

    }

}
