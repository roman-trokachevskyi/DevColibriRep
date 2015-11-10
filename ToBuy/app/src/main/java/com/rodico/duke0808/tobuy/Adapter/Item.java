package com.rodico.duke0808.tobuy.Adapter;

import com.rodico.duke0808.tobuy.MainActivity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duke0808 on 06.11.15.
 */
public class Item implements Serializable{
    MyList parent;
    int current_position;

    Map<String , Object> map;
    {
        map = new HashMap<>();
    }
    final String ATTRIBUTE_NAME_LABEL = "label";
    final String ATTRIBUTE_NAME_CHECKED = "checked";

    public Item(String label) {
        map.put(ATTRIBUTE_NAME_LABEL,label);
        boolean cheked = false;
        map.put(ATTRIBUTE_NAME_CHECKED, cheked);
    }

    public void setChecked(boolean checked) {
        boolean cheked = checked;
        map.put(ATTRIBUTE_NAME_CHECKED, cheked);
    }

    public boolean isChecked() {
        boolean chekecd = (boolean) map.get(ATTRIBUTE_NAME_CHECKED);
        return chekecd;
    }
    public void toggleCheck(){
        parent.reIndex();
        this.setChecked(!(Boolean) map.get(ATTRIBUTE_NAME_CHECKED));
        if (this.isChecked()==false){
            MainActivity.currentList.checkedCount--;
            MainActivity.currentList.firstCheckedInd++;
        }
        parent.checkedDown();
        parent.reIndex();
        MainActivity.agressiveSave();
    }
    public String getLabel(){
        return map.get(ATTRIBUTE_NAME_LABEL).toString();
    }
    public void setLabel (String label){
        map.put(ATTRIBUTE_NAME_LABEL, label);
    }

    public MyList getParent() {
        return parent;
    }

    public void setParent(MyList parent) {
        this.parent = parent;
    }

    public int getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(int current_position) {
        this.current_position = current_position;
    }

}
