package com.rodico.duke0808.tobuy;

import com.rodico.duke0808.tobuy.Adapter.MyList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duke0808 on 10.11.15.
 */
public class AllList extends ArrayList<Map<String, Object>> implements Serializable{
    static int listCounter=0;

    public boolean add(String name, MyList list) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("currentList",list);
        list.setId(listCounter);
        listCounter++;
        return super.add(map);
    }
    public void reindex(){
        for (int i = 0;i<this.size();i++){
            MyList list = (MyList) this.get(i).get("currentList");
            list.setId(i);
        }
    }
}
