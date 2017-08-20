package com.example.dcube.gotconnect3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.ybq.android.spinkit.SpinKitView;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer mp , sp;

    public void playNext(View view){

        Intent intent = new Intent(getApplicationContext() ,MenuActivity.class);
        startActivity(intent);

        SpinKitView spinKitView = (SpinKitView) findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.VISIBLE);

        sp = MediaPlayer.create(this, R.raw.sword);
        sp.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mp = MediaPlayer.create(this, R.raw.freedonbg);
        mp.start();


    }
}
