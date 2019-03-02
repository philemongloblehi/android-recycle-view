package com.globlehiphilemon.s2_recyclerview.sqlite.etudiantdao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.globlehiphilemon.s2_recyclerview.sqlite.cursorwrapper.EtudiantCursorWrapper;
import com.globlehiphilemon.s2_recyclerview.sqlite.database.MyDBHelper;
import com.globlehiphilemon.s2_recyclerview.sqlite.database.MyDBSchema;
import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDao {

    private Context context;
    private SQLiteDatabase mDB;

    public EtudiantDao(Context context) {

        this.context = context.getApplicationContext();
        this.mDB = new MyDBHelper(context).getWritableDatabase();

    }

    public static ContentValues getContentValues(Etudiant etudiant) {

        ContentValues values = new ContentValues();
        values.put(MyDBSchema.Etudiant.MyColumns.NOM, etudiant.getNom());
        values.put(MyDBSchema.Etudiant.MyColumns.PRENOMS, etudiant.getPrenoms());
        values.put(MyDBSchema.Etudiant.MyColumns.COMMUNE, etudiant.getCommune());
        values.put(MyDBSchema.Etudiant.MyColumns.FILIERE, etudiant.getFiliere());

        return values;
    }

    public EtudiantCursorWrapper etudiantCursorWrapper(String whereClause, String[] whereArgs) {

        Cursor cursor = mDB.query(MyDBSchema.Etudiant.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);

        return new EtudiantCursorWrapper(cursor);
    }

    public Etudiant lireUn(Long id) {

        EtudiantCursorWrapper cursorWrapper = etudiantCursorWrapper(MyDBSchema.Etudiant.MyColumns.ID + " = ?",
                new String[]{id.toString()});

        try {

            if (cursorWrapper.getCount() == 0) {

                return null;
            }

            cursorWrapper.moveToFirst();

            return cursorWrapper.getEtudiant();

        } finally {
            cursorWrapper.close();
        }

    }

    public Long ajouter(Etudiant etudiant) {

        ContentValues values = getContentValues(etudiant);
        return mDB.insert(MyDBSchema.Etudiant.TABLE_NAME, null, values);
    }

    public int modifier(Etudiant etudiant) {

        int result = 0;

        if (!"".equals(etudiant.getId())) {

            ContentValues values = getContentValues(etudiant);
            result =  mDB.update(MyDBSchema.Etudiant.TABLE_NAME, values,
                    MyDBSchema.Etudiant.MyColumns.ID + " = ?",
                    new String[]{String.valueOf(etudiant.getId())});
        }

        return result;
    }

    public void supprimer(Long id) {

        mDB.delete(MyDBSchema.Etudiant.TABLE_NAME,
                MyDBSchema.Etudiant.MyColumns.ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public List<Etudiant> lireTout() {

        List<Etudiant> etudiantList = new ArrayList<>();

        EtudiantCursorWrapper cursorWrapper = etudiantCursorWrapper(null, null);

        try {

            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {

                etudiantList.add(cursorWrapper.getEtudiant());
                cursorWrapper.moveToNext();
            }

        } finally {

            cursorWrapper.close();
        }

        return etudiantList;
    }

    public int nombreElements() {

        EtudiantCursorWrapper cursorWrapper = etudiantCursorWrapper(null, null);
        return cursorWrapper.getCount();
    }

}
