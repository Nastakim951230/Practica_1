package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.Attributes;

public class Adding extends AppCompatActivity {

    Connection connection;
    String ConnectionResult="";

    EditText Name, Surname, MiddleName,Floor,DateOfBirth,PlaceOfWork,JobTitle,PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);





    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nazad:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }



    }
}