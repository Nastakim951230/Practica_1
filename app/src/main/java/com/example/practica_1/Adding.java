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
        TextView Name = findViewById(R.id.etName);
        TextView Surname = findViewById(R.id.etSurname);
        TextView Floor = findViewById(R.id.etFloor);
        TextView JobTitle = findViewById(R.id.etJobTitle);

        if (Name.getText().length()==0|| Surname.getText().length()==0 || Floor.getText().length()==0 ||  JobTitle.getText().length()==0 )
        {
            Toast.makeText(this,"Required fields are not filled", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "INSERT INTO Sotrudnic (Name, Surname, Floor, Job_title) VALUES (" + Name.getText() + ", " + Surname.getText() + ", " + Floor.getText() + ", " + JobTitle.getText() + ")";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);

            }
        }

        catch (Exception ex)
        {
            Toast.makeText(this,"An error has occurred", Toast.LENGTH_LONG).show();
        }
        Name.setText("");
        Surname.setText("");
        Floor.setText("");
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