package com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.whatsappandroid.cursoandroid.whatsapp.Helper.Permissions;
import com.whatsappandroid.cursoandroid.whatsapp.Helper.mPreferences;
import com.whatsappandroid.cursoandroid.whatsapp.R;

import java.util.Random;

public class LoginActivityold extends AppCompatActivity {
/*
    private EditText userName;       //User name textfield
    private EditText telephone;     //Cellphone textField
    private EditText cCode;         //Country Code textfield
    private EditText sCode;         //State Code textfield
    private Button   btnSignUp;
    private String[] necessaryPermissions = new String[]{
            Manifest.permission.SEND_SMS,
            Manifest.permission.INTERNET
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permissions.validPermissions(1, this, necessaryPermissions);

        telephone   = (EditText) findViewById(R.id.edt_cell_number);
        cCode       = (EditText) findViewById(R.id.edt_country_code);
        sCode       = (EditText) findViewById(R.id.edt_state_code);
        userName    = (EditText) findViewById(R.id.edt_name);
        btnSignUp   = (Button) findViewById(R.id.btn_signup);

        //Creating the class that will shape the field format
        SimpleMaskFormatter sMaskTellNumber    = new SimpleMaskFormatter("NNNNN-NNNN");
        SimpleMaskFormatter sMaskCountryCode   = new SimpleMaskFormatter("+NN");
        SimpleMaskFormatter sMaskStateCode     = new SimpleMaskFormatter("NN");

        //mask that will watch the mask to put it on the edt
        MaskTextWatcher maskTell    = new MaskTextWatcher(telephone, sMaskTellNumber); //this receive as param the textField and the mask i've created
        MaskTextWatcher maskCCode   = new MaskTextWatcher(cCode, sMaskCountryCode);
        MaskTextWatcher maskSCode   = new MaskTextWatcher(sCode, sMaskStateCode);

        //use the method addTextChangedListener to add the final format to the edt
        telephone.addTextChangedListener(maskTell);
        cCode.addTextChangedListener(maskCCode);
        sCode.addTextChangedListener(maskSCode);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = userName.getText().toString();
                String compCellphone =
                        cCode.getText().toString()   +
                        sCode.getText().toString()   +
                        telephone.getText().toString();
                String cellWdOutFormat = compCellphone.replace("+", "");
                cellWdOutFormat        = cellWdOutFormat.replace("-", "");



                //Generate the validation token
                Random random = new Random();
                int randonNumber = random.nextInt( 9999 - 1000 ) + 1000;

                //final token
                String token = String.valueOf( randonNumber );
                String smsMessage = "Your Whatsapp Confirmation code is: " + token;

                //Save data to later validations
                mPreferences preferences = new mPreferences(getApplicationContext());
                preferences.saveUserPreferences(nomeUsuario, cellWdOutFormat, token);


                //SMS Sent
                boolean smsSent = sendSMS("+" + cellWdOutFormat, smsMessage);

                if(smsSent){

                    Intent intent = new Intent(LoginActivityold.this, ValidatorActivity.class);
                    startActivity(intent);
                    finish();       //destroy the activity

                } else{

                    Toast.makeText(LoginActivityold.this, "Error in sms sent... Try again!", Toast.LENGTH_LONG).show();
                }

                /*
                HashMap<String, String> user = preferences.getUserData();

                Log.i("TOKEN", "T: " + user.get("token"));
                //startActivity(new Intent(LoginActivity.this, ValidatorActivity.class));

                */
            }
        /*});

    }
/*
    //Sent SMS
    private boolean sendSMS(String cellphone, String mesage){

        try{

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(cellphone, null, mesage, null, null);

            return  true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
*/ /*
    //With this class we can check which permissions were denied
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //running throught the results
        for(int result: grantResults){

            if(result == PackageManager.PERMISSION_DENIED){
                validationAlertPermission();
            }

        }

    }


    //Pop a message alerting about the permissions requests
    private void validationAlertPermission(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissoes negadas");         //alterar para uma string xml
        builder.setMessage("Para utilizar o app e necessario aceitar as permissoes");

        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
*/