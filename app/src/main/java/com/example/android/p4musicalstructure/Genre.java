package com.example.android.p4musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Genre extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_songs:
                    Intent SongsPage = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(SongsPage);
                    return true;
                case R.id.navigation_artist:
                    Intent Artistpage = new Intent(getApplicationContext(), Artist.class);
                    startActivity(Artistpage);
                    return true;
                case R.id.navigation_album:
                    Intent AlbumPage = new Intent(getApplicationContext(), Album.class);
                    // this.setTitle(findViewById(R.string.category_colors));
                    startActivity(AlbumPage);
                    return true;
                case R.id.navigation_genre:// In case if the user moved to other page, he can return to the original one
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
        setContentView(R.layout.activity_genre);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationG);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        final ListView listview = (ListView) findViewById(R.id.genreList);
        TextView TvGenreMsg= (TextView) findViewById(R.id.genreMsg);
        TvGenreMsg.setText("This activity list the genre of the Album, I have used ListView to populate possible genre");
        String[] Songs = new String[]{"Pop Music", "Hip hop Music", "Reggaeton pop Music", "Electro, Alternative R&B" }; //DNA is Hip hop music

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < Songs.length; ++i) {
            list.add(Songs[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
    }


}