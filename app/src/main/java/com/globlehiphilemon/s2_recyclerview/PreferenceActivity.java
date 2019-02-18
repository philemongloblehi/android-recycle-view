package com.globlehiphilemon.s2_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class PreferenceActivity extends AppCompatActivity {

    private EditText txtNomWifi;
    private EditText txtPassword;
    private Switch switchEtat;
    private CheckBox showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        this.txtNomWifi = findViewById(R.id.txt_nom_wifi);
        this.txtPassword = findViewById(R.id.txt_password);
        this.switchEtat = findViewById(R.id.switch_etat);
        this.showPassword = findViewById(R.id.show_password);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {
                    // show password
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
}
