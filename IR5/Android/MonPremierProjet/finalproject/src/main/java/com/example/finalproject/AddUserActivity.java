package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    myDbAdapter helper;
    private int id_selected;
    private String newName;
    private String newPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        EditText mName = findViewById(R.id.Add_User_Name);
        EditText mPhone = findViewById(R.id.Add_User_Phone);
        Button mButton = findViewById(R.id.Add_User_Ok);

        helper = new myDbAdapter(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newName = mName.getText().toString();
                newPhone = mPhone.getText().toString();

                //helper.updateName("LM",newName);
                if (newName.length() !=0 & newPhone.length() !=0 ){
                    helper.insertData(newName, newPhone);
                    //Toast.makeText(AddUserActivity.this, "ID: " + id_selected, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddUserActivity.this, login.class));
                }

            }
        });

    }

}
