package com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.whatsappandroid.cursoandroid.whatsapp.R;
import com.whatsappandroid.cursoandroid.whatsapp.config.FirebaseConfig;

public class MainActivity extends AppCompatActivity {

    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference reference = database.getReference();

    private Button btnLogout;
    private FirebaseAuth auth;
    private Toolbar mToolbar; //Instantiate the toolbar type v7


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tootlbarconfigs
         mToolbar = (Toolbar) findViewById(R.id.toolbar_principal);
         mToolbar.setTitle("WhatsApp");
         setSupportActionBar(mToolbar); //methods of support to a actionbar(must use), if we don't use this, onCreateOptionsMenu doesn't is called

    }

    //override the optionMenu method
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater = getMenuInflater(); //create a objetct of the type inflate. It is used for us to inflate menus
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

}
