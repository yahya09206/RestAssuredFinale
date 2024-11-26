package com.yahya.pojo;

/*
    Another common way of representing json data is using special purpose Java Object created from A class
      that have fields matched to json keys
      and have getters and setters
      This type of Object, sole purpose is to represent data
      known as POJO, plain old java object
      The class to create POJO known as POJO class
      it's used for creating pojo, just like you would create any other object

      In order to represent a json data with 3 keys name, gender, phone we can create a java class
      with 3 instance fields with some names

      only requirements are encapsulated fields such as private instance variables and getters/setters
     */
public class Spartan {

    private String name;
    private String gender;
    private long phone;

    public Spartan(){
        // no body required
    }

    public Spartan(String name, String gender, long phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}
