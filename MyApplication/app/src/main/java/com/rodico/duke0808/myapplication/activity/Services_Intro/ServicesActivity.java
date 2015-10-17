package com.rodico.duke0808.myapplication.activity.Services_Intro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rodico.duke0808.myapplication.R;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }

    public void startService(View v){
        startService(new Intent(this, MyService.class));
    }
    public void stopService(View v){
        stopService(new Intent(this, MyService.class));
    }
}
