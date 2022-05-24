package com.example.finalprojict;

public class InFoModle {
    int id;
    String name ;
    // int Img ;
    String Price ;
    //String desc;

    public static final String TABLE_NAME = "cart";

    public static final String COL_ID = "id";
    public static final String COL_Name = "name";
    public static final String COL_Price = "price";
    // public static final String COL_Addess = "address";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME+
            "(" +COL_ID+" integer primary key autoincrement," + COL_Name + " text," + COL_Price +
            " text)";


    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

    public InFoModle(int id ,String name/*, int img */  , String price  /*,String desc*/) {
        this.id = id;
        this.name = name;
        // this.Img = img;
        this.Price= price;
        //  this.desc = desc;

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
/*
    public int getImg(){return Img;}

    public void setImg(int img) {
        this.Img = img;
    }*/

    public void setPrice(String price) {
        this.Price = price;
    }

    public String getPrice(){return Price;}

  /*  public void setDesc(String desc) {this.desc = desc;}

    public String getDesc(){return desc;}
*/
}
