package cn.nodemedia.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cn.nodemedia.NodeCameraView;
import cn.nodemedia.NodePublisher;

public class MainActivity extends AppCompatActivity {
    TextView showCounter;
    int counter = 0;
    NodeCameraView mNodeCameraView;

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

    public void startStreaming (View view) {
        //Log.i("working", "working");
        mNodeCameraView = new NodeCameraView(getBaseContext());
        mNodeCameraView.switchCamera();
        mNodeCameraView.startPreview(0);

        new NodePublisher(this).startPreview();
    }
}
