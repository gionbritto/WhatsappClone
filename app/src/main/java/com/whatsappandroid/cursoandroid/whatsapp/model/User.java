package com.whatsappandroid.cursoandroid.whatsapp.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.whatsappandroid.cursoandroid.whatsapp.config.FirebaseConfig;

public class User {

    private String id;
    private String name;
    private String email;
    private String pass;

    public User(){

    }

    public void save(){
        //get the reference of the database
        DatabaseReference databaseReference = FirebaseConfig.getFirebase();
        databaseReference.child("user").child(getId()).setValue(this);
    }

    //With this annotation Firebase doesn't include the Id in the inclusion
    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
