package com.example.joakin.actividad3firebase;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by joaquinlopezamador on 08/11/2016.
 */

public class MainActivityC implements View.OnClickListener {
    MainActivity mainActivity;


    public MainActivityC(MainActivity mainActivity) {

        this.mainActivity = mainActivity;
    }

    public void downloadLanguages(int idi) {

        DataHolder.myRefIdiomas = DataHolder.database.getReference().child("Idioma/" + idi);
        System.out.println("yeyeyeyeyeyeye" + DataHolder.database.getReference().child("Idioma").getParent());


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, String> hm = (HashMap<String, String>) dataSnapshot.getValue();

                System.out.println("--------" + hm.get("Palabra1"));
                mainActivity.ETHOLA.setText(hm.get("Palabra1"));
                mainActivity.ETMUNDO.setText(hm.get("Palabra2"));
                mainActivity.BTSp.setText(hm.get("boton2"));
                mainActivity.BTEn.setText(hm.get("boton"));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        DataHolder.myRefIdiomas.addValueEventListener(postListener);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ENGLISHBUTTON) {
            System.out.println("entra-----");
            downloadLanguages(1);
        } else if (v.getId() == R.id.SPANISHBUTTON) {
            downloadLanguages(2);
        } else {
            if (mainActivity.ETUSer != null || mainActivity.ETMensaje != null) {
                DataHolder.mensaje = mainActivity.ETUSer.getText().toString();
                DataHolder.writeFirebase();

            }
        }

    }


}


