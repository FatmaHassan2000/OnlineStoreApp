package com.example.finalprojict;

public class category {
    int image;
    String name;
    String rating;
    String Price ;
    String desc;

    public category() {
    }

    public category(int image, String name , String rating  , String price , String desc) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.Price= price;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice(){return Price;}

    public void setPrice(String price) {
        this.Price = price;
    }

    public void setDesc(String desc) {this.desc = desc; }

    public String getDesc(){return desc;}
}
