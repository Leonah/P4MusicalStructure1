package com.example.android.p4musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Artist extends AppCompatActivity {
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
        setContentView(R.layout.activity_artist);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationA);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        TextView TvArtistMsg= (TextView) findViewById(R.id.artistMsg);
        TvArtistMsg.setText("This activity list the singers name and their picture, and I have used the navigation menu in the bottom and implement a proper click listener and handler to navigate through the pages");
    }
}
