package com.example.dcube.gotconnect3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    MediaPlayer sp;


    ListView list;
    String[] members ={
            "STARK",
            "LANISTERS",
            "TARGARIAN",
            "BOLTON",
            "MARTEL",
            "TYRELL",
            "GREYJOY",
            "BARATHEON"
    };

    Integer[] imgid={
            R.drawable.stark,
            R.drawable.lanister,
            R.drawable.targarian,
            R.drawable.bolton,
            R.drawable.martel,
            R.drawable.tyrell,
            R.drawable.greyjoy,
            R.drawable.boratheon,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CustomListAdapter adapter=new CustomListAdapter(this, members, imgid);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sp = MediaPlayer.create(MenuActivity.this, R.raw.sword);
                sp.start();

                Intent intent = new Intent (getApplicationContext() , GameActivity.class);
                intent.putExtra("player" , position);
                startActivity(intent);

            }
        });

    }
}
