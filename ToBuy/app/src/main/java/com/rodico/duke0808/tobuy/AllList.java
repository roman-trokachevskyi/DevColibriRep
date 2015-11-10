package com.rodico.duke0808.tobuy;

import com.rodico.duke0808.tobuy.Adapter.MyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duke0808 on 10.11.15.
 */
public class AllList extends ArrayList<Map<String, Object>> {

    public boolean add(String name, MyList list) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("currentList",list);
        return super.add(map);
    }
}
