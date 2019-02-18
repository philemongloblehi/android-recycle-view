package com.globlehiphilemon.s2_recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    private Button btnAppeler, btnLancer, btnGeolocaliser;
    private EditText txtAppeler, txtLancer, txtGeolocaliser;

    private Toolbar toolbar;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        this.toolbar = findViewById(R.id.toolbar);
        this.toolbar.setTitle("Intents demo");
        setSupportActionBar(this.toolbar);

        this.btnAppeler = findViewById(R.id.btn_contact);
        this.btnLancer = findViewById(R.id.btn_lien);
        this.btnGeolocaliser = findViewById(R.id.btn_geolocaliser);

        this.txtAppeler = findViewById(R.id.txt_contact);
        this.txtLancer = findViewById(R.id.txt_lien);
        this.txtGeolocaliser = findViewById(R.id.txt_geolocaliser);

        this.btnAppeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!"".equals(txtAppeler.getText().toString())) {

                    Uri uriTel = Uri.parse("tel:" + txtAppeler.getText().toString());
                    intent = new Intent(Intent.ACTION_DIAL, uriTel);
                    startActivity(intent);
                } else {
                    Toast.makeText(IntentActivity.this, "Veuillez saisir le numéro svp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.btnLancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!"".equals(txtLancer.getText().toString())) {

                    Uri uriWeb = Uri.parse("http://" + txtLancer.getText().toString());
                    intent = new Intent(Intent.ACTION_VIEW, uriWeb);
                    startActivity(intent);
                } else {
                    Toast.makeText(IntentActivity.this, "Veuillez saisir l'url svp", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.btnGeolocaliser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!"".equals(txtGeolocaliser.getText().toString())) {

                    Uri localisation = Uri.parse(txtGeolocaliser.getText().toString());
                    intent = new Intent(Intent.ACTION_VIEW, localisation);
                    startActivity(intent);
                } else {
                    Toast.makeText(IntentActivity.this, "Veuillez saisir l'adresse de geolocalisation svp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
