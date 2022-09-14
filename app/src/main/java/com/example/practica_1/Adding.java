package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.jar.Attributes;

public class Adding extends AppCompatActivity {

    Connection connection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);




    }
    public void Add (View v)
    {
        EditText Name = findViewById(R.id.etName);
        EditText Surname = findViewById(R.id.etSurname);
        EditText MiddleName = findViewById(R.id.etMiddleName);
        EditText Floor = findViewById(R.id.etFloor);
        EditText DateOfBirth = findViewById(R.id.etBirthday);
        EditText PlaceOfWork = findViewById(R.id.etPlaceOfWork);
        EditText JobTitle = findViewById(R.id.etJobTitle);
        EditText PhoneNumber = findViewById(R.id.etPhoneNumber);

        if (Name.getText().length()==0|| Surname.getText().length()==0 || Floor.getText().length()==0 || DateOfBirth.getText().length()==0 || PlaceOfWork.getText().length()==0 || JobTitle.getText().length()==0 || PhoneNumber.getText().length()==0)
        {
            Toast.makeText(this,"Required fields are not filled", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "INSERT INTO Sotrudnic (Name, Surname, Middle_name, Floor, Date_of_Birth, Place_of_work, Job_title, Phone_number) VALUES (" + Name.getText() + ", " + Surname.getText() + ", " + MiddleName.getText() + ", " + Floor.getText() + ", " + DateOfBirth.getText() + ", " + PlaceOfWork.getText() + ", " + JobTitle.getText() + ", " + PhoneNumber.getText() + ")";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);

            }
        }

        catch (Exception ex)
        {
            Toast.makeText(this,"An error has occurred", Toast.LENGTH_LONG).show();
        }
        Name.setText("");
        Surname.setText("");
        MiddleName.setText("");
        Floor.setText("");
        DateOfBirth.setText("");
        PhoneNumber.setText("");
        PlaceOfWork.setText("");
        JobTitle.setText("");

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