package com.example.fastfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fastfood.usermodel.usermodels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    FirebaseAuth auth;
    Button Signup;
    EditText name,email,password;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        auth = FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();
        Signup = findViewById(R.id.button);
        name=findViewById(R.id.editText);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createuser();
            }
        });

    }

    private void createuser() {
        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String userpassword = password.getText().toString();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "Please enter the name", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(useremail)){
            Toast.makeText(this, "Please enter the email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(userpassword)){
            Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show();
        }
        if(userpassword.length()<8){
            Toast.makeText(this, "Password should have min 8 characters", Toast.LENGTH_SHORT).show();
        }
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        //creating user
        auth.createUserWithEmailAndPassword(useremail,userpassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            usermodels usermodels = new usermodels(username,useremail,userpassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Admin").child(id).setValue(usermodels);

                            Toast.makeText(Registration.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Registration.this, "Please try again"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }


    public void signin(View view) {
        startActivity(new Intent(Registration.this,Login.class));
    }

    public void main_activity(View view) {
        startActivity(new Intent(Registration.this,MainActivity.class));
    }
}