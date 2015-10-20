package com.rodico.duke0808.myapplication.activity.PickFromGallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rodico.duke0808.myapplication.Browser.BrowserActivity;
import com.rodico.duke0808.myapplication.R;

public class FromGallery extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_gallery);
        imageView = (ImageView) findViewById(R.id.imageView4);
    }

    public void pick(View v){
        Intent pickIntent = new Intent(Intent.ACTION_GET_CONTENT);
        pickIntent.setType("image/*");
        startActivityForResult(Intent.createChooser(pickIntent,"Use what...?"), 0);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void set(View v){
        RelativeLayout relativeLayout = BrowserActivity.getBrowserLayout();
        Drawable drawable = imageView.getDrawable();

        relativeLayout.setBackground(drawable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0&&resultCode==RESULT_OK){
            Uri imgUri = data.getData();
            imageView.setImageURI(imgUri);
        }
    }
}
