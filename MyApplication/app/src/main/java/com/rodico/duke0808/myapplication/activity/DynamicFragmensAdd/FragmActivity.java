package com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rodico.duke0808.myapplication.R;

public class FragmActivity extends FragmentActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragm);
        fragmentManager=getSupportFragmentManager();

        fragment1=new Fragment1();
        fragment2=new Fragment2();

    }

    public void onClick(View v){
        fragmentTransaction=fragmentManager.beginTransaction();

        switch (v.getId()){

            case R.id.addButton:
                if (fragmentManager.findFragmentByTag(fragment1.TAG)==null) {
                    fragmentTransaction.add(R.id.container,fragment1,fragment1.TAG);
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
                }
                if (fragmentManager.findFragmentByTag(fragment2.TAG)!=null){
                    fragmentTransaction.replace(R.id.container,fragment1,fragment1.TAG);
                }
                break;
        }

        fragmentTransaction.commit();
    }
}
