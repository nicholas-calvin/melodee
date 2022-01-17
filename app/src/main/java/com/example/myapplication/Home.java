package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    String uname;
    ViewFlipper imgCarousell;
    TextView welcome;
    GridView gridView;
    int[] isiCarousell = {
            R.drawable.reve_finale,
            R.drawable.red_summer,
            R.drawable.bohemian
    };
    int[] imgRepeater = {
            R.drawable.perfect_velvet,
            R.drawable.icy,
            R.drawable.ice_cream
    };
    String[] artist1 = {
            "Red Velvet",
            "Itzy",
            "Blackpink"
    };
    String[] title1 = {
            "Perfect Velvet",
            "ICY",
            "Ice Cream"
    };
    String category1 = "K-Pop";
    String[] price1 = {
            "Rp. 450.000",
            "Rp. 620.000",
            "Rp. 500.000"
    };
    String totalSold1 = "Total Sold";
    Integer[] qtySold1 = {
            201, 213, 231
    };
    ImageButton home, album, aboutus, logout;
    String clickedArtist, clickedTitle, clickedCategory, clickedPrice;
    Integer clickedImage, clickedSold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        this.welcome = findViewById(R.id.welcome);
        imgCarousell = findViewById(R.id.imgCarousell);

        gridView = (GridView) findViewById(R.id.repeaterHome);
        CustomAdapter contentRepeater = new CustomAdapter();
        gridView.setAdapter(contentRepeater);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedArtist = artist1[position];
                clickedTitle = title1[position];
                clickedImage = imgRepeater[position];
                clickedCategory = category1;
                clickedPrice = price1[position];
                clickedSold = qtySold1[position];
                openAlbumDetail();
            }
        });

        uname = getIntent().getStringExtra("USERNAME_KEY");
        welcome.setText("Welcome, " + uname);

        for (int i : isiCarousell
        ) {
            insertImage(i);
        }

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

        aboutus.setOnClickListener(new View.OnClickListener() {
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

    private void insertImage(Integer img) {

        ImageView image = new ImageView(Home.this);
        image.setBackgroundResource(img);

        imgCarousell.addView(image);
        imgCarousell.setFlipInterval(3000);
        imgCarousell.setAutoStart(true);
        imgCarousell.setInAnimation(Home.this, R.anim.slide_in_right);
        imgCarousell.setOutAnimation(Home.this, R.anim.slide_out_left);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return imgRepeater.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.repeater, null);
            ImageView img = convertView.findViewById(R.id.imagealbum);
            TextView artist = convertView.findViewById(R.id.artist);
            TextView title = convertView.findViewById(R.id.titles);
            TextView category = convertView.findViewById(R.id.category);
            TextView price = convertView.findViewById(R.id.price);
            TextView totalSold = convertView.findViewById(R.id.totalSold);
            TextView qtySold = convertView.findViewById(R.id.qtySold);

            img.setImageResource(imgRepeater[position]);
            artist.setText(artist1[position]);
            title.setText(title1[position]);
            category.setText(category1);
            price.setText(price1[position]);
            totalSold.setText(totalSold1);
            qtySold.setText(qtySold1[position].toString());

            return convertView;
        }
    };
}
