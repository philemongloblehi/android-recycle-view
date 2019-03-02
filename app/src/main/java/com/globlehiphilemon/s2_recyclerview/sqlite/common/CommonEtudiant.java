package com.globlehiphilemon.s2_recyclerview.sqlite.common;

import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

import java.util.ArrayList;

public class CommonEtudiant {

    public static final String EXTRA_LISTE_ETUDIANTS = "LISTE ETUDIANTS";

    private CommonEtudiant() {
    }

    public static ArrayList<Etudiant> getList() {

        Etudiant p1 = new Etudiant("GLOBLEHI", "Philémon", "Yopougon", "YOPOUGON");

        ArrayList<Etudiant> list = new ArrayList<>();

        list.add(p1);

        return list;


    }

}
