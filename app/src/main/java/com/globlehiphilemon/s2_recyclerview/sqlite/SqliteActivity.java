package com.globlehiphilemon.s2_recyclerview.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.globlehiphilemon.s2_recyclerview.R;
import com.globlehiphilemon.s2_recyclerview.sqlite.etudiantdao.EtudiantDao;
import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

public class SqliteActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText txtNom;
    private EditText txtPrenoms;
    private EditText txtCommune;
    private EditText txtFiliere;
    private Button btnAjouter;

    private Etudiant etudiant;
    private EtudiantDao etudiantDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        etudiant = new Etudiant();
        etudiantDao = new EtudiantDao(getApplicationContext());

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("AJOUT DANS SQLITE");
        setSupportActionBar(toolbar);

        txtNom = findViewById(R.id.txt_nom_eleve);
        txtPrenoms = findViewById(R.id.txt_prenoms_eleve);
        txtCommune = findViewById(R.id.txt_commune_eleve);
        txtFiliere = findViewById(R.id.txt_filiere_eleve);

        btnAjouter = findViewById(R.id.btn_ajouter_eleve);

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etudiant.setNom(txtNom.getText().toString());
                etudiant.setPrenoms(txtPrenoms.getText().toString());
                etudiant.setCommune(txtCommune.getText().toString());
                etudiant.setFiliere(txtFiliere.getText().toString());

                long reponse = etudiantDao.ajouter(etudiant);

                if (reponse > 0) {

                    Toast.makeText(SqliteActivity.this, "Elève ajouté avec succès", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(SqliteActivity.this, "Erreur d'ajout", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
