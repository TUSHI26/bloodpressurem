package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class reigistration extends AppCompatActivity {
    DatabaseReference reference= FirebaseDatabase.getInstance().getReferenceFromUrl( "https://cardiac-recorder-38f44-default-rtdb.firebaseio.com/");
    TextInputLayout firstName,lastname,email,password;
     FirebaseDatabase rootNode;

     Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reigistration);
    regis =findViewById(R.id.reg_btn);
    firstName =findViewById(R.id.freg_name);
        lastname =findViewById(R.id.lreg_username);
        email=findViewById(R.id.reg_email);
        password=findViewById(R.id.reg_password);

    regis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // rootNode = FirebaseDatabase.getInstance();
            //reference =rootNode.getReference("blpressure");
            reference.child("blpressure").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String name = firstName.getEditText().getText().toString();
                    String lname = lastname.getEditText().getText().toString();
                    String mail = email.getEditText().getText().toString();

                    String pssword = password.getEditText().getText().toString();
                   // UserHelper helperClass = new UserHelper(name, lname, mail, pssword);
                    reference.child("blpressure").child(name).child("name").setValue(name);
                    reference.child("blpressure").child(name).child("lastname").setValue(lname);
                    reference.child("blpressure").child(name).child("email").setValue(mail);
                    reference.child("blpressure").child(name).child("password").setValue(pssword);

                    finish();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    });
    }


}