package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        TextView id=findViewById(R.id.txtID);
        TextView Name=findViewById(R.id.txtName);
        TextView Surname=findViewById(R.id.txtSurname);
        TextView MiddleName=findViewById(R.id.txtMiddleName);
        TextView Floor=findViewById(R.id.txtFloor);
        TextView DateOfBirth=findViewById(R.id.txtDB);
        TextView PlaceOfWork=findViewById(R.id.txtPlaceOfWork);
        TextView JobTitle=findViewById(R.id.txtJobTitle);
        TextView PhoneNumber=findViewById(R.id.txtTelefon);

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
                    id.setText(resultSet.getString(1));
                    Name.setText(resultSet.getString(2));
                    Surname.setText(resultSet.getString(3));
                    MiddleName.setText(resultSet.getString(4));
                    Floor.setText(resultSet.getString(5));
                    DateOfBirth.setText(resultSet.getString(6));
                    PlaceOfWork.setText(resultSet.getString(7));
                    JobTitle.setText(resultSet.getString(8));
                    PhoneNumber.setText(resultSet.getString(9));

                }

            }

            else
            {
                ConnectionResult="Checl Connection";
            }
        }

        catch (Exception ex)
        {

        }


    }

}