package com.rodico.duke0808.myapplication.activity.Fragment1;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.rodico.duke0808.myapplication.R;

public class Main_Activity1 extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        Button show1 = (Button) findViewById(R.id.button3);
        Button show2 = (Button) findViewById(R.id.button4);
        imageView=(ImageView) findViewById(R.id.imageView);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void show1click(View v){
        imageView.setImageResource(R.drawable.img1);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void show2click(View v){
        imageView.setImageResource(R.drawable.img2);
    }
}
