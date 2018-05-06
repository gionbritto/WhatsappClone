package com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.whatsappandroid.cursoandroid.whatsapp.Helper.mPreferences;
import com.whatsappandroid.cursoandroid.whatsapp.R;

import java.util.HashMap;

public class ValidatorActivity extends AppCompatActivity {

    private EditText edtValidator;
    private Button btnValidator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        edtValidator = (EditText) findViewById(R.id.edt_valid_code);
        btnValidator = (Button) findViewById(R.id.btn_valid_code);

        SimpleMaskFormatter sValidatorMask = new SimpleMaskFormatter("N-N-N-N");

        MaskTextWatcher maskValidator = new MaskTextWatcher(edtValidator, sValidatorMask);

        edtValidator.addTextChangedListener(maskValidator);

        btnValidator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the code without the '-';
                String code = edtValidator.getText().toString();
                String codeWdOutFormat = code.replace("-", "");

                mPreferences prefs = new mPreferences(ValidatorActivity.this);
                HashMap<String, String> user = prefs.getUserData();

                //This string recieves the token genereted
                String generatedCode = user.get("token");

                if(codeWdOutFormat.equals(generatedCode)){

                    Toast.makeText(ValidatorActivity.this, "Token Ok!", Toast.LENGTH_SHORT).show();

                } else{

                    Toast.makeText(ValidatorActivity.this, "Wrong token, try again!!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
