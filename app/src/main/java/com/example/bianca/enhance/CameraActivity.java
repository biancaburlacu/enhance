package com.example.bianca.enhance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.ImageButton;

public class CameraActivity extends AppCompatActivity {

    private SurfaceView cameraPreview;
    private ImageButton captureImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraPreview = findViewById(R.id.camera_preview);
        captureImage = findViewById(R.id.capture_image);
    }
}
