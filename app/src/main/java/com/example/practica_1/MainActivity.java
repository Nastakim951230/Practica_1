package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
        GetTextFromSql();
    }

    public  void GetTextFromSql()
    {

        TableLayout layout = findViewById(R.id.dbLayoutRow);
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


                    TextView ID = new TextView(this);
                    params.weight = 1.0f;
                    ID.setLayoutParams(params);
                    ID.setText(resultSet.getString(1));
                    ID.setTextSize(12);
                    ID.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(ID);

                    TextView Name = new TextView(this);
                    params.weight = 1.0f;
                    Name.setLayoutParams(params);
                    Name.setText(resultSet.getString(2));
                    Name.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Name);

                    TextView Surname = new TextView(this);
                    params.weight = 1.0f;
                    Surname.setLayoutParams(params);
                    Surname.setText(resultSet.getString(3));
                    Surname.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Surname);


                    TextView Floor = new TextView(this);
                    params.weight = 1.0f;
                    Floor.setLayoutParams(params);
                    Floor.setText(resultSet.getString(4));
                    Floor.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbLayoutRow.addView(Floor);

                    TextView JobTitle = new TextView(this);
                    params.weight = 1.0f;
                    JobTitle.setLayoutParams(params);
                    JobTitle.setText(resultSet.getString(5));
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

    public void onClickAdd(View v) {
        switch (v.getId()) {
            case R.id.btAdd:
                Intent intent=new Intent(this,Adding.class);
                startActivity(intent);
                break;
        }

    }
    public void onClickUpdate(View v) {
        switch (v.getId()) {
            case R.id.btUpdate2:
                Intent intent=new Intent(this,UPDATE.class);
                startActivity(intent);
                break;
        }

    }

    public void onClickDelet(View v) {
        switch (v.getId()) {
            case R.id.btClic:
                Intent intent=new Intent(this,Delet.class);
                startActivity(intent);
                break;
        }

    }

}