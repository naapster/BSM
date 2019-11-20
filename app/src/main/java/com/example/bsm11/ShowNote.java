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

public class ShowNote extends AppCompatActivity {


    EditText editNew;
    TextView textNote;
    Button  buttonchange2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_note);

        editNew = findViewById(R.id.editNotes);
        textNote = findViewById(R.id.textNotes);
        buttonchange2 = findViewById(R.id.buttonAdd1);

        textNote.setText(MainActivity.loadDataNotes());
        buttonchange2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                MainActivity.saveDataNote(editNew.getText().toString());
                Toast.makeText(ShowNote.this, "You changed your note", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowNote.this, AfterLogin0.class);
                startActivity(intent);
            }
        });
    }
}
