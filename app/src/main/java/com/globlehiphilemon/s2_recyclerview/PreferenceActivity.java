package com.globlehiphilemon.s2_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Switch;

public class PreferenceActivity extends AppCompatActivity {

    private EditText txtNomWifi;
    private EditText txtPassword;
    private Switch switchEtat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        this.txtNomWifi = findViewById(R.id.txt_nom_wifi);
        this.txtPassword = findViewById(R.id.txt_password);
        this.switchEtat = findViewById(R.id.switch_etat);
    }
}
