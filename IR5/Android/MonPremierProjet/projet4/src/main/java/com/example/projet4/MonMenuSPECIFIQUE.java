package com.example.projet4;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;

public class MonMenuSPECIFIQUE extends ListActivity {

    private final String[] desserts = new String[] {
            "crème brûlée", "crumble aux framboises",
            "panna cotta", "tarte aux pommes"
    };
    protected ArrayAdapter<String> myAdaptater;
    private ArrayList<String> listeDesserts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mon_menu_spe);

        //Drop down
        Spinner listeDeroulante = (Spinner)findViewById(R.id.liste_deroulante);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi",

                        "Samedi","Dimanche"});

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listeDeroulante.setAdapter(adapter);

        listeDesserts = new ArrayList<String>();
        for(int i=0; i<4; i++)
            listeDesserts.add(desserts[i]);

        this.myAdaptater = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, listeDesserts);
        super.setListAdapter(this.myAdaptater);

        //btn to add an item
        Button PlusBtn = findViewById(R.id.btnplus);
        PlusBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //add an item
                myAdaptater.add(new String("cheesecake"));
            }


        });


        //btn to remove an item
        Button MinusBtn = findViewById(R.id.btnminus);
        MinusBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //add an item
                int size = (listeDesserts.size())-1;
                listeDesserts.remove(size);
                myAdaptater.notifyDataSetChanged();

            }


        });



        // gestion du clic long
        getListView().setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent,
                        View view, int position, long id) {
                            String s = "click LONG de l'item nuḿero " + position;
                            Log.i("onItemLongClick", s);//ds la console
                        TextView textview2 = (TextView)findViewById(R.id.textView2);
                        textview2.setText(s);
                        return true;
                    }

                }
        );
    }

    // gestion du simple clic:
    public void onListItemClick(ListView liste, View vue, int position, long id){
        String s = "click de l'item nuḿero " + position;
        Log.i("onListItemClick", s);//dans la console
        TextView textview2 = (TextView)findViewById(R.id.textView2);
        textview2.setText(s);
    }
}