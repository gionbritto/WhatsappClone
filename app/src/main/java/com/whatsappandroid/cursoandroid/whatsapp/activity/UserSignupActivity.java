package com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.whatsappandroid.cursoandroid.whatsapp.R;
import com.whatsappandroid.cursoandroid.whatsapp.config.FirebaseConfig;
import com.whatsappandroid.cursoandroid.whatsapp.model.User;

public class UserSignupActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtUserEmail;
    private EditText edtUserPass;
    private Button   btnSignup;
    private User user;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        edtUserName  = (EditText) findViewById(R.id.edt_name);
        edtUserEmail = (EditText) findViewById(R.id.edt_email);
        edtUserPass  = (EditText) findViewById(R.id.edt_senha);
        btnSignup    = (Button)  findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = new User();      //instantiate the model class User() to save the information gotten from the signup interface
                user.setName(edtUserName.getText().toString());
                user.setEmail(edtUserEmail.getText().toString());
                user.setPass(edtUserPass.getText().toString());

                registerUser();

            }
        });


    }

    //class that register the user on the firebase
    private void registerUser(){

        firebaseAuth = FirebaseConfig.getFirebaseAuth();
        firebaseAuth.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getPass()
        ).addOnCompleteListener(UserSignupActivity.this, new OnCompleteListener<AuthResult>() {     //method responsable to verify if the user signup was succeed
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    //"task" is our return objetct
                if(task.isSuccessful()){

                    FirebaseUser userFirebase = task.getResult().getUser();
                    Toast.makeText(UserSignupActivity.this, "Success to Signup", Toast.LENGTH_SHORT).show();
                    user.setId(userFirebase.getUid());
                    user.save();   //this save the user in the firebase database

                    firebaseAuth.signOut();     //singing the user out after making the singUp

                    finish();

                } else{

                    String errorExeption = "";      //string to receive the error exception message

                    try{
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) { //Adding the first exception treatment for waek passwords
                        e.printStackTrace();
                        errorExeption = e.getReason();
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        errorExeption = "Type a valid credential. Try again";
                    } catch (FirebaseAuthUserCollisionException e){
                        errorExeption = "This user is already in use in this App";
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(UserSignupActivity.this, "Error: " + errorExeption, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}