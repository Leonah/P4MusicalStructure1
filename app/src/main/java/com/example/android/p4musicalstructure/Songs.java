package com.example.android.p4musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Songs extends Activity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_songs:
                    mTextMessage.setText(R.string.Song);
                    return true;
                case R.id.navigation_artist:
                    mTextMessage.setText(R.string.Artist);
                    Intent Artistpage = new Intent(getApplicationContext(), Artist.class);
                    startActivity(Artistpage);
                    return true;
                case R.id.navigation_album:
                    mTextMessage.setText(R.string.Album);
                    Intent AlbumPage = new Intent(getApplicationContext(), Album.class);
                    startActivity(AlbumPage);
                    return true;
                case R.id.navigation_genre:
                    mTextMessage.setText(R.string.Genere);
                    Intent GenrePage = new Intent(getApplicationContext(), Genre.class);
                    startActivity(GenrePage);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        final TextView TvSongMsg= (TextView) findViewById(R.id.songMsg);
        TvSongMsg.setText("This activity List the songs, I have used ListView to populate possible songs and avigation menu to navigate through the pages and a BuyButton to buy the songs");

        final ListView listview = (ListView) findViewById(R.id.songList);
        String[] Songs = new String[]{"Shape OF you, Ed Sheeran", "I'm The One, Justin Biber", "DNA, Kendrick Lama",
                "Despacito, Luis Fonsi", " Don't Wanna Live Forever, ZAYN, Taylor Swift"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < Songs.length; ++i) {
            list.add(Songs[i]);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        final Button buyButton = (Button) findViewById(R.id.buyBtn);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvSongMsg.setText(" The Buy Button will direct the user to Paypal page to enter his own credential, Paypal Sdk needed to do secured authorised payment");
                buyButton.setVisibility(View.INVISIBLE);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override

            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                buyButton.setVisibility(View.VISIBLE);
                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        view.setAlpha(1);
                    }
                });
            }

        });
    }


}
