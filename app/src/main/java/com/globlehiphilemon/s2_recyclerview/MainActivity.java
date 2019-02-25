package com.globlehiphilemon.s2_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.globlehiphilemon.s2_recyclerview.common.CommonPersonne;
import com.globlehiphilemon.s2_recyclerview.model.Personne;
import com.globlehiphilemon.s2_recyclerview.sqlite.SqliteActivity;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNom;
    EditText txtPrenoms;
    EditText txtCommune;
    Button btnSave;
    Toolbar toolbar;


    private List<Personne> personnes = CommonPersonne.getList();

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

        this.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personne = new Personne(
                        "0001",
                        txtNom.getText().toString(),
                        txtPrenoms.getText().toString(),
                        txtCommune.getText().toString()
                );

                personnes.add(personne);

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra(CommonPersonne.EXTRA_LISTE_PERS, (Serializable) personnes);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_list:
                Intent intent1 = new Intent(this, RecyclerActivity.class);
                startActivity(intent1);
                break;
            case R.id.item_intents:
                Intent intent2 = new Intent(this, IntentActivity.class);
                startActivity(intent2);
                break;
            case R.id.item_preferences:
                Intent intent3 = new Intent(this, PreferenceActivity.class);
                startActivity(intent3);
                break;
            case R.id.item_sqlite:
                Intent intent4 = new Intent(this, SqliteActivity.class);
                startActivity(intent4);
                break;
            case R.id.item_search:
                Toast.makeText(this, "Pas de recherche pour le moment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_quitter:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
