package com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.rodico.duke0808.myapplication.R;

public class FragmActivity extends FragmentActivity {
    static Fragment1 fragment1;
    static Fragment2 fragment2;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragm);
        fragmentManager=getSupportFragmentManager();
        container = (LinearLayout) findViewById(R.id.container);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v){
        fragmentTransaction=fragmentManager.beginTransaction();

        switch (v.getId()){

            case R.id.addButton:
                if (fragmentManager.findFragmentByTag(fragment2.TAG)==null) {
                    fragmentTransaction.add(R.id.container,fragment2,fragment2.TAG);
                    container.setElevation(2);
                } break;


            case R.id.removeButton:
                if (fragmentManager.findFragmentByTag(fragment1.TAG)!=null) {
                    fragmentTransaction.remove(fragment1);
                }
                if (fragmentManager.findFragmentByTag(fragment2.TAG)!=null) {
                    fragmentTransaction.remove(fragment2);
                }
                break;
            case R.id.replaceBT:
                if (fragmentManager.findFragmentByTag(fragment1.TAG)!=null){
                    fragmentTransaction.replace(R.id.container,fragment2,fragment2.TAG);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        container.setElevation(2);
                        container.setTranslationZ(4);
                    }
                }
                if (fragmentManager.findFragmentByTag(fragment2.TAG)!=null){
                    fragmentTransaction.replace(R.id.container,fragment1,fragment1.TAG);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        container.setElevation(10);
                    }
                }
                break;
        }

        fragmentTransaction.commit();
    }
}
