package com.rodico.duke0808.myapplication.activity.ListWorks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rodico.duke0808.myapplication.R;

import java.util.List;

/**
 * Created by duke0808 on 15.10.15.
 */
public class ShopAdapter extends BaseAdapter {

    List<Shop> list;
    LayoutInflater layoutInflater;

    public ShopAdapter(Context context, List<Shop> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            view = layoutInflater.inflate(R.layout.shop_item_layout,parent,false);
        }


        TextView textView = (TextView) view.findViewById(R.id.textView2);
        Shop shop = (Shop) getItem(position);
        textView.setText(shop.getName());
        return view;
    }
}
