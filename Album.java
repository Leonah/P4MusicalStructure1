package com.example.android.p4musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Album extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_songs:
                    Intent SongsPage = new Intent(getApplicationContext(), Songs.class);
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
        setContentView(R.layout.activity_album);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationAB);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        TextView TvAlbumMsg= (TextView) findViewById(R.id.albumMsg);
        TvAlbumMsg.setText("This activity populate the albums name of singers using ListView , a navigation menu is also used in the bottom to navigate through the pages");

        final ListView listview = (ListView) findViewById(R.id.AlbumList);
        String[] Songs = new String[]{"Shape OF you Album", "Grateful Album", "DAMN Album",
                "Despacito Album", " Fifty Shades Darker Album" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < Songs.length; ++i) {
            list.add(Songs[i]);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
    }


}
