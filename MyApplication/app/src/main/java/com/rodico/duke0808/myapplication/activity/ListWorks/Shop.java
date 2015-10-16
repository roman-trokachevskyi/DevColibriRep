package com.rodico.duke0808.myapplication.activity.ListWorks;

/**
 * Created by duke0808 on 15.10.15.
 */
public class Shop {
    String name;
    int val;
    long id;
    String workerName;
    String address;

    public Shop(String name, String workerName, int val, long id, String address) {
        this.name = name;
        this.workerName = workerName;
        this.val = val;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

