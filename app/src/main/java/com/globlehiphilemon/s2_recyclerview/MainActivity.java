package com.globlehiphilemon.s2_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.globlehiphilemon.s2_recyclerview.model.Personne;

public class MainActivity extends AppCompatActivity {

    EditText txtNom;
    EditText txtPrenoms;
    EditText txtCommune;
    Button btnSave;
    Button btnCancel;
    Toolbar toolbar;

    Personne personne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.toolbar = findViewById(R.id.toolbar);
        this.toolbar.setTitle(R.string.title);
        setSupportActionBar(this.toolbar);

        this.txtNom = findViewById(R.id.txt_nom);
        this.txtPrenoms = findViewById(R.id.txt_prenoms);
        this.txtCommune = findViewById(R.id.txt_commune);
        this.btnSave = findViewById(R.id.btn_save);
        this.btnCancel = findViewById(R.id.btn_cancel);

        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personne = new Personne(
                        "0001",
                        txtNom.getText().toString(),
                        txtPrenoms.getText().toString(),
                        txtCommune.getText().toString()
                );

                Toast.makeText(MainActivity.this, personne.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);

            }
        });

        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNom.setText("");
                txtPrenoms.setText("");
                txtCommune.setText("");
            }
        });


    }
}
