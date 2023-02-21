package com.sapirgolan.myapplication.activity.object;

public class User {

  private  String name;
  private String email;


  public User(){}

  public User(String name, String email) {
    this.name = name;
    this.email = email;

  }

  public String getName() {
    return name;
  }


  public String getEmail() {
    return email;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }


}
