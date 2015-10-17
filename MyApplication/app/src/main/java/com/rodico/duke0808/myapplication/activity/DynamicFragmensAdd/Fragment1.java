package com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rodico.duke0808.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    public static final String TAG = "com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd.FRAGMENT1_TAG";


    public Fragment1() {
        // Required empty public constructor
    }

    public static String getTAG() {
        return TAG;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Button btn = (Button) getView().findViewById(R.id.btFragm1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) getView().findViewById(R.id.editTextFR1);
                String text = editText.getText().toString();
                FragmActivity.fragment2.fr2TV.setText(text);
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
