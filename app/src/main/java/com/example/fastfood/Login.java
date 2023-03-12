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
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastfood.usermodel.usermodels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    FirebaseAuth auth;
    Button SignIn;
    EditText name,email,password;
    TextView SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        SignIn = findViewById(R.id.button);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
        SignUp =findViewById(R.id.textView5);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();

            }
        });


    }


    private void loginuser() {

        String useremail = email.getText().toString();
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        String userpassword = password.getText().toString();

        if(TextUtils.isEmpty(useremail)){
            Toast.makeText(this, "Please enter the email", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(userpassword)){

            Toast.makeText(this, "Please enter the password", Toast.LENGTH_SHORT).show();
        }
        if(userpassword.length()<8){

            Toast.makeText(this, "Password should have min 8 characters", Toast.LENGTH_SHORT).show();
        }


        //creating user
        auth.signInWithEmailAndPassword(useremail,userpassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(Login.this,MainActivity.class));
                            Toast.makeText(Login.this, "Sign In successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Login.this, "Please try again"+task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void signup(View view) {
        startActivity(new Intent(Login.this,Registration.class));
    }




}