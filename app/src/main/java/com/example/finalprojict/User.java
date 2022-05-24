package com.example.finalprojict;

public class User {
    private int id;
    private String name;
    private String passwerd;
    private String email;
    private int age;

    public static final String TABLE_NAME = "User";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_PASSWERD = "passwerd";
    public static final String COL_EMAIL = "email";
    public static final String COL_AGE = "age";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME +
            "(" + COL_ID + " integer primary key autoincrement," + COL_NAME +
            " text," + COL_PASSWERD +" text,"+ COL_EMAIL+ " text,"+COL_AGE+" integer)";

    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

    public User(int id, String name, String passwerd, String email, int age) {
        this.id = id;
        this.name = name;
        this.passwerd = passwerd;
        this.email = email;
        this.age = age;
    }

    public User() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswerd() {
        return passwerd;
    }

    public String getEmail() { return email; }

    public void setId(int phone) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswerd(String passwerd) { this.passwerd = passwerd; }

    public void setEmail(String email) { this.email = email; }
}

