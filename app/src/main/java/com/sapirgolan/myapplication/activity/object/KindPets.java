package com.sapirgolan.myapplication.activity.object;

import java.util.ArrayList;

public class KindPets {

    private String title = "";
    private String imageKind = "https://firebasestorage.googleapis.com/v0/b/foodelicious-8c630.appspot.com/o/default_pictures%2Fic_pizza.jpg?alt=media&token=c87bd811-480c-4e90-8c63-6726a78fc865";
    private ArrayList<String> items;


    public KindPets() {
    }

    public KindPets(String title, String imageKind) {
        this.title = title;
        this.imageKind = "https://firebasestorage.googleapis.com/v0/b/foodelicious-8c630.appspot.com/o/default_pictures%2Fic_pizza.jpg?alt=media&token=c87bd811-480c-4e90-8c63-6726a78fc865";
        this.items = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }
    public KindPets setTitle(String title) {
        this.title = title;
        return this;
    }

    public KindPets setImageKind(String imageKind) {
        this.imageKind = imageKind;
        return this;
    }
    public String getImageKind() {
        return imageKind;
    }


}
