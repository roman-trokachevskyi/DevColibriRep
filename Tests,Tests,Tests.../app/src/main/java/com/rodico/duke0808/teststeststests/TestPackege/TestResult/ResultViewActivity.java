package com.rodico.duke0808.teststeststests.TestPackege.TestResult;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mopub.mobileads.MoPubView;
import com.rodico.duke0808.teststeststests.R;
import com.rodico.duke0808.teststeststests.TestPackege.Test.Test;
import com.rodico.duke0808.teststeststests.TestPackege.TestView.TestViewActivity;

import static com.rodico.duke0808.teststeststests.R.layout.activity_result_view;

public class ResultViewActivity extends AppCompatActivity {
    Test currentTest;
    TextView resTv;
    Button shareBt;
    ImageView backGroundIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_result_view);
        currentTest = TestViewActivity.getCurrentTest();
        resTv = (TextView) findViewById(R.id.resultTv);
        resTv.setText(currentTest.getResult());
        shareBt = (Button) findViewById(R.id.shareBt);
        shareBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Я прошел тест '" + currentTest.getName() + "' в программе \"Тесты, тесты, тесты!\" \n Мой " +
                        "результат; \n" + currentTest.getResult();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(intent);
            }
        });
        backGroundIv = (ImageView) findViewById(R.id.imageViewRes);
        // ADDING ADS
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    //    public void shareClick(View v){
//        String text = "Я прошел тест '" + currentTest.getName() + "' в программе \"Тесты, тесты, тесты!\" \n Мой " +
//                "результат; \n" + currentTest.getResult();
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/html");
//        intent.putExtra("text", text);
//        startActivity(Intent.createChooser(intent, "Поделиться через..."));
//    }
}
