package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class New_measurement extends AppCompatActivity {
    ListView cityList;
    EditText newsys,newdias;
    LinearLayout nameField;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    TextView sys,dias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_measurement);
        nameField = findViewById(R.id.field_nameEntry);
         newsys  = findViewById(R.id.editText_name);
         newdias = findViewById(R.id.editText1_name);
sys =findViewById(R.id.systolic);
        dias =findViewById(R.id.diastolic);
        cityList = findViewById(R.id.city_list);
        dataList = new ArrayList<>();
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        final Button bloodpressure = findViewById(R.id.sys);
        bloodpressure .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nameField.setVisibility(View.VISIBLE);
            }

        });

        final Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cityName = newsys.getText().toString() + "(SYSTOLIC)";
                String cityName2 = newdias.getText().toString()+ "(DIASTOLIC)";


                cityAdapter.add(cityName);

                cityAdapter.add(cityName2);
                newsys.getText().clear();
                newdias.getText().clear();
                nameField.setVisibility(View.INVISIBLE);
            }
        });




        }

}




