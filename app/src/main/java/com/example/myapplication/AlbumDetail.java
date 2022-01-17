package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumDetail extends AppCompatActivity {

    ImageButton backBtn;
    Integer image, qtySold;
    int value;
    String artist, title, category, price;
    ImageView imageDetail;
    TextView artistDetail, titleDetail, categoryDetail, priceDetail, totalSoldDetail, errorMessQuantity;
    EditText qtyBuy;
    Button orderBtn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albumdetail);

        backBtn = findViewById(R.id.backBtn);

        imageDetail = findViewById(R.id.imageDetail);
        artistDetail = findViewById(R.id.artistDetail);
        titleDetail = findViewById(R.id.titleDetail);
        categoryDetail = findViewById(R.id.categoryDetail);
        priceDetail = findViewById(R.id.priceDetail);
        totalSoldDetail = findViewById(R.id.totalSoldDetail);
        errorMessQuantity = findViewById(R.id.errorMessQuantity);
        qtyBuy = findViewById(R.id.qtyDetail);

        orderBtn = findViewById(R.id.orderBtn);

        image = getIntent().getIntExtra("IMAGE_KEY", 0);
        artist = getIntent().getStringExtra("ARTIST_KEY");
        title = getIntent().getStringExtra("TITLE_KEY");
        category = getIntent().getStringExtra("CATEGORY_KEY");
        price = getIntent().getStringExtra("PRICE_KEY");
        qtySold = getIntent().getIntExtra("SOLD_KEY", 0);

        imageDetail.setImageResource(image);
        artistDetail.setText(artist);
        titleDetail.setText(title);
        categoryDetail.setText(category);
        priceDetail.setText(price);
        totalSoldDetail.setText(qtySold.toString());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {

        Integer qty = Integer.valueOf(this.qtyBuy.getText().toString());

        if(qty <= 0){
            openErrorDialog();
        }
        else{
            openSuccessDialog();
        }


    }

    private void openErrorDialog(){
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getSupportFragmentManager(), "Error Message");
    }

    private void openSuccessDialog(){
        SuccessDialog successDialog = new SuccessDialog();
        successDialog.show(getSupportFragmentManager(), "Success");
    }

}
