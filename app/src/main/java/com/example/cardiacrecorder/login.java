package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    TextInputLayout usernam,passwrd;
    Button signin;
    DatabaseReference reference= FirebaseDatabase.getInstance().getReferenceFromUrl( "https://cardiac-recorder-38f44-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         usernam =findViewById(R.id.username);
         passwrd=findViewById(R.id.password);
     signin =findViewById(R.id.Signin);
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

//                       Button button = findViewById(R.id.Signin);
//                       button.setOnClickListener(new View.OnClickListener() {
//                           @Override
//                           public void onClick(View v) {
//                               Intent intent = new Intent(login.this,newmeasurement.class);
//                           }
//                       });
                startActivity(new Intent(login.this,newmeasurement.class));
                finish();
                        }
                    else{
                    Toast.makeText(login.this,"wrong password",Toast.LENGTH_SHORT).show();}
                    }
                    else{
                        Toast.makeText(login.this,"wrong username",Toast.LENGTH_SHORT).show();}

                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    });
}}