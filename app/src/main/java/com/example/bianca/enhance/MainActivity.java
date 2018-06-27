package com.example.bianca.enhance;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button takePicture;
    private Button loadPicture;
    private static final int SELECT_PICTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePicture = findViewById(R.id.take_photo_btn);
        takePictureBtn();
        loadPicture = findViewById(R.id.load_image_btn);
        loadPictureBtn();
    }
    private void takePictureBtn() {
        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCamera = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(openCamera);
            }
        });
    }
    private void loadPictureBtn() {
        loadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO load picture from gallery
                Toast.makeText(getApplicationContext(), "Load image!",
                        Toast.LENGTH_LONG).show();
                Intent load = new Intent();
                load.setType("iamge/*");
                load.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(load, "Complete action using"), SELECT_PICTURE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bitmap selectedphoto   = null;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && null != data)
        {
            Uri selectedImage = data.getData();
            String [] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            selectedphoto = BitmapFactory.decodeFile(filePath);
            cursor.close();
            Intent photoSelect = new Intent (MainActivity.this, LoadPic.class);
          //  photoSelect.putExtra("data",filePath);
           photoSelect.putExtra("data",selectedphoto);
            startActivity(photoSelect);

        }

    }
}
