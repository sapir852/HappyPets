package com.sapirgolan.myapplication.activity.object;

import java.util.ArrayList;

public class Question {
    private String category;
    private String name;
    private String title="";
    private String  text="";
    private String imagePet;
    private ArrayList<Question> questions;


    public Question() {}

    public Question(String category, String name, String title, String text, String imagePet) {
        this.category = category;
        this.name = name;
        this.title = title;
        this.text = text;
        this.imagePet = imagePet;
        this.questions = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
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

    public String getImagePet() {
        return imagePet;
    }

    public void setImagePet(String imagePet) {
        this.imagePet = imagePet;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", imagePet='" + imagePet + '\'' +
                '}';
    }


}
