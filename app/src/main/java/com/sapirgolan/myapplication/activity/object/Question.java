package com.sapirgolan.myapplication.activity.object;

import java.util.ArrayList;

public class Question {
    private String category;
    private String idQ;
    private String title="";
    private String  text="";
    // private String imagePet;
    private ArrayList<Answer> answers;


    public Question() {}

    public Question(String category, String idQ, String title, String text) {
        this.category = category;
        this.idQ=idQ;
        this.title = title;
        this.text = text;
        //  this.imagePet = imagePet;
        this.answers = new ArrayList<>();
    }

    public String getIdQ() {
        return idQ;
    }

    public void setIdQ(String idQ) {
        this.idQ = idQ;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }


    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public String getImagePet() {
//        return imagePet;
//    }
//
//    public void setImagePet(String imagePet) {
//        this.imagePet = imagePet;
//    }




}
