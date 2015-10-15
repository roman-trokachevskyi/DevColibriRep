package com.rodico.duke0808.myapplication.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rodico.duke0808.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lV;
    List<Shop> list;
    ShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lV  = (ListView) findViewById(R.id.listView);
        init();
        lV.setAdapter(shopAdapter);
        final TextView textView = (TextView) findViewById(R.id.textView3);

        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shop shop = (Shop) parent.getAdapter().getItem(position);
                textView.setText(String.format("Shop name is '%s', worker is %s, address is %s, rent is %d, id is %d", shop.getName(), shop.getWorkerName(), shop.getAddress(), shop.getVal(), shop.getId()));

            }
        });

    }

    public void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Question")
                .setMessage("Do you want?!")
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Canseled", Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void init(){
        list = new ArrayList<>();

        Shop zor = new Shop("Zoryanuy","Inna masik", 4000, 2,"Stadion square");
        Shop him = new Shop("Uyt","Oksana",3000,5,"HimPas");
        Shop lil = new Shop("Liliya","Inna Large", 3500 , 3,"Gogolya");
        list.add(zor);
        list.add(him);
        list.add(lil);
        shopAdapter = new ShopAdapter(this,list);
    }
}
