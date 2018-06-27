package com.example.bianca.enhance;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class LoadPic extends AppCompatActivity {

    private ImageView loadedImage;
    private Button enhance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_pic);
        loadedImage = findViewById(R.id.loaded_image);
        enhance = findViewById(R.id.enhance_btn);
        Bitmap selectedphoto  =(this.getIntent().getParcelableExtra("data"));
        loadedImage.setImageBitmap(selectedphoto);
    }
}
