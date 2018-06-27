package com.whatsappandroid.cursoandroid.whatsapp.activity;


import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DatabaseReference;

import com.whatsappandroid.cursoandroid.whatsapp.R;
import com.whatsappandroid.cursoandroid.whatsapp.config.FirebaseConfig;
import com.whatsappandroid.cursoandroid.whatsapp.model.User;


public class LoginActivity extends AppCompatActivity {

    private EditText edtUserEmail;          //User mail textfield
    private EditText edtUserPass;           //User password textField
    private Button btnSignUp;
    private User user;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserEmail = (EditText) findViewById(R.id.edt_email_login);
        edtUserPass = (EditText) findViewById(R.id.edt_pass_login);
        btnSignUp = (Button) findViewById(R.id.btn_signin_login);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = new User();
                user.setEmail( edtUserEmail.getText().toString());
                user.setPass( edtUserPass.getText().toString());

                validateLogin();
                Log.i("DADOS: ", user.getPass());

            }
        });

    }

    public void openUserSignup(View view){
        Intent intent = new Intent(LoginActivity.this, UserSignupActivity.class);
        startActivity(intent);
    }

    public void validateLogin(){

        firebaseAuth = FirebaseConfig.getFirebaseAuth();


        firebaseAuth.signInWithEmailAndPassword(
                user.getEmail(),
                user.getPass()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    openPrincipalActivity();

                } else{

                    String loginMessage = "";

                    try {
                        throw task.getException(); //throws the exception in the task
                    }  catch (Exception e) {
                        e.printStackTrace();
                        loginMessage = "Login Error!";
                        Log.i("ERRO: ", e.toString());
                        Toast.makeText(LoginActivity.this, loginMessage, Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    private void openPrincipalActivity(){

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }




}
