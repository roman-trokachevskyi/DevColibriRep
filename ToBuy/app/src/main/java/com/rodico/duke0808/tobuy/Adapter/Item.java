package com.rodico.duke0808.tobuy.Adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duke0808 on 06.11.15.
 */
public class Item {
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
        this.setChecked(!(Boolean)map.get(ATTRIBUTE_NAME_CHECKED));
    }
    public String getLabel(){
        return map.get(ATTRIBUTE_NAME_LABEL).toString();
    }
}
