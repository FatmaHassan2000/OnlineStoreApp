package com.example.finalprojict;

public class CartItem{

     int id;
     String name ;
     String Price ;

    public static final String TABLE_NAME = "cartitem";

    public static final String COL_ID = "id";
    public static final String COL_Name = "name";
    public static final String COL_Price = "price";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME+
            "(" +COL_ID+" integer primary key autoincrement," + COL_Name + " text," + COL_Price +
            " text)";


    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

    public CartItem(int id ,String name  , String price  ) {
        this.id = id;
        this.name = name;
        this.Price= price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(String price) {
        this.Price = price;
    }

    public String getPrice(){return Price;}


}
