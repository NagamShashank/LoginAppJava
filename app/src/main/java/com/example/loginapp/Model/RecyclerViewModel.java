package com.example.loginapp.Model;

public class RecyclerViewModel {

    int Picture;
    String Ltext,Descrption,ID;


    public RecyclerViewModel(int picture, String ltext,String descrption,String id) {
        Picture = picture;
        Ltext = ltext;
        Descrption = descrption;
        ID = id;

    }

    public String getDescrption() {
        return Descrption;
    }

    public void setDescrption(String descrption) {
        Descrption = descrption;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getLtext() {
        return Ltext;
    }

    public void setLtext(String ltext) {
        Ltext = ltext;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


//    @Override
//    public int compareTo(RecyclerViewModel o) {
//        return ID - o.ID;
//    }
}
