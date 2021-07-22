package cn.nodemedia.demo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import cn.nodemedia.NodeCameraView;
import cn.nodemedia.NodePublisher;

public class MainActivity extends AppCompatActivity {
    TextView showCounter;
    int counter = 0;
    NodeCameraView mNodeCameraView;
    Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCounter =(TextView) findViewById(R.id.textCounter);
    }

    public void increaseCounter (View view) {
        counter++;
        showCounter.setText(Integer.toString(counter));
    }

    public void stopStreaming (View view) {
        mNodeCameraView.stopPreview();
    }

    public void startStreaming (View view) {
        //Log.i("working", "working");
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            mNodeCameraView = new NodeCameraView(this);
            mNodeCameraView.setVisibility(View.VISIBLE);
//            Log.d("CAMERA INFO", mNodeCameraView.getPreviewSize().toString());

            mNodeCameraView.startPreview(0);
//            new NodePublisher(this).startPreview();

//            try {
//                Camera camera = Camera.open(0);
//                SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
//                SurfaceHolder surfaceHolder = surfaceView.getHolder();
//                camera.setPreviewDisplay(surfaceHolder);
//                camera.startPreview();
//            } catch (Exception e) {
//                Log.d("ERROE", e.getStackTrace().toString());
//            }
            return;
        }

        ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.CAMERA}, 0);

    }
}
