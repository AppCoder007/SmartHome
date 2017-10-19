package com.example.donavarghese.smarthome;

/**
 * Created by dfreer on 10/4/2017.
 */

public class ListItem {
    private String head;
    private String desc;

    public ListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
