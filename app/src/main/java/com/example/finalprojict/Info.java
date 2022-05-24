package com.example.finalprojict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends AppCompatActivity {
    ImageView imageView;
    ImageView love_icon;
    TextView itemName, itemPrice, itemRating , itemdesc;
    RatingBar ratingBar;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

        itemdesc = findViewById(R.id.infodesc);
        imageView = findViewById(R.id.infoimg);
        love_icon = findViewById(R.id.infofav);
        itemName = findViewById(R.id.infpname);
        itemPrice = findViewById(R.id.infoprice);
        ratingBar = findViewById(R.id.inforating);
        btnAdd = findViewById(R.id.addcart);

        imageView.setImageResource(getIntent().getIntExtra("image" ,0));
        itemName.setText(getIntent().getStringExtra("name"));
        itemPrice.setText(getIntent().getStringExtra("price"));
        itemdesc.setText(getIntent().getStringExtra("desc"));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price=itemPrice.getText().toString();
               String name=itemName.getText().toString();

                SharedPreferences sp = getSharedPreferences ("clinic", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("id",1);
                editor.putString("price",price);
                editor.putString("name",name);
                editor.commit();

                boolean res=sqLiteHelper.insertCartItim(name,price);
                if(res) {
                    Toast.makeText(Info.this, "Addeed success", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(Info.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        
    }

    public void back(View view) {
        Intent back = new Intent(this, main_screen.class);
        startActivity(back);
    }

    public void buyy(View view) {
        Toast.makeText(Info.this, "Operation accomplished successfully", Toast.LENGTH_SHORT).show();
    }
}