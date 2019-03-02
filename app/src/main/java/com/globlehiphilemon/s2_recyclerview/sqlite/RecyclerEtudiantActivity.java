package com.globlehiphilemon.s2_recyclerview.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.globlehiphilemon.s2_recyclerview.R;
import com.globlehiphilemon.s2_recyclerview.sqlite.adapter.MyAdapterEtudiant;
import com.globlehiphilemon.s2_recyclerview.sqlite.common.CommonEtudiant;
import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

import java.util.ArrayList;

public class RecyclerEtudiantActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Etudiant> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_etudiant);

        this.toolbar = findViewById(R.id.toolbar);
        this.toolbar.setTitle("Liste Etudiants");
        setSupportActionBar(this.toolbar);

        this.recyclerView = findViewById(R.id.my_recycler_etudiant);

        Intent intent = getIntent();
        this.etudiants = (ArrayList<Etudiant>) intent.getSerializableExtra(CommonEtudiant.EXTRA_LISTE_ETUDIANTS);

        if (etudiants == null) {

            this.etudiants = CommonEtudiant.getList();
        }

        this.recyclerView.setAdapter(new MyAdapterEtudiant(this, this.etudiants));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
