package com.globlehiphilemon.s2_recyclerview.adapter;

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
import com.globlehiphilemon.s2_recyclerview.model.Personne;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private final ArrayList<Personne> listPersonne;

    Dialog dialog;
    TextView txtNomPrenomDetail;
    TextView txtCommuneDetail;

    public MyAdapter(Context context, ArrayList<Personne> listPersonne) {
        this.context = context;
        this.listPersonne = listPersonne;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(this.context).inflate(R.layout.item_personne, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        //dialog
        this.dialog = new Dialog(context);
        this.dialog.setContentView(R.layout.detail_personne);


        myViewHolder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "PERSONNE N 00" + String.valueOf(myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();

                txtNomPrenomDetail = dialog.findViewById(R.id.txt_nom_prenoms_detail);
                txtCommuneDetail = dialog.findViewById(R.id.txt_commune_detail);

                int pos = myViewHolder.getAdapterPosition();

                Personne personne = listPersonne.get(pos);

                txtNomPrenomDetail.setText(personne.getNom() + personne.getPrenoms());
                txtCommuneDetail.setText(personne.getCommune());

                dialog.show();

            }
        });

        return myViewHolder;
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

        TextView txtNomPrenomItem;
        TextView txtCommuneItem;
        TextView txtCodeItem;

        CardView itemCardView;

        public MyViewHolder(View view) {
            super(view);
            this.txtCodeItem = view.findViewById(R.id.txt_code_item);
            this.txtCommuneItem = view.findViewById(R.id.txt_commune_item);
            this.txtNomPrenomItem = view.findViewById(R.id.txt_nom_prenom_item);

            this.itemCardView = view.findViewById(R.id.item_cardView);
        }
    }

}

