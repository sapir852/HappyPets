package com.sapirgolan.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.sapirgolan.myapplication.R;
import com.sapirgolan.myapplication.activity.CallBack.CallBackList;
import com.sapirgolan.myapplication.activity.Firbase.DataManager;
import com.sapirgolan.myapplication.activity.object.KindPets;
import com.sapirgolan.myapplication.activity.object.Question;

import java.util.ArrayList;

public class AdapterKindPets extends RecyclerView.Adapter<AdapterKindPets.saveHolder> {
   private DataManager dataManager = DataManager.getData();
    private ArrayList<KindPets> kindPets;
    private CallBackList callBackList;
    private ArrayList<Question> questions;
    private Context context;



    public AdapterKindPets( Context context, ArrayList<KindPets> kindPets,CallBackList callBackList){
        this.kindPets = kindPets;
        this.context = context;
        this.callBackList=callBackList;
    }
    @Override
    public int getItemCount()  {
        return kindPets == null ? 0 : kindPets.size();
    }

    @Override
    public saveHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_kind_pets, parent, false);
        saveHolder saveHolder =new  saveHolder(view);
        return saveHolder;
    }
    @Override
    public void onBindViewHolder(final saveHolder holder, int position) {

        KindPets kindPet =kindPets.get(position);

        holder.list_LBL_title.setText(kindPet.getName());

        Glide
                .with(context)
                .load(kindPet.getImageKind())
                .into(holder.list_IMG_kind);


    }
    public class saveHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView list_IMG_kind;
        private MaterialTextView list_LBL_title;


        public saveHolder(final View itemView) {
            super(itemView);
            list_IMG_kind = itemView.findViewById(R.id.list_IMG_kind);
            list_LBL_title = itemView.findViewById(R.id.list_LBL_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callBackList!= null) {;
                     //   DataManager dataManager = AdapterKindPets.this.dataManager.setKindName(kindPets.get(getBindingAdapterPosition   ()).getName());
                        dataManager.setQuestionByCategory(kindPets.get(getBindingAdapterPosition()).getName());

                        KindArr(dataManager.getQuestionByCategory());
                        dataManager.setKindArrOrder(questions);
                     //   AdapterKindPets.this.dataManager.setKindArrOrder(questions);
                        callBackList.onClicked();




                    }
                }
            });

        }

    }

    public void KindArr(String currentCategoryName){
        questions = new ArrayList<>();
        for(int i=0; i<dataManager.getQuestions().size(); i++) {
            if(dataManager.getQuestions().get(i).getCategory().equals(currentCategoryName)){
                questions.add(dataManager.getQuestions().get(i));

            }
        }
        notifyDataSetChanged();

    }



}
