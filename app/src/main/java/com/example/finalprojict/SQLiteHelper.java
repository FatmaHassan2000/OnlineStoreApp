package com.example.finalprojict;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public static final String DATABASE_NAME = "UserDataBase.db";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null,20);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_TABLE);
        db.execSQL(InFoModle.CREATE_TABLE);
        db.execSQL(CartItem.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + InFoModle.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CartItem.TABLE_NAME);
        onCreate(db);

    }
    public boolean insertUser(String name, String email, String pass,int age) {
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User.COL_NAME, name);
        cv.put(User.COL_AGE, age);
        cv.put(User.COL_EMAIL, email);
        cv.put(User.COL_PASSWERD, pass);
        long newRowID = db.insert(User.TABLE_NAME, null, cv);
        return newRowID > 0;
    }
    public boolean insertCart(String name, String price) {
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(InFoModle.COL_Name, name);
        cv.put(InFoModle.COL_Price, price);
      //  cv.put(doctormodel.COL_Dep, dep);
        long newRowID = db.insert(InFoModle.TABLE_NAME, null, cv);
        return newRowID > 0;
    }

    public boolean insertCartItim(String name, String price) {
        db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CartItem.COL_Name, name);
        cv.put(CartItem.COL_Price, price);
        //  cv.put(doctormodel.COL_Dep, dep);
        long newRowID = db.insert(CartItem.TABLE_NAME, null, cv);
        return newRowID > 0;
    }

    public ArrayList<CartItem> showAllItims() {
        db=this.getReadableDatabase();
        ArrayList<CartItem> items = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CartItem.TABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst())
            do {
                int id = cursor.getInt(cursor.getColumnIndex(CartItem.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(CartItem.COL_Name));
                String price = cursor.getString(cursor.getColumnIndex(CartItem.COL_Price));
                //String address = cursor.getString(cursor.getColumnIndex(doctormodel.COL_Addess));

                CartItem cart = new CartItem(id, name, price );
                items.add(cart);
            } while (cursor.moveToNext());

        return items;
    }/*
    public StringBuffer showAllUser() {
        db=this.getReadableDatabase();
        StringBuffer items = new StringBuffer();
        Cursor cursor = db.rawQuery("SELECT * FROM " + User.TABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst())
            do {
                int id = cursor.getInt(cursor.getColumnIndex(User.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(User.COL_NAME));
                String email = cursor.getString(cursor.getColumnIndex(User.COL_EMAIL));
                String pass = cursor.getString(cursor.getColumnIndex(User.COL_PASSWERD));
                int phone = cursor.getInt(cursor.getColumnIndex(User.COL_AGE));
                //String address = cursor.getString(cursor.getColumnIndex(doctormodel.COL_Addess));

                User user = new User(id, name, email , pass , phone );
                items.append(user);
            } while (cursor.moveToNext());

        return items;
    }*/

    public boolean deleteCartItim(String name) {
        db=this.getWritableDatabase();
        String whereClause = CartItem.COL_Name + " =?";
        String[] whereArgs = {name};
        int count = db.delete(CartItem.TABLE_NAME, whereClause, whereArgs);

        return count > 0;
    }

}
