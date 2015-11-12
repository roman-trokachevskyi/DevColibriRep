package com.rodico.duke0808.tobuy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.rodico.duke0808.tobuy.Adapter.Item;
import com.rodico.duke0808.tobuy.Adapter.MyAdapter;
import com.rodico.duke0808.tobuy.Adapter.MyList;
import com.terlici.dragndroplist.DragNDropListView;
import io.fabric.sdk.android.Fabric;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public final static String fileName = "ToBuySavedData.txt";
    Toolbar toolbar = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        try {
            loadFromFile();
            allLists.reindex();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        allListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setCurrentList(position);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        Button new_list_bt = (Button) findViewById(R.id.new_list_bt);
        new_list_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                showCreateDialog();
            }
        });
        agressiveSave();
        setCurrentList(0);
    }

    public void showCreateDialog() {
        listView.setAdapter(null);
        adapter = null;
        allLists.reindex();
        final MyList newList = new MyList();
        final EditText editText = new EditText(MainActivity.this);
        RelativeLayout.LayoutParams lpet = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 270);
        editText.setLayoutParams(lpet);

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppTheme);
        builder.setTitle(getString(R.string.new_list_string)).setCancelable(true).
                setNegativeButton(R.string.cancel_string, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteList(currentList.getId());
                    }
                }).setPositiveButton(getString(R.string.create_positive_bt_str),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editText.getText().toString();
                        allLists.reindex();
                        currentList.setName(name);
                        agressiveSave();
                        setCurrentList(allLists.size()-1);
                    }
                }).setView(editText);
        AlertDialog dialog = builder.create();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.TOP;
        layoutParams.verticalMargin = 0.2f;
        dialog.getWindow().setAttributes(layoutParams);
        Resources res = Resources.getSystem();
        Drawable bckg = res.getDrawable(android.R.drawable.dialog_holo_light_frame);
        dialog.getWindow().setBackgroundDrawable(bckg);
        dialog.setCancelable(false);
        dialog.show();


        allLists.add(newList.getName(), newList);
        allSimpleAdapter.notifyDataSetChanged();
        currentList = newList;
        agressiveSave();
        allLists.reindex();
        toolbar.setTitle(currentList.getName());
    }


    public void initList(){
        allLists = new AllList();

        currentList = new MyList();
        currentList.addItem(new Item(getString(R.string.sample_item_str)));
        allLists.add(getString(R.string.user_list_str), currentList);
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
            String[] from = {"name"};
            int[] to = {android.R.id.text1};
            allSimpleAdapter = new SimpleAdapter(MainActivity.this,allLists,android.R.layout.simple_list_item_1,from,to);
            allListView.setAdapter(allSimpleAdapter);
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
            showRenameDialog();
        }
        if (id == R.id.delete_list){
            deleteList(currentList.getId());
        }
        return super.onOptionsItemSelected(item);
    }

    public void showRenameDialog() {
        final EditText editText = new EditText(MainActivity.this);
        editText.setHint(R.string.hint_list_name);
        RelativeLayout.LayoutParams lpet = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 270);
        editText.setLayoutParams(lpet);

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppTheme);
        builder.setTitle(getString(R.string.rename_list_str)).setCancelable(true).
                setNegativeButton(getString(R.string.cancel_string), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton(getString(R.string.rename_positive_bt),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = editText.getText().toString();
                        currentList.setName(name);
                        agressiveSave();
                        setCurrentList(currentList.getId());
                    }
                }).setView(editText);
        AlertDialog dialog = builder.create();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.TOP;
        layoutParams.verticalMargin = 0.2f;
        dialog.getWindow().setAttributes(layoutParams);
        Resources res = Resources.getSystem();
        Drawable bckg = res.getDrawable(android.R.drawable.dialog_holo_light_frame);
        dialog.getWindow().setBackgroundDrawable(bckg);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void deleteList(int position) {
        if (allLists.size()>1) {
            allLists.remove(position);
            setCurrentList(0);
        } else {
            //Toast.makeText(MainActivity.this, "At least one list...", Toast.LENGTH_SHORT).show();
        }
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


    public void saveToFile() throws IOException {
        File dir = getFilesDir();
        File file = new File(dir,fileName);
        FileOutputStream fos = new FileOutputStream(file,false);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(allLists);
        oos.flush();
        oos.close();
        bos.close();
        fos.close();
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        File dir = getFilesDir();
        File file = new File(dir,fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        AllList loadedList = (AllList) ois.readObject();
        allLists = loadedList;
        listView.setAdapter(null);
        adapter=null;
        currentList = (MyList) allLists.get(0).get("currentList");
        agressiveSave();
    }

    @Override
    protected void onPause() {
        try {
            saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onPause();
    }
    public void setCurrentList(int id){
        currentList = (MyList) allLists.get(id).get("currentList");
        toolbar.setTitle((String) allLists.get(id).get("name"));
        agressiveSave();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.requestFocus();
    }
}

