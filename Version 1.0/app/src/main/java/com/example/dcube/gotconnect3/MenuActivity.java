package com.example.dcube.gotconnect3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {


    public void startNext(View view){

        Intent intent = new Intent(getApplicationContext() ,GameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);





    }
}
