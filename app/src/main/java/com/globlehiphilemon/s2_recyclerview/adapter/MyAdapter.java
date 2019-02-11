package com.globlehiphilemon.s2_recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globlehiphilemon.s2_recyclerview.R;
import com.globlehiphilemon.s2_recyclerview.model.Personne;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    ArrayList<Personne> listPersonne;

    public MyAdapter(Context context, ArrayList<Personne> listPersonne) {
        this.context = context;
        this.listPersonne = listPersonne;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_personne, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Personne personne = this.listPersonne.get(i);
        myViewHolder.txtNomPrenomItem.setText(personne.getNom() + " " + personne.getPrenoms());
        myViewHolder.txtCodeItem.setText(personne.getCode());
        myViewHolder.txtCommuneItem.setText(personne.getCommune());

    }

    @Override
    public int getItemCount() {
        return this.listPersonne.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomPrenomItem, txtCommuneItem, txtCodeItem;

        public MyViewHolder(View view) {
            super(view);
            this.txtCodeItem = view.findViewById(R.id.txt_code_item);
            this.txtCommuneItem = view.findViewById(R.id.txt_commune_item);
            this.txtNomPrenomItem = view.findViewById(R.id.txt_nom_prenom_item);
        }
    }

}

