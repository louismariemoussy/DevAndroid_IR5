package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toolbar;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.maBarreOutils);
        super.setActionBar(toolbar);

        Button monBouton = findViewById(R.id.touch_me);
        PopupMenu monMenuPopup = new PopupMenu(this, monBouton);
        MenuInflater convertisseur = monMenuPopup.getMenuInflater();
        convertisseur.inflate(R.menu.pop_up, monMenuPopup.getMenu());
        monBouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monMenuPopup.show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuDeMonActivite = super.getMenuInflater();
        menuDeMonActivite.inflate(R.menu.main_menu, menu);
        return true;
    }
    //display msg in console when menu item is clicked
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.monItem2){
            Log.i("onOptionsItemSelected","L’item " + item.toString() +
                    " a bien  ́et ́e cliqu ́e");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}