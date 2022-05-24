package com.example.finalprojict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login1 extends AppCompatActivity {
    Button LogInButton ;
    EditText Email, Password ;
    SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        LogInButton = (Button) findViewById(R.id.buttonLogin);
        Email = (EditText) findViewById(R.id.logEmail);
        Password = (EditText) findViewById(R.id.logPassword);

        sqLiteHelper = new SQLiteHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=Email.getText().toString();
                String pass=Password.getText().toString();
                SharedPreferences sp = getSharedPreferences ("clinic", Context.MODE_PRIVATE);

                if((email.equals(sp.getString("email",null))) && (pass.equals(sp.getString("password",null)))){
                    Intent Go = new Intent(Login1.this, main_screen.class);
                    startActivity(Go);
                }else
                    Toast.makeText(Login1.this, "incorrect email and password", Toast.LENGTH_SHORT).show();

            }
        }); }

}
