package com.example.myapplication1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Button mButton = findViewById(R.id.ok);
        EditText mEditText = findViewById(R.id.input);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                String input = mEditText.getText().toString();

                Intent data = new Intent(getApplicationContext(), MainActivity.class);
                data.putExtra("message_key", input);
                startActivity(data);

                }
            }
        );

    }


}
