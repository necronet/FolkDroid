package com.folkano.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FolkanoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folkano);

        EventListFragment fragmentList = EventListFragment.newInstance(null);

        getFragmentManager().beginTransaction().add(R.id.fragment_content, fragmentList, "content").commit();


    }



}
