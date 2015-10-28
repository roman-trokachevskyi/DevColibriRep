package com.rodico.duke0808.teststeststests;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.crashlytics.android.Crashlytics;
import com.mopub.common.MoPub;
import com.rodico.duke0808.teststeststests.TestPackege.Test.Test;
import com.rodico.duke0808.teststeststests.TestPackege.Test.TestSet;
import com.rodico.duke0808.teststeststests.TestPackege.TestView.TestViewActivity;
import io.fabric.sdk.android.Fabric;

public class ChooseActivity extends AppCompatActivity {
    ListView testsView;
    ArrayAdapter<Test> adapter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FrameLayout container;
    RelativeLayout mainLayout;
    RelativeLayout rootLayout;
    InformationFragment fragment;
    static Test selectedTest;
    ImageView backGroundIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new MoPub());
        setContentView(R.layout.activity_choose);
        fragmentManager = getSupportFragmentManager();
        container = (FrameLayout) findViewById(R.id.infoContainer);
        container.setVisibility(View.INVISIBLE);
        mainLayout=(RelativeLayout)findViewById(R.id.mainlayout);
        rootLayout=(RelativeLayout)findViewById(R.id.root_layout);
        testsView=(ListView)findViewById(R.id.listView);
        TestSet testSet=new TestSet();
        adapter=new ArrayAdapter<Test>(this, android.R.layout.simple_list_item_1, TestSet.getTests());
        testsView.setAdapter(adapter);
        testsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Test test = adapter.getItem(position);
                selectedTest = test;
                fragment = new InformationFragment();
                fragment.setInfo(test.getInfoAboutTest());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(rootLayout, new Fade());
                }
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                //transaction.addToBackStack("back");
                transaction.add(R.id.infoContainer, fragment, "tag");
                transaction.commit();
                container.setVisibility(View.VISIBLE);
                mainLayout.setVisibility(View.INVISIBLE);
            }
        });
        backGroundIv = (ImageView) findViewById(R.id.imageViewChoose);
        backGroundIv.setImageResource(R.drawable.background_chooser);
    }

    @Override
    public void onBackPressed() {
        if (fragment!=null){
            fragmentManager.beginTransaction().remove(fragment).commit();
            fragment=null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(rootLayout,new Fade());
            }
            container.setVisibility(View.INVISIBLE);
            mainLayout.setVisibility(View.VISIBLE);
            selectedTest=null;
        } else
        if (selectedTest==null) {
           super.onBackPressed();
        }
    }

    public void onCancelClick(View v){
        if (fragmentManager.findFragmentByTag("tag")!=null){
            fragmentManager.beginTransaction().remove(fragment).commit();
            fragment=null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(rootLayout,new Fade());
            }
            container.setVisibility(View.INVISIBLE);
            mainLayout.setVisibility(View.VISIBLE);
            selectedTest=null;
        }
    }
    public void onStartClick(View v){
        Intent intent = new Intent(this, TestViewActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(rootLayout,new Fade());
        }
        startActivity(intent);
    }

    public static Test getSelectedTest() {
        return selectedTest;
    }

    @Override
    protected void onResume() {
        adapter=new ArrayAdapter<Test>(this, android.R.layout.simple_list_item_1, TestSet.getTests());
        testsView.setAdapter(adapter);
        super.onResume();
    }
}
