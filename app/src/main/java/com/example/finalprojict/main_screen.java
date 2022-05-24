package com.example.finalprojict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class main_screen extends AppCompatActivity {
    RecyclerView category,main;
    CategoryAdapter categoryAdapter;
    PieceAdapter pieceAdapter;
    ArrayList<com.example.finalprojict.category> categories;
    ArrayList<Piece> pieces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        category = findViewById(R.id.categoryRec);
        categories=new ArrayList<>();
        categoryAdapter=new CategoryAdapter(categories);

        categories.add(new category(R.drawable.item1,"High Heels", "91%" , "50$", "High heels are a type of shoe in which the heel is significantly higher off the ground compared to the toes"));
        categories.add(new category(R.drawable.item2,"Sport Bot", "81%" , "45$", "Spice up your Discord experience with our diverse range of Sports Discord bots"));
        categories.add(new category(R.drawable.item3,"Small Bag", "95%" , "20$", "Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        categories.add(new category(R.drawable.item4,"Accessories", "81%" , "15$", "Accessories"));
        categories.add(new category(R.drawable.item5,"Shoulder Bag", "92%" , "30$", "Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        categories.add(new category(R.drawable.item6,"Postar", "85%" , "120$", "Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        categories.add(new category(R.drawable.item7,"Backpack", "75%" , "52$", "Small Bag for Daily Use - 1 Compartment Mini Backpack"));

        category.setAdapter(categoryAdapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(main_screen.this, LinearLayoutManager.HORIZONTAL, false);
        category.setLayoutManager(horizontalLayoutManagaer);
        category.setVisibility(View.VISIBLE);

        main = findViewById(R.id.mainRec);
        pieces=new ArrayList<>();
        pieceAdapter=new PieceAdapter(pieces);

        pieces.add(new Piece("Disitinctive bag",R.drawable.item8,"70%","30$" ,  "Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Sport Bot",R.drawable.item9,"40%","30$" ,  "Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Soft bag",R.drawable.item10,"50%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Spirt Bot",R.drawable.item11,"80%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("White shirt",R.drawable.item12,"50%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Modren shirt",R.drawable.item13,"80%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Accessories",R.drawable.item14,"50%","30$" ,"Accessories"));
        pieces.add(new Piece("Small Bag",R.drawable.item16,"50%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("jeans",R.drawable.item17,"50%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));
        pieces.add(new Piece("Modren shirt",R.drawable.item18,"50%","30$" ,"Small Bag for Daily Use - 1 Compartment Mini Backpack"));

        main.setAdapter(pieceAdapter);
        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(main_screen.this, LinearLayoutManager.HORIZONTAL, false);
        main.setLayoutManager(horizontalLayoutManagaer1);
        main.setVisibility(View.VISIBLE);

    }

    public void cart(View view) {
        Intent cart = new Intent(this, Cart.class);
        startActivity(cart);
    }



}