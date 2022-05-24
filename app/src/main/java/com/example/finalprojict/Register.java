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

public class Register extends AppCompatActivity {
    EditText Email, Password, Name,Age ;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);
        Name = (EditText)findViewById(R.id.editName);
        Age = (EditText)findViewById(R.id.editAge);

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=Email.getText().toString();
                String pass=Password.getText().toString();
                String name=Name.getText().toString();
                int age=Integer.parseInt(Age.getText().toString());

                SharedPreferences sp = getSharedPreferences ("clinic", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("id",1);
                editor.putString("email",email);
                editor.putInt("age",age);
                editor.putString("name",name);
                editor.putString("password",pass);
                editor.commit();

                boolean res=sqLiteHelper.insertUser(name,email,pass,age);
                if(res) {
                    Toast.makeText(Register.this, "Addeed success", Toast.LENGTH_SHORT).show();
                    Intent Go = new Intent(Register.this, main_screen.class);
                    startActivity(Go);
                }
                else
                    Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void c(View view) {
        Intent n = new Intent(this, Login1.class);
        startActivity(n);
    }
}
