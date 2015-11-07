package com.rodico.duke0808.tobuy.Adapter;

import java.util.ArrayList;

/**
 * Created by duke0808 on 06.11.15.
 */
public class MyList {
    ArrayList<Item> list;
    int firstCheckedInd;
    {
        list = new ArrayList<>();
    }

    public MyList() {
        firstCheckedInd=0;
    }
    public void addItem(Item item){
        list.add(0,item);
    }

    public int getFirstCheckedInd() {
        return firstCheckedInd;
    }

    public void setFirstCheckedInd(int firstCheckedInd) {
        this.firstCheckedInd = firstCheckedInd;
    }

    public ArrayList<Item> getList() {
        return list;
    }
    public Item getItemByInd(int n){
        return list.get(n);
    }
    public int getSize(){
        return list.size();
    }
    public void fromTo(int from, int to){
        Item item = list.remove(from);
        list.add(to,item);
    }
}
