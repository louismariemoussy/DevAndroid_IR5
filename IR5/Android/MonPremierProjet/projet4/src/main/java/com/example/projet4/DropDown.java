package com.example.projet4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

class DropDown extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_down);
        Spinner listeDeroulante = (Spinner)findViewById(R.id.liste_deroulante);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi",

                        "Samedi","Dimanche"});

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listeDeroulante.setAdapter(adapter);
    }
}