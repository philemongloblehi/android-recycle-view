package com.globlehiphilemon.s2_recyclerview.sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "etablissement_db";

    public myDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {

        sqLiteDB.execSQL("CREATE TABLE " + MyDBSchema.Etudiant.TABLE_NAME + "("
                + MyDBSchema.Etudiant.myColumns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MyDBSchema.Etudiant.myColumns.NOM + " TEXT, "
                + MyDBSchema.Etudiant.myColumns.PRENOMS + " TEXT, "
                + MyDBSchema.Etudiant.myColumns.COMMUNE + " TEXT, "
                + MyDBSchema.Etudiant.myColumns.FILIERE + " TEXT)");

        sqLiteDB.execSQL("CREATE TABLE " + MyDBSchema.Salle.TABLE_NAME + "("
                + MyDBSchema.Salle.myColumns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MyDBSchema.Salle.myColumns.NOM + " TEXT, "
                + MyDBSchema.Salle.myColumns.NBRE_PLACE + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int oldVersion, int newVersion) {

        sqLiteDB.execSQL("DROP TABLE IF EXISTS " + MyDBSchema.Etudiant.TABLE_NAME);
        sqLiteDB.execSQL("DROP TABLE IF EXISTS " + MyDBSchema.Salle.TABLE_NAME);
        onCreate(sqLiteDB);

    }
}
