package com.folkano.android;

import java.util.Date;

/**
 * Created by necronet on 3/28/14.
 */
public class Event {

    long id;
    String title;
    String imageUrl;
    String address;
    Date date;

    public Event(long id, String title, String address, String imageUrl, Date date) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.address = address;
        this.date = date;
    }


}
