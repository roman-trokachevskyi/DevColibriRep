package com.rodico.duke0808.tobuy.Adapter;

import java.util.ArrayList;

/**
 * Created by duke0808 on 06.11.15.
 */
public class MyList {
    ArrayList<Item> list;
    String name;
    int firstCheckedInd;
    int checkedCount;
    {
        list = new ArrayList<>();
    }

    public MyList() {
        firstCheckedInd=0;
        checkedCount=0;
    }
    public void addItem(Item item){
        item.setParent(this);
        list.add(0, item);
        reIndex();
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
    public void checkedDown(){
        if (firstCheckedInd==0){
            for (int i=0;i<list.size();i++){
                if (list.get(i).isChecked()){
                    Item item = list.remove(i);
                    list.add(item);
                    firstCheckedInd=list.size()-1;
                    checkedCount++;
                    break;
                }
            }
        } else {
            for (int i=0;i<firstCheckedInd;i++){
                if (list.get(i).isChecked()){
                    Item item = list.remove(i);
                    list.add(firstCheckedInd-1,item);
                    firstCheckedInd--;
                    checkedCount++;
                    break;
                }
            }
        }
        if (checkedCount==0) firstCheckedInd=0;
    }
    public void reIndex(){
        for (int i=0;i<list.size();i++) {
            list.get(i).setCurrent_position(i);
        }
    }

    public Item remove(int n){
        return list.remove(n);
    }

    public void addItem(int firstCheckedInd, Item item) {
        list.add(firstCheckedInd,item);
    }

    public void sortChecked(){
        for (int i=firstCheckedInd;i<list.size();i++){
            for (int j=firstCheckedInd;j<list.size()-1;j++){
                String sj = list.get(j).getLabel();
                String sjj = list.get(j+1).getLabel();
                int compare = sj.toLowerCase().compareTo(sjj.toLowerCase());
                if (compare>0){
                    Item item = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,item);
                }
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
