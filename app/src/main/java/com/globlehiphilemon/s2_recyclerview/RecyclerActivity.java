package com.globlehiphilemon.s2_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.globlehiphilemon.s2_recyclerview.adapter.MyAdapter;
import com.globlehiphilemon.s2_recyclerview.common.CommonPersonne;
import com.globlehiphilemon.s2_recyclerview.model.Personne;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Personne> personnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        this.toolbar = findViewById(R.id.toolbar);
        this.toolbar.setTitle("Liste Personnes");
        setSupportActionBar(this.toolbar);

        this.recyclerView = findViewById(R.id.my_recycler);

        Intent intent = getIntent();
        this.personnes = (ArrayList<Personne>) intent.getSerializableExtra(CommonPersonne.EXTRA_LISTE_PERS);

        if (personnes == null) {

            this.personnes = CommonPersonne.getList();
        }

//        Toast.makeText(this, personnes.toString(), Toast.LENGTH_LONG).show();

        this.recyclerView.setAdapter(new MyAdapter(this, this.personnes));
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
