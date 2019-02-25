package com.globlehiphilemon.s2_recyclerview.sqlite.cursorwrapper;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.globlehiphilemon.s2_recyclerview.sqlite.database.MyDBSchema;
import com.globlehiphilemon.s2_recyclerview.sqlite.model.Etudiant;

public class EtudiantCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public EtudiantCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Etudiant getEtudiant() {

        String mId = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.ID));
        String mNom = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.NOM));
        String mPrenoms = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.PRENOMS));
        String mCommune = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.COMMUNE));
        String mFiliere = getString(getColumnIndex(MyDBSchema.Etudiant.MyColumns.FILIERE));

        Etudiant etudiant = new Etudiant();
        etudiant.setId(Long.valueOf(mId));
        etudiant.setNom(mNom);
        etudiant.setPrenoms(mPrenoms);
        etudiant.setCommune(mCommune);
        etudiant.setFiliere(mFiliere);

        return etudiant;
    }
}
