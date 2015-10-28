package com.rodico.duke0808.teststeststests;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {
    String info;
    Button startBt;
    Button cancelBt;


    public InformationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false);
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView infoView = (TextView) getView().findViewById(R.id.infoTextView);
        infoView.setText(info);
        startBt=(Button) getView().findViewById(R.id.startTestBt);
        cancelBt=(Button)getView().findViewById(R.id.cancelBt);
        super.onViewCreated(view, savedInstanceState);
    }
}
