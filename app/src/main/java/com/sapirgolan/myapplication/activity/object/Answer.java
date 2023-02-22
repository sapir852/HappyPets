package com.sapirgolan.myapplication.activity.object;

public class Answer {
    private String title="";
    private String  text="";
    private String idQuestion;


    public Answer() {
    }

    public Answer(String title, String text,String idQuestion) {
        this.title = title;
        this.text = text;
        this.idQuestion=idQuestion;
    }

    public String getTitle() {
        return title;
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
    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }



}
