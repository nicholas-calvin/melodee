package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GridAdapter extends BaseAdapter {

    Context context;
    private final String[] titles;
    private final int[] images;
    private final String[] artist;
    private final String[] category;
    private final String[] price;
    private final String totalSold;
    private final Integer[] qtySold;
    View view;
    LayoutInflater layoutInflater;

    public GridAdapter(Context context, String[] titles, int[] images, String[] artist, String[] category, String[] price, String totalSold, Integer[] qtySold) {
        this.artist = artist;
        this.context = context;
        this.titles = titles;
        this.images = images;
        this.category = category;
        this.price = price;
        this.totalSold = totalSold;
        this.qtySold = qtySold;
    }

    @Override
    public int getCount() {
        return titles.length;
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
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.repeater, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imagealbum);
            TextView title1 = (TextView) view.findViewById(R.id.titles);
            TextView artist1 = (TextView) view.findViewById(R.id.artist);
            TextView category1 = (TextView) view.findViewById(R.id.category);
            TextView price1 = (TextView) view.findViewById(R.id.price);
            TextView totalSold1 = (TextView) view.findViewById(R.id.totalSold);
            TextView qtySold1 = (TextView) view.findViewById(R.id.qtySold);

            imageView.setImageResource(images[position]);
            title1.setText(titles[position]);
            artist1.setText(artist[position]);
            category1.setText(category[position]);
            price1.setText(price[position]);
            totalSold1.setText(totalSold);
            qtySold1.setText(qtySold[position].toString());

        }
        return view;
    }
}
