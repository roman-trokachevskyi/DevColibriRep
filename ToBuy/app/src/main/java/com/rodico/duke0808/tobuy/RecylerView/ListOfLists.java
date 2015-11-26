package com.rodico.duke0808.tobuy.RecylerView;

import java.util.ArrayList;

/**
 * Created by duke0808 on 26.11.15.
 */
public class ListOfLists extends ArrayList<ItemList> {
    private static ListOfLists ourInstance = new ListOfLists();

    public static ListOfLists getInstance() {
        return ourInstance;
    }

    public static void setListOfLists(ListOfLists ourInstance) {
        ListOfLists.ourInstance = ourInstance;
    }

    private ListOfLists() {
    }
}
