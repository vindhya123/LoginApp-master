package com.example.vindya.loginapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vindya.loginapp.R;

public class RegistrationPage extends AppCompatActivity {
    sqlitDatabase helper= new sqlitDatabase(this);
    Button registeruserButton;
    EditText NAME;
    EditText EMAIL;
    EditText PHNO;
    EditText PASSWRD;
    EditText CNFRMPASS;
    String username;
    String email;
    String cellno;
    String pass1;
    String pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rigister);
        registeruserButton=(Button)findViewById(R.id.registeruserbuttton);
        NAME=(EditText)findViewById(R.id.nameEdittext);
        EMAIL=(EditText)findViewById(R.id.emailEdititext);
        PHNO=(EditText)findViewById(R.id.phnoEdititext);
        PASSWRD=(EditText)findViewById(R.id.passwordEdit);
        CNFRMPASS=(EditText)findViewById(R.id.confirmPassword);


    }

    public void registerUser(View view)
    {
        username=NAME.getText().toString();
        email=EMAIL.getText().toString();
        cellno=PHNO.getText().toString();
        pass1=PASSWRD.getText().toString();
        pass2=CNFRMPASS.getText().toString();


        if(NAME.equals(null)||EMAIL.equals(null)||PHNO.equals(null)||PASSWRD.equals(null)||CNFRMPASS.equals(null))
        {
            Toast.makeText(getApplicationContext(),"make sure all the fields are filled",Toast.LENGTH_LONG).show();
        }


        if(!pass1.equals(pass2))
        {
            Toast.makeText(RegistrationPage.this,"passwords doesn't match",Toast.LENGTH_SHORT).show();
            PASSWRD.setText("");
            CNFRMPASS.setText("");
        }
        else
        {
            information in = new information();
            in.setName(username);
            in.setEmailid(email);
            in.setPhno(cellno);
            in.setPassword(pass1);
            in.setConfirmpassword(pass2);

            helper.insertContact(in);
            Toast.makeText(RegistrationPage.this,"Your Account Details Saved",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));



        }




    }
}

