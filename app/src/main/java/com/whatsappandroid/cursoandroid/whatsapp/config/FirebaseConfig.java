package com.whatsappandroid.cursoandroid.whatsapp.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/*
With this class, everytime we need to use a instance of the firebase database we'll just need
to call this final class(can't be extended) with the static method 'getFirebase' (we gonna get it
without instantiate this class )
 */
public final class FirebaseConfig {

    private static DatabaseReference firebaseRef;
    private static FirebaseAuth firebaseAuth;

    //method that will get the instance od the firebase when we need
    public static DatabaseReference getFirebase(){

        if( firebaseRef == null){

            firebaseRef = FirebaseDatabase.getInstance().getReference();

        }


        return firebaseRef;
    }

    //returns a objetc that is responsable to make the authentication
    public static FirebaseAuth getFirebaseAuth(){

        //verify if the authentication already exists
        if(firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }

        return firebaseAuth;
    }

}
