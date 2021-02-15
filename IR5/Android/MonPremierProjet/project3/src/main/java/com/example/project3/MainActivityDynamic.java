package com.example.project3;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityDynamic extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamic);

        MonFragment fragment = new MonFragment();
        MonFragment2 fragment2 = new MonFragment2();
        FragmentManager FragmentManager = getFragmentManager();
        FragmentTransaction transaction= FragmentManager.beginTransaction();
        transaction.add(R.id.dynamic_fragment, fragment);
        //transaction.commit();
        transaction.commit();

        Button mButton = findViewById(R.id.second);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                MonFragment2 fragment2 = new MonFragment2();
                FragmentManager FragmentManager = getFragmentManager();
                FragmentTransaction transaction= FragmentManager.beginTransaction();
                transaction.isAddToBackStackAllowed();
                transaction.addToBackStack("fragment");
                transaction.replace(R.id.dynamic_fragment, fragment2);
                transaction.commit();

            }
        });



    }

}
