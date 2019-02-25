package com.globlehiphilemon.s2_recyclerview.sqlite.database;

public class MyDBSchema {

    public static final class Etudiant {

        public static final String TABLE_NAME = "etudiant";

        public static final class myColumns {

            public static final String ID = "id";
            public static final String NOM = "nom";
            public static final String PRENOMS = "prenoms";
            public static final String COMMUNE = "commune";
            public static final String FILIERE = "filiere";
        }
    }

    public static final class Salle {

        public static final String TABLE_NAME = "salle";

        public static final class myColumns {

            public static final String ID = "id";
            public static final String NOM = "designation";
            public static final String NBRE_PLACE = "nbrePlace";
        }
    }
}
