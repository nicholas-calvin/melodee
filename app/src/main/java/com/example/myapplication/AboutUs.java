package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class AboutUs extends AppCompatActivity {

    String uname;
    ImageButton home, album, aboutus, logout;
    TextView welcome;
    TabLayout tabLayout;
    TabItem information, location;
    ViewPager content;
    PagerAdapter pagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);

        welcome = findViewById(R.id.welcome);

        tabLayout = findViewById(R.id.tabLayout);
        information = findViewById(R.id.information);
        location = findViewById(R.id.location);
        content = findViewById(R.id.content);

        uname = getIntent().getStringExtra("USERNAME_KEY");
        welcome.setText("Welcome, " + uname);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        content.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                content.setCurrentItem(tab.getPosition());
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        content.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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
