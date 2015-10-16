package com.rodico.duke0808.myapplication.activity.Fragment1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodico.duke0808.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImgFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImgFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImgFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.img_layout, container, false);
    }


}
