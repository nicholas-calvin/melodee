package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Album extends AppCompatActivity {

    String uname;
    GridView gridView;
    int[] images = {
            R.drawable.perfect_velvet,
            R.drawable.red_summer,
            R.drawable.reve_finale,
            R.drawable.icy,
            R.drawable.not_shy,
            R.drawable.ice_cream,
            R.drawable.divide,
            R.drawable.queen_jazz,
            R.drawable.bohemian,

    };
    String[] titles = {
            "Perfect Velvet",
            "Red Summer",
            "Reve Finale",
            "ICY",
            "Not Shy",
            "Ice Cream",
            "Divide Album",
            "Jazz Album",
            "Original Soundtrack"
    };
    String[] artist = {
            "Red Velvet",
            "Red Velvet",
            "Red Velvet",
            "Itzy",
            "Itzy",
            "Blackpink",
            "Ed Sheeran",
            "Queen",
            "Queen"
    };
    String[] category = {
            "K-Pop",
            "K-Pop",
            "K-Pop",
            "K-Pop",
            "K-Pop",
            "K-Pop",
            "Pop",
            "Hard Rock",
            "Rock"
    };
    String[] price = {
            "Rp. 450.000",
            "Rp. 450.000",
            "Rp. 521.000",
            "Rp. 620.000",
            "Rp. 320.000",
            "Rp. 500.000",
            "Rp. 369.000",
            "Rp. 629.000",
            "Rp. 650.000"

    };
    String totalSold = "Total Sold";
    Integer[] qtySold = {
            596, 358, 521, 426, 458, 598, 586, 542, 839
    };
    String clickedArtist, clickedTitle, clickedCategory, clickedPrice;
    Integer clickedImage, clickedSold;

    ImageButton home, album, aboutus, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);

        gridView = (GridView) findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(this, titles, images, artist, category, price, totalSold, qtySold);

        uname = getIntent().getStringExtra("USERNAME_KEY");

        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                clickedArtist = artist[position];
                clickedTitle = titles[position];
                clickedImage = images[position];
                clickedCategory = category[position];
                clickedPrice = price[position];
                clickedSold = qtySold[position];
                openAlbumDetail();

            }
        });

        home = findViewById(R.id.homeBtn);
        album = findViewById(R.id.albumBtn);
        aboutus = findViewById(R.id.aboutusBtn);
        logout = findViewById(R.id.logoutBtn);

        home.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openHome();
            }

        });

        album.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openAlbum();
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openAboutUs();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.exit(0);
            }
        });


    }

    private void openAboutUs() {
        Intent goTo = new Intent(this, AboutUs.class);
        goTo.putExtra("USERNAME_KEY", uname);
        startActivity(goTo);
    }

    private void openAlbumDetail() {
        Intent goTo = new Intent(this, AlbumDetail.class);
        goTo.putExtra("USERNAME_KEY", uname);
        goTo.putExtra("ARTIST_KEY", clickedArtist);
        goTo.putExtra("TITLE_KEY", clickedTitle);
        goTo.putExtra("IMAGE_KEY", clickedImage);
        goTo.putExtra("CATEGORY_KEY", clickedCategory);
        goTo.putExtra("PRICE_KEY", clickedPrice);
        goTo.putExtra("SOLD_KEY", clickedSold);
        startActivity(goTo);
    }

    private void openAlbum() {
        Intent goTo = new Intent(this, Album.class);
        goTo.putExtra("USERNAME_KEY", uname);
        startActivity(goTo);
    }

    private void openHome() {
        Intent goTo = new Intent(this, Home.class);
        goTo.putExtra("USERNAME_KEY", uname);
        startActivity(goTo);
    }

}
