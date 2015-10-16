package com.rodico.duke0808.myapplication.Browser;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.rodico.duke0808.myapplication.R;
import com.rodico.duke0808.myapplication.activity.DynamicFragmensAdd.FragmActivity;
import com.rodico.duke0808.myapplication.activity.Fragment1.Main_Activity1;
import com.rodico.duke0808.myapplication.activity.ListWorks.MainActivity;
import com.rodico.duke0808.myapplication.activity.Notification.NotificationActivity;

import java.util.ArrayList;
import java.util.List;

public class BrowserActivity extends AppCompatActivity {
    List<HomeWorkItem> homeWorkItemList;
    HwAdapter hwAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        homeWorkItemList = new ArrayList<>();
        Button startBT = (Button) findViewById(R.id.button2);
        final ListView listView = (ListView) findViewById(R.id.listView2);
        final TextView textView = (TextView) findViewById(R.id.textView4);
        init();
        listView.setAdapter(hwAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeWorkItem homeWorkItem = (HomeWorkItem) listView.getItemAtPosition(position);
                startActivity(homeWorkItem.getIntent());
            }
        });

    }

    public void init(){
        HomeWorkItem adapterActivity = new HomeWorkItem("Adapter, ListView", this, MainActivity.class);
        homeWorkItemList.add(adapterActivity);
        //add new lesson here
        homeWorkItemList.add(new HomeWorkItem("Notification",this, NotificationActivity.class));
        homeWorkItemList.add(new HomeWorkItem("Fragments #1",this, Main_Activity1.class));
        homeWorkItemList.add(new HomeWorkItem("Dynamically Add Fragments",this, FragmActivity.class));

        //setting adapter
        hwAdapter  = new HwAdapter(homeWorkItemList,this);
    }
}
