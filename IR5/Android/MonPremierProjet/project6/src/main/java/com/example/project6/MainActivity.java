package com.example.project6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = findViewById(R.id.do_it);
        EditText mEditText = findViewById(R.id.input);
        TextView mTextView = findViewById(R.id.yamete);

        SharedPreferences mesPreferences = super.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editeur = mesPreferences.edit();
        // lecture de la valeur de la clef "nom":
        String nom = mesPreferences.getString("nom","");
        if (nom == ""){

        }else{
            mTextView.setText("Yamete " + nom + "san");
        }

        mButton.setOnClickListener(new View.OnClickListener() {
                                       public void onClick(View v) {

                                           String input = mEditText.getText().toString();
                                           //  ́ecriture de l’association nom/valeur
                                           editeur.putString("nom",input);
                                           editeur.commit();
                                           String nom = mesPreferences.getString("nom","");
                                           mTextView.setText("Yamete " + nom + "san");
                                       }
                                   });




    }
}