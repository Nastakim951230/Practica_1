package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
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
                    ID.setTextColor(Color.BLUE);
                    ID.setPadding(5, 5, 5, 5);
                    ID.setTextSize(14);
                    ID.setGravity(Gravity.LEFT);
                    dbLayoutRow.addView(ID);

                    TextView Name = new TextView(this);
                    params.weight = 3.0f;
                    Name.setLayoutParams(params);
                    Name.setText(resultSet.getString(2));
                    Name.setTextColor(Color.BLUE);
                    Name.setPadding(5, 5, 5, 5);
                    Name.setTextSize(14);
                    Name.setGravity(Gravity.LEFT);
                    dbLayoutRow.addView(Name);

                    TextView Surname = new TextView(this);
                    params.weight = 3.0f;
                    Surname.setLayoutParams(params);
                    Surname.setText(resultSet.getString(3));
                    Surname.setTextColor(Color.BLUE);
                    Surname.setPadding(5, 5, 5, 5);
                    Surname.setTextSize(14);
                    Surname.setGravity(Gravity.LEFT);
                    dbLayoutRow.addView(Surname);


                    TextView Floor = new TextView(this);
                    params.weight = 3.0f;
                    Floor.setLayoutParams(params);
                    Floor.setText(resultSet.getString(4));
                    Floor.setTextColor(Color.BLUE);
                    Floor.setPadding(5, 5, 5, 5);
                    Floor.setTextSize(14);
                    Floor.setGravity(Gravity.LEFT);
                    dbLayoutRow.addView(Floor);

                    TextView JobTitle = new TextView(this);
                    params.weight = 3.0f;
                    JobTitle.setLayoutParams(params);
                    JobTitle.setText(resultSet.getString(5));
                    JobTitle.setTextColor(Color.BLUE);
                    JobTitle.setPadding(5, 5, 5, 5);
                    JobTitle.setTextSize(14);
                    JobTitle.setGravity(Gravity.LEFT);
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
    public void onClickPoisk(View v)
    {

                TableLayout layoutPoisk = findViewById(R.id.dbLayoutRow);
                layoutPoisk.removeAllViews();

                TextView Poisk = findViewById(R.id.txtPoisk);
                if (Poisk.getText().length() == 0) {
                    Toast.makeText(this, "Не заполнены обязательные поля", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connection = connectionHelper.connectionClass();
                    if (connection != null) {
                        String queryPoisk = "SELECT * FROM  Sotrudnic where Surname like'%" + Poisk.getText() + "%' ";
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(queryPoisk);
                        while (result.next())
                        {
                            TableRow dbLayoutRow = new TableRow(this);
                            dbLayoutRow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));
                            TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT);


                            TextView ID = new TextView(this);
                            params.weight = 1.0f;
                            ID.setLayoutParams(params);
                            ID.setText(result.getString(1));
                            ID.setTextColor(Color.BLUE);
                            ID.setPadding(5, 5, 5, 5);
                            ID.setTextSize(14);
                            ID.setGravity(Gravity.LEFT);
                            dbLayoutRow.addView(ID);

                            TextView Name = new TextView(this);
                            params.weight = 3.0f;
                            Name.setLayoutParams(params);
                            Name.setText(result.getString(2));
                            Name.setTextColor(Color.BLUE);
                            Name.setPadding(5, 5, 5, 5);
                            Name.setTextSize(14);
                            Name.setGravity(Gravity.LEFT);
                            dbLayoutRow.addView(Name);

                            TextView Surname = new TextView(this);
                            params.weight = 3.0f;
                            Surname.setLayoutParams(params);
                            Surname.setText(result.getString(3));
                            Surname.setTextColor(Color.BLUE);
                            Surname.setPadding(5, 5, 5, 5);
                            Surname.setTextSize(14);
                            Surname.setGravity(Gravity.LEFT);
                            dbLayoutRow.addView(Surname);

                            TextView Floor = new TextView(this);
                            params.weight = 3.0f;
                            Floor.setLayoutParams(params);
                            Floor.setText(result.getString(4));
                            Floor.setTextColor(Color.BLUE);
                            Floor.setPadding(5, 5, 5, 5);
                            Floor.setTextSize(14);
                            Floor.setGravity(Gravity.LEFT);
                            dbLayoutRow.addView(Floor);

                            TextView JobTitle = new TextView(this);
                            params.weight = 3.0f;
                            JobTitle.setLayoutParams(params);
                            JobTitle.setText(result.getString(5));
                            JobTitle.setTextColor(Color.BLUE);
                            JobTitle.setPadding(5, 5, 5, 5);
                            JobTitle.setTextSize(14);
                            JobTitle.setGravity(Gravity.LEFT);
                            dbLayoutRow.addView(JobTitle);

                            layoutPoisk.addView(dbLayoutRow);

                        }
                    }
                } catch (Exception ex) {
                    Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_LONG).show();
                }
    }

    public void OnClickCleaning(View v)
    {
        TextView Poisk = findViewById(R.id.txtPoisk);
        GetTextFromSql();
        Poisk.setText("");
    }


}