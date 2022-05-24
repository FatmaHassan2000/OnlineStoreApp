package com.example.finalprojict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    CartAdapter adapter;
    RecyclerView recyclerView;
    TextView order;
   // Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView rec=findViewById(R.id.cartRecyclerView);


       SQLiteHelper sqLiteHelper = new SQLiteHelper(Cart.this);
       ArrayList<CartItem> carts = new ArrayList<>();

        

        carts = sqLiteHelper.showAllItims();

        adapter = new CartAdapter(this , R.layout.cart_item, carts) ;
        RecyclerView.LayoutManager lim = new LinearLayoutManager(Cart.this);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(lim);
        rec.setAdapter(adapter);

    }

    public void buy(View view) {
        Toast.makeText(Cart.this, "Operation accomplished successfully", Toast.LENGTH_SHORT).show();
    }
}