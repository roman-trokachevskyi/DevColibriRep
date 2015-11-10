package com.rodico.duke0808.tobuy.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.rodico.duke0808.tobuy.MainActivity;
import com.rodico.duke0808.tobuy.R;
import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropSimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by duke0808 on 07.11.15.
 */
public class MyAdapter extends DragNDropSimpleAdapter {
    public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to, int handler) {
        super(context, data, resource, from, to, handler);
    }

    @Override
    public View getView(final int position, View view, ViewGroup group) {
        final View view1 =  super.getView(position, view, group);
        CheckBox checkBox = (CheckBox) view1.findViewById(R.id.item_check_box);
        checkBox.setChecked(MainActivity.currentList.getItemByInd(position).isChecked());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.currentList.getItemByInd(position).toggleCheck();
                Toast.makeText(MainActivity.context, "ItemToggled", Toast.LENGTH_SHORT).show();

            }
        });
        final EditText editText = (EditText) view1.findViewById(R.id.item_text);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.getId()==R.id.item_text&&hasFocus==true){
                    Toast.makeText(MainActivity.context, "inFocus", Toast.LENGTH_SHORT).show();
                } else if (v.getId()==R.id.item_text&&hasFocus==false){
                    MainActivity.currentList.getItemByInd(position).setLabel(editText.getText().toString());
                    MainActivity.extractToData();
                }
            }
        });
        return view1;
    }

    @Override
    public void onItemDrop(DragNDropListView parent, View view, int startPosition, int endPosition, long id) {
        MainActivity.currentList.fromTo(startPosition,endPosition);
        MainActivity.currentList.checkedDown();
        MainActivity.agressiveSave();
        super.onItemDrop(parent, view, startPosition, endPosition, id);
    }

    @Override
    public void onItemDrag(DragNDropListView parent, View view, int position, long id) {
        MainActivity.extractToData();
        super.onItemDrag(parent, view, position, id);
    }
}
