package com.rodico.duke0808.myapplication.activity.CameraIntro;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rodico.duke0808.myapplication.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    ImageView imageView;
    ImageView smallIv;
    File imgFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView = (ImageView) findViewById(R.id.imageView2);
        smallIv = (ImageView) findViewById(R.id.imageView3);
    }

    public void capture(View v){
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (captureIntent.resolveActivity(getPackageManager())!=null){
            imgFile=null;
            try {
                imgFile = getImgFile();
            } catch (IOException e) {
                Toast.makeText(Main3Activity.this, "EROR: CREATE FILE", Toast.LENGTH_SHORT).show();
            }
            if (imgFile!=null){
                captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imgFile));
                startActivityForResult(captureIntent, 1);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1&&resultCode==RESULT_OK){
            Intent mdiaScanInt = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            mdiaScanInt.setData(Uri.fromFile(imgFile));
            this.sendBroadcast(mdiaScanInt);

            imageView.setImageURI(Uri.fromFile(imgFile));
        }
    }

    public File getImgFile() throws IOException {
        String currdate = new SimpleDateFormat("ddMMyyyy_mmhhss").format(new Date());
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imgFile = File.createTempFile(currdate,".jpg",dir);
        return imgFile;
    }

    public void share(View v){
        if (imgFile!=null){
            Intent shareInt = new Intent(Intent.ACTION_SEND);
            shareInt.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(imgFile));
            shareInt.setType("image/jpeg");
            startActivity(Intent.createChooser(shareInt,"Send img to..."));
        }
    }

}
