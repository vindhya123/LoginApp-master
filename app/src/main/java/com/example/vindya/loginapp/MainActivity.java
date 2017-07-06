package com.example.vindya.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button loginbutton,registerbutton;
    EditText Uname;
    EditText Upass;
    sqlitDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton=(Button)findViewById(R.id.UloginButton);
        registerbutton=(Button)findViewById(R.id.registerButton);
        Uname=(EditText)findViewById(R.id.userNameEditText);
        Upass=(EditText)findViewById(R.id.passwordEdittext);
        db= new sqlitDatabase(getApplicationContext());

    }
    public void Login(View view) {
        db = new sqlitDatabase(this);
        String Lusername = Uname.getText().toString();
        String Lpassword = Upass.getText().toString();
        String StoredPassWord = db.ValidateData(Lusername);

        if (Uname.equals(null) || Upass.equals(null))
        {
            Toast.makeText(getApplicationContext(),"make sure all the fields are filled",Toast.LENGTH_LONG).show();
        }
        if(Lpassword.equals(StoredPassWord))
        {
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),example.class));
        }
        else
        {
            Toast.makeText(this,"InValid User register....",Toast.LENGTH_LONG).show();
            Uname.setText("");
            Upass.setText("");

        }

    }
    public void registrationPage(View view)
    {
        Intent in=new Intent(this,RegistrationPage.class);
        startActivity(in);


    }
}
