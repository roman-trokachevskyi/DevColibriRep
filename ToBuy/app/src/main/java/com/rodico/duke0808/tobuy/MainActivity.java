package com.rodico.duke0808.tobuy;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rodico.duke0808.tobuy.Adapter.Item;
import com.rodico.duke0808.tobuy.Adapter.MyAdapter;
import com.rodico.duke0808.tobuy.Adapter.MyList;
import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropSimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DragNDropListView listView;
    MyAdapter adapter;
    static public MyList list;
    public static final String P_NAME_LABEL = "label";
    public static final String P_NAME_CHECKED = "checked";
    static public ArrayList<Map<String,Object>> data;
    public static Context context;
    public static Saver saver = null;
    Saver saver1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();
        saver1 = new Saver();
        saver = saver1;

        listView = (DragNDropListView) findViewById(R.id.drag_n_drop_list_view);
        initList();
        extractToData();
        initAdapter();
        listView.setDragNDropAdapter(adapter);
        ImageButton add_bt = (ImageButton) findViewById(R.id.add_button);
        final EditText new_item_label_et = (EditText) findViewById(R.id.new_item_et);
        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item(new_item_label_et.getText().toString());
                list.addItem(item);
                agressiveSave();
            }
        });
    }

    public void initList(){
        list = new MyList();
        list.addItem(new Item("Aaaa"));
        list.addItem(new Item("Bbbb"));
        list.addItem(new Item("Cccc"));
        list.addItem(new Item("Ddddd"));
        list.addItem(new Item("Item 5"));
        list.addItem(new Item("Item 6"));
        list.addItem(new Item("Item 7"));
        list.addItem(new Item("Item 8"));
    }

    static public void extractToData(){
        data=new ArrayList<>();
        HashMap<String,Object> map;
        for (int i=0; i<list.getSize();i++){
            map=new HashMap<>();
            map.put(P_NAME_LABEL,list.getItemByInd(i).getLabel());
            map.put(P_NAME_CHECKED,list.getItemByInd(i).isChecked());
            data.add(map);
        }
    }

    public void initAdapter(){
        String[] from = {P_NAME_LABEL,P_NAME_CHECKED};
        int[] to = {R.id.item_text,R.id.item_check_box};
        adapter = new MyAdapter(this,data,R.layout.item_layout,from,to,R.id.handler);
    }

    static public void packInList(){
        list = new MyList();
        Item item;
        for (int i=0;i<data.size();i++){
            item=new Item((String) data.get(i).get(P_NAME_LABEL));
            item.setChecked((Boolean) data.get(i).get(P_NAME_CHECKED));
            list.addItem(item);
        }
    }

    public static void agressiveSave(){
        saver.save();
    }

    public class Saver{
        public void save(){
            extractToData();
            initAdapter();
            listView.setDragNDropAdapter(adapter);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort_checked) {
            list.sortChecked();
            agressiveSave();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

