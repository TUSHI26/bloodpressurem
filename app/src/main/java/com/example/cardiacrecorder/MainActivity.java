package com.example.cardiacrecorder;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextInputLayout usernam,passwrd;
    Button signin,signup;
    DatabaseReference reference= FirebaseDatabase.getInstance().getReferenceFromUrl( "https://cardiac-recorder-38f44-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernam =findViewById(R.id.username);
        passwrd=findViewById(R.id.password);
        signin =findViewById(R.id.Signin);
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,reigistration.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =usernam.getEditText().getText().toString();
                String password =passwrd.getEditText().getText().toString();

                reference.child("blpressure").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(username)){
                            //if username exist in database
                            String getpasword =snapshot.child(username).child("password").getValue(String.class);
                            if (getpasword.equals(password)){
//                                Toast.makeText(MainActivity.this,"Successfully loggged in", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(MainActivity.this,login.class));
                                finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this,"wrong password",Toast.LENGTH_SHORT).show();}
                        }
                        else{
                            Toast.makeText(MainActivity.this,"wrong username",Toast.LENGTH_SHORT).show();}

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
}