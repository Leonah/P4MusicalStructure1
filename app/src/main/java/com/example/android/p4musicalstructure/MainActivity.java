/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.p4musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//    private Toolbar toolbar ;

    //  private View
 /*   public View getView(View convertView){
//mClickListener=convertView.OnClickListener()
      /*  View.OnClickListener mClickListener= new View.OnClickListener() {
            public void onClick(View v) {

                openArtistList(v);

            }
        };
        setOnClickListenerOnTextViews(convertView,mClickListener);
        return convertView;
    }*/
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openArtistList(v);
            //do your thing here.
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        // toolbar = (Toolbar) findViewById(R.id.ToolBarmenu); // Attaching the layout to the toolbar object
        TextView TvSong = (TextView) findViewById(R.id.Songs);
        TextView TvArtist = (TextView) findViewById(R.id.Artist);
        TextView TvAlbum = (TextView) findViewById(R.id.Album);
        TextView TvGenre = (TextView) findViewById(R.id.Genre);


        TvArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtistList(v);
            }
        });
        TvSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSongList(v);

            }
        });
        TvAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlbum(v);
            }
        });
        TvGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGenre(v);
            }
        });

        // setOnClickListenerOnTextViews(TvSong,mClickListener);
        //setOnClickListenerOnTextViews(TvArtist,mClickListener);
        //setOnClickListenerOnTextViews(TvAlbum, mClickListener);
        //setOnClickListenerOnTextViews(TvPlayList,mClickListener);


        //    setSupportActionBar(toolbar);                   // Setting toolbar as the ActionBar with setSupportActionBar() call
//
        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //    getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

/*    private void setOnClickListenerOnTextViews(View contentView, View.OnClickListener listener) {
        ArrayList<View> unvisited = new ArrayList<View>();
        unvisited.add(contentView);
        while (!unvisited.isEmpty()) {
            View child = unvisited.remove(0);
            if (child instanceof TextView) {
                child.setOnClickListener(listener);
                continue;
            }
            if (!(child instanceof ViewGroup)) {
                continue;
            }
            ViewGroup group = (ViewGroup) child;
            final int childCount = group.getChildCount();
            for (int i = 0; i < childCount; i++) {
                unvisited.add(group.getChildAt(i));
            }
        }
    }*/

    void openSongList(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        // this.setTitle(findViewById(R.string.category_colors));
        startActivity(i);
    }

    void openArtistList(View view) {

        Intent Artistpage = new Intent(this, Artist.class);
        startActivity(Artistpage);
    }

    void openAlbum(View view) {
        Intent AlbumPage = new Intent(this, Album.class);
        // this.setTitle(findViewById(R.string.category_colors));
        startActivity(AlbumPage);
    }

    void openGenre(View view) {
        Intent GenrePage = new Intent(this, Genre.class);
        startActivity(GenrePage);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.artistLabel) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}