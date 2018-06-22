package com.whatsappandroid.cursoandroid.whatsapp.activity;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import com.google.firebase.database.DatabaseReference;

import com.whatsappandroid.cursoandroid.whatsapp.R;
import com.whatsappandroid.cursoandroid.whatsapp.config.FirebaseConfig;


public class LoginActivity extends AppCompatActivity {

    private EditText userName;       //User name textfield
    private EditText telephone;     //Cellphone textField
    private EditText cCode;         //Country Code textfield
    private EditText sCode;         //State Code textfield
    private Button btnSignUp;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        reference = FirebaseConfig.getFirebase();
        reference.child("pontos").setValue("800");

    }

    public void openUserSignup(View view){
        Intent intent = new Intent(LoginActivity.this, UserSignupActivity.class);
        startActivity(intent);
    }






}
