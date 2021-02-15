package com.example.projet4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MonMenu extends ListActivity {

    private final String[] desserts = new String[] {
            "crème brûlée", "crumble aux framboises",
            "panna cotta", "tarte aux pommes"
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, desserts));
    }

}