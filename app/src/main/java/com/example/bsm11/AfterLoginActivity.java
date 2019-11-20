package com.example.bsm11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AfterLoginActivity extends AppCompatActivity {


    TextView textView1;
    EditText editOld;
    EditText editNew;
    EditText editNew1;
    Button buttonChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editOld = findViewById(R.id.editOld);
        editNew = findViewById(R.id.editNew);
        editNew1 = findViewById(R.id.editNew1);
        textView1 = findViewById(R.id.textView);
        buttonChange = findViewById(R.id.buttonChange);
        buttonChange.setEnabled(false);

        try {
            if (MainActivity.validatePassword(editOld.getText().toString(), MainActivity.loadData()) && editNew.getText().toString().equals(editNew1.getText().toString())){
                buttonChange.setEnabled(true);



            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }


    }
}
