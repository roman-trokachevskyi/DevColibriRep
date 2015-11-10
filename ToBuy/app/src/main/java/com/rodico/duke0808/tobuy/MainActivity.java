package com.rodico.duke0808.tobuy;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.rodico.duke0808.tobuy.Adapter.Item;
import com.rodico.duke0808.tobuy.Adapter.MyAdapter;
import com.rodico.duke0808.tobuy.Adapter.MyList;
import com.terlici.dragndroplist.DragNDropListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static AllList allLists;

    DragNDropListView listView;
    MyAdapter adapter;
    static public MyList currentList;
    public static final String P_NAME_LABEL = "label";
    public static final String P_NAME_CHECKED = "checked";
    static public ArrayList<Map<String,Object>> data;
    public static Context context;
    public static Saver saver = null;
    Saver saver1;
    ListView allListView;
    SimpleAdapter allSimpleAdapter;
    public static Bundle buffer;
    DrawerLayout drawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.navig_ic);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        context = getApplicationContext();
        saver1 = new Saver();
        saver = saver1;
        buffer = new Bundle();

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
                currentList.addItem(item);
                currentList.checkedDown();
                new_item_label_et.setText("");
                agressiveSave();
            }
        });

        allListView = (ListView) findViewById(R.id.all_list_view);
        String[] from = {"name"};
        int[] to = {android.R.id.text1};
        allSimpleAdapter = new SimpleAdapter(this,allLists,android.R.layout.simple_list_item_1,from,to);
        allListView.setAdapter(allSimpleAdapter);
        allSimpleAdapter.notifyDataSetChanged();
        allListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String name = (String) allLists.get(position).get("name");
                //Toast.makeText(MainActivity.this, "Clicked: ... " + name, Toast.LENGTH_SHORT).show();
                agressiveSave();
                currentList= (MyList) allLists.get(position).get("currentList");
                agressiveSave();
            }
        });
        Button new_list_bt = (Button) findViewById(R.id.new_list_bt);
        new_list_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                listView.setAdapter(null);
                adapter=null;
                final MyList newList = new MyList();
                final EditText editText = new EditText(MainActivity.this);
                editText.setHint("List Name");

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppTheme);
                builder.setTitle("New List").setCancelable(true).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("Create",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = editText.getText().toString();
                                currentList.setName(name);
                                agressiveSave();
                            }
                        }).setView(editText);
                AlertDialog dialog = builder.create();
                dialog.show();
                allLists.add(newList.getName(), newList);
                allSimpleAdapter.notifyDataSetChanged();
                currentList = newList;
                agressiveSave();
            }
        });
    }



    public void initList(){
        allLists = new AllList();

        currentList = new MyList();
        currentList.addItem(new Item("Aaaa"));
        currentList.addItem(new Item("Bbbb"));
        currentList.addItem(new Item("Cccc"));
        currentList.addItem(new Item("Ddddd"));
        currentList.addItem(new Item("Item 5"));
        currentList.addItem(new Item("Item 6"));
        currentList.addItem(new Item("Item 7"));
        currentList.addItem(new Item("Item 8"));
        allLists.add("User List", currentList);
    }

    static public void extractToData(){
        data=new ArrayList<>();
        HashMap<String,Object> map;
        for (int i=0; i< currentList.getSize();i++){
            map=new HashMap<>();
            map.put(P_NAME_LABEL, currentList.getItemByInd(i).getLabel());
            map.put(P_NAME_CHECKED, currentList.getItemByInd(i).isChecked());
            data.add(map);
        }
    }

    public void initAdapter(){
        String[] from = {P_NAME_LABEL,P_NAME_CHECKED};
        int[] to = {R.id.item_text,R.id.item_check_box};
        adapter = new MyAdapter(this,data,R.layout.item_layout,from,to,R.id.handler);
    }

    static public void packInList(){
        currentList = new MyList();
        Item item;
        for (int i=0;i<data.size();i++){
            item=new Item((String) data.get(i).get(P_NAME_LABEL));
            item.setChecked((Boolean) data.get(i).get(P_NAME_CHECKED));
            currentList.addItem(item);
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
            allSimpleAdapter.notifyDataSetChanged();
        }
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
        Toast.makeText(MainActivity.this, ""+ id, Toast.LENGTH_SHORT).show();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort_checked) {
            currentList.sortChecked();
            agressiveSave();
            allSimpleAdapter.notifyDataSetChanged();
        }
        if (id == 16908332){
            drawer.openDrawer(GravityCompat.START);
        }
        if (id == R.id.rename_list){
            final EditText editText = new EditText(MainActivity.this);
            editText.setHint("List Name");

            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppTheme);
            builder.setTitle("New List").setCancelable(true).
                    setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setPositiveButton("Rename",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String name = editText.getText().toString();
                            currentList.setName(name);
                            agressiveSave();
                        }
                    }).setView(editText);
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        extractToData();
        super.onWindowFocusChanged(hasFocus);
    }


}

