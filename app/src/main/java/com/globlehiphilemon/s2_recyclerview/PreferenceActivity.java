package com.globlehiphilemon.s2_recyclerview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {

    private EditText edtNomWifi;
    private EditText edtPassword;
    private Switch etatWifi;
    private TextView txtvNomWifi;
    private TextView txtvPassword;
    private Button btnAjout;
    private Button btnMemoriser;

    public static final String PREFS = "PREFS";
    public static final String TEXT_NOM_WIFI = "NOM_WIFI";
    public static final String TEXT_PASS = "TEXT_PASS";
    public static final String ETAT_SWITCH = "ETAT_SWITCH";

    private String textForWifi;
    private String textForPassword;
    private boolean switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        this.edtNomWifi = findViewById(R.id.edt_nom_wifi);
        this.edtPassword = findViewById(R.id.edt_password);
        this.etatWifi = findViewById(R.id.switch_etat);
        this.txtvNomWifi = findViewById(R.id.txt_v_nom_wifi);
        this.txtvPassword = findViewById(R.id.txt_v_password);
        this.btnAjout = findViewById(R.id.btn_ajout);
        this.btnMemoriser = findViewById(R.id.btn_memoriser);


        this.btnAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtvNomWifi.setText(edtNomWifi.getText().toString());
                txtvPassword.setText(edtPassword.getText().toString());
            }
        });

        this.btnMemoriser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateData();

    }

    public void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        txtvNomWifi.setText(edtNomWifi.getText().toString());
        txtvPassword.setText(edtPassword.getText().toString());

        editor.putString(TEXT_NOM_WIFI, txtvNomWifi.getText().toString());
        editor.putString(TEXT_PASS, txtvPassword.getText().toString());
        editor.putBoolean(ETAT_SWITCH, etatWifi.isChecked());

        editor.apply();

        Toast.makeText(PreferenceActivity.this, "DONNEES MEMORISEES", Toast.LENGTH_LONG).show();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        this.textForWifi = sharedPreferences.getString(TEXT_NOM_WIFI, "default");
        this.textForPassword = sharedPreferences.getString(TEXT_PASS, "default");
        this.switchOnOff = sharedPreferences.getBoolean(ETAT_SWITCH, false);
    }

    public void updateData() {

        this.txtvNomWifi.setText(this.textForWifi);
        this.txtvPassword.setText(this.textForPassword);
        this.etatWifi.setChecked(this.switchOnOff);

    }
}
