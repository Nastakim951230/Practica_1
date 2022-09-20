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
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UPDATE extends AppCompatActivity {

    Connection connection;
    String ConnectionResult="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        FromSql();
    }

    public  void FromSql()
    {

        TableLayout layout = findViewById(R.id.dbUpdate);
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
                    TableRow dbUpdate = new TableRow(this);
                    dbUpdate.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT);


                    TextView ID = new TextView(this);
                    params.weight = 1.0f;
                    ID.setLayoutParams(params);
                    ID.setText(resultSet.getString(1));
                    ID.setTextSize(12);
                    ID.setGravity(Gravity.CENTER);
                    dbUpdate.addView(ID);

                    TextView Name = new TextView(this);
                    params.weight = 1.0f;
                    Name.setLayoutParams(params);
                    Name.setText(resultSet.getString(2));
                    Name.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbUpdate.addView(Name);

                    TextView Surname = new TextView(this);
                    params.weight = 1.0f;
                    Surname.setLayoutParams(params);
                    Surname.setText(resultSet.getString(3));
                    Surname.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbUpdate.addView(Surname);


                    TextView Floor = new TextView(this);
                    params.weight = 1.0f;
                    Floor.setLayoutParams(params);
                    Floor.setText(resultSet.getString(4));
                    Floor.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbUpdate.addView(Floor);



                    TextView JobTitle = new TextView(this);
                    params.weight = 1.0f;
                    JobTitle.setLayoutParams(params);
                    JobTitle.setText(resultSet.getString(5));
                    JobTitle.setTextSize(12);
                    Name.setGravity(Gravity.CENTER);
                    dbUpdate.addView(JobTitle);

                    layout.addView(dbUpdate);

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

    public void Update (View v)
    {
        TextView ID = findViewById(R.id.UPID);
        TextView Name = findViewById(R.id.UPName);
        TextView Surname = findViewById(R.id.UPSurname);
        TextView Floor = findViewById(R.id.UPFloor);
        TextView JobTitle = findViewById(R.id.UPJobTitle);

        if (ID.getText().length()==0||Name.getText().length()==0|| Surname.getText().length()==0 || Floor.getText().length()==0 ||  JobTitle.getText().length()==0 )
        {
            Toast.makeText(this,"Не заполнены обязательные поля", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if (connection != null) {
                String query = "UPDATE Sotrudnic Set Name = '" + Name.getText() + "', Surname = '" + Surname.getText() + "', Floor ='" + Floor.getText() + "', Job_title ='" + JobTitle.getText() + "' WHERE ID= "+ID.getText()+"";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                Toast.makeText(this,"Успешно изменено", Toast.LENGTH_LONG).show();

            }
        }

        catch (Exception ex)
        {
            Toast.makeText(this,"Произошла ошибка", Toast.LENGTH_LONG).show();
        }
        FromSql();
        ID.setText("");
        Name.setText("");
        Surname.setText("");
        Floor.setText("");
        JobTitle.setText("");

    }

    public void onClickPereho(View v) {
        switch (v.getId()) {
            case R.id.BTNazad:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}