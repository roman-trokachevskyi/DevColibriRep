package com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rodico.duke0808.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    public static final String TAG = "com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd.FRAGMENT2_TAG";
    public TextView fr2TV;


    public Fragment2() {
        // Required empty public constructor
    }

    public static String getTAG() {
        return TAG;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        fr2TV=(TextView) getView().findViewById(R.id.textViewFR2);
        super.onActivityCreated(savedInstanceState);
    }
}
