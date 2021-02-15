package com.example.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button mButton = findViewById(R.id.btnesaip);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.esaip.org/")));
            }
        });
    }
}
