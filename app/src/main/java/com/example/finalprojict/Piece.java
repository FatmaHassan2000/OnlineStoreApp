package com.example.finalprojict;

public class Piece {
    String name;
    int image;
    String rating;
    String Price ;
    String desc;

    public Piece() {
    }

    public Piece(String name, int image,  String rating  , String price , String desc) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.Price= price;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setPrice(String price) {
        this.Price = price;
    }

    public String getPrice(){return Price;}

    public void setDesc(String desc) {this.desc = desc; }

    public String getDesc(){return desc;}
}
