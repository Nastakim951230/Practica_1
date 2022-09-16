package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

Connection connection;
String ConnectionResult="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public  void GetTextFromSql(View v)
    {

        TableLayout layout = findViewById(R.id.dbLayout);
        layout.removeAllViews();


        try{

            ConnectionHelper connectionHelper= new ConnectionHelper();
            connection = connectionHelper.connectionClass();

            if (connection!=null)
            {
                String query = "Select * From Sotrudnic";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next())
                {
                    TableRow dbLayoutRow = new TableRow(this);
                    dbLayoutRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT);



                    TextView Name = new TextView(this);
                    params.weight = 1.0f;
                    Name.setLayoutParams(params);
                    Name.setText(resultSet.getString(1));
                    Name.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Name);

                    TextView Surname = new TextView(this);
                    params.weight = 1.0f;
                    Surname.setLayoutParams(params);
                    Surname.setText(resultSet.getString(2));
                    Surname.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Surname);


                    TextView Floor = new TextView(this);
                    params.weight = 1.0f;
                    Floor.setLayoutParams(params);
                    Floor.setText(resultSet.getString(3));
                    Floor.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Floor);



                    TextView JobTitle = new TextView(this);
                    params.weight = 1.0f;
                    JobTitle.setLayoutParams(params);
                    JobTitle.setText(resultSet.getString(4));
                    JobTitle.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(JobTitle);

                    layout.addView(dbLayoutRow);

                }
            }

            else
            {
                ConnectionResult="Проверить соединение";
            }
        }

        catch (Exception ex)
        {
            Log.e("Ошибка", ex.getMessage());
        }


    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btAdd:
                Intent intent=new Intent(this,Adding.class);
                startActivity(intent);
                break;
        }

    }



}