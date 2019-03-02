package com.globlehiphilemon.s2_recyclerview.sqlite.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globlehiphilemon.s2_recyclerview.R;
import com.globlehiphilemon.s2_recyclerview.sqlite.adapter.MyAdapterEtudiant;
import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

import java.util.ArrayList;

public class MyAdapterEtudiant extends RecyclerView.Adapter<MyAdapterEtudiant.MyViewHolder> {

    private Context context;
    private final ArrayList<Etudiant> listEtudiants;

    Dialog dialog;
    TextView txtNomPrenomDetailEtudiant;
    TextView txtFiliereDetailEtudiant;
    TextView txtCommuneDetailEtudiant;

    public MyAdapterEtudiant(Context context, ArrayList<Etudiant> listEtudiants) {
        this.context = context;
        this.listEtudiants = listEtudiants;
    }

    @NonNull
    @Override
    public MyAdapterEtudiant.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(this.context).inflate(R.layout.item_etudiant, viewGroup, false);
        final MyAdapterEtudiant.MyViewHolder myViewHolder = new MyAdapterEtudiant.MyViewHolder(view);

        //dialog
        this.dialog = new Dialog(context);
        this.dialog.setContentView(R.layout.detail_etudiant);

        myViewHolder.itemCardViewEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtNomPrenomDetailEtudiant = dialog.findViewById(R.id.txt_nom_prenoms_detail_etudiant);
                txtFiliereDetailEtudiant = dialog.findViewById(R.id.txt_filiere_detail_etudiant);
                txtCommuneDetailEtudiant = dialog.findViewById(R.id.txt_commune_detail_etudiant);

                int pos = myViewHolder.getAdapterPosition();

                Etudiant etudiant = listEtudiants.get(pos);

                txtNomPrenomDetailEtudiant.setText(etudiant.getNom() + etudiant.getPrenoms());
                txtFiliereDetailEtudiant.setText(etudiant.getFiliere());
                txtCommuneDetailEtudiant.setText(etudiant.getCommune());

                dialog.show();

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterEtudiant.MyViewHolder myViewHolder, int i) {
        Etudiant etudiant = this.listEtudiants.get(i);
        myViewHolder.txtNomPrenomItemEtudiant.setText(etudiant.getNom() + " " + etudiant.getPrenoms());
        myViewHolder.txtFiliereItemEtudiant.setText(etudiant.getFiliere());
        myViewHolder.txtCommuneItemEtudiant.setText(etudiant.getCommune());

    }

    @Override
    public int getItemCount() {
        return this.listEtudiants.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomPrenomItemEtudiant;
        TextView txtFiliereItemEtudiant;
        TextView txtCommuneItemEtudiant;

        CardView itemCardViewEtudiant;

        public MyViewHolder(View view) {
            super(view);
            this.txtNomPrenomItemEtudiant = view.findViewById(R.id.txt_nom_prenom_item_etudiant);
            this.txtFiliereItemEtudiant = view.findViewById(R.id.txt_filiere_item_etudiant);
            this.txtCommuneItemEtudiant = view.findViewById(R.id.txt_commune_item_etudiant);

            this.itemCardViewEtudiant = view.findViewById(R.id.item_cardViewEtudiant);
        }
    }


}
