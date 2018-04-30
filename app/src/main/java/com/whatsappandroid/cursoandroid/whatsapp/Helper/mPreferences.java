package com.whatsappandroid.cursoandroid.whatsapp.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by giovanne on 28/04/18.
 */

public class mPreferences {

    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "whatsappPreferences";
    private int MODE = 0; //PRIVATE MODE
    private SharedPreferences.Editor editor;

    private String NAME_KEY = "nome";
    private String CELL_KEY = "cellphone";
    private String TOKEN_KEY= "token";


    //Constructor used to receive the aplication context
    public mPreferences(Context contextParam){

        //context receive the param
        context = contextParam;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();

    }

    //Saving the received data in the preference
    public void saveUserPreferences(String userName, String userCell, String token){

            editor.putString(NAME_KEY, userName);
            editor.putString(CELL_KEY, userCell);
            editor.putString(TOKEN_KEY, token);
            editor.commit();
    }

    //Crate a list with index and value
    public HashMap<String, String> getUserData(){

        HashMap<String, String> userData = new HashMap<>();

        //inserting in the hashmap the values that was gotten from preferences object
        userData.put(NAME_KEY, preferences.getString(NAME_KEY, null));
        userData.put(CELL_KEY, preferences.getString(CELL_KEY, null));
        userData.put(TOKEN_KEY, preferences.getString(TOKEN_KEY, null));

        return userData;
    }
}
