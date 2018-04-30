package com.whatsappandroid.cursoandroid.whatsapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.whatsappandroid.cursoandroid.whatsapp.R;

public class ValidatorActivity extends AppCompatActivity {

    EditText edtValidator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validador);

        edtValidator = (EditText) findViewById(R.id.edt_valid_code);

        SimpleMaskFormatter sValidatorMask = new SimpleMaskFormatter("N-N-N-N");

        MaskTextWatcher maskValidator = new MaskTextWatcher(edtValidator, sValidatorMask);

        edtValidator.addTextChangedListener(maskValidator);
    }
}
