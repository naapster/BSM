package com.example.bsm11;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        buttonChange = findViewById(R.id.buttonChange);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    if (MainActivity.validatePassword(editOld.getText().toString(), MainActivity.loadData()) && editNew.getText().toString().equals(editNew1.getText().toString())) {
                        String note = MainActivity.loadDataNotes();
                        String interSaltHash = MainActivity.generateStorngPasswordHash(editNew1.getText().toString());
                        MainActivity.saveData(interSaltHash);
                        MainActivity.saveDataNote(note);
                        Toast.makeText(AfterLoginActivity.this, "You changed your note", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AfterLoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(AfterLoginActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }


            }

        });




    }
}
