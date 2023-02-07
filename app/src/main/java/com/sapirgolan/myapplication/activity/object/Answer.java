package com.sapirgolan.myapplication.activity.object;

public class Answer {
    private String title="";
    private String  text="";

    public Answer() {
    }

    public Answer(String title, String text) {
        this.title = title;
        this.text = text;
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

    @Override
    public String toString() {
        return "Answer{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
