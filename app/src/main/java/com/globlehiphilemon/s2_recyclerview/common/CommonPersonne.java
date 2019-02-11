package com.globlehiphilemon.s2_recyclerview.common;

import com.globlehiphilemon.s2_recyclerview.model.Personne;

import java.util.ArrayList;

public class CommonPersonne {

    private CommonPersonne() {
    }

    public static ArrayList<Personne> getList() {

        Personne p1 = new Personne("001", "KOUASSI", "BERENGER", "YOPOUGON");
        Personne p2 = new Personne("002", "KAN", "NORBERT", "ABOBO");
        Personne p3 = new Personne("003", "YAO", "DAGOBERT", "ANGRE");
        Personne p4 = new Personne("004", "KOUADIO", "IRIE", "TREICHVILLE");
        Personne p5 = new Personne("005", "KOUAME", "ANGE", "KOUMASSI");

        ArrayList<Personne> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        return list;

    }
}
