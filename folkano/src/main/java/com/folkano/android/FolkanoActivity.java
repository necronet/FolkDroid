package com.folkano.android;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;


public class FolkanoActivity extends Activity implements ActionBar.OnNavigationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                actionBar.getThemedContext(),
                R.layout.actionbar_spinner,
                android.R.id.text1, getResources().getStringArray(R.array.event_type));
        adapter.setDropDownViewResource(R.layout.actionbar_spinner);

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(adapter, this);

        setContentView(R.layout.activity_folkano);


        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_content);

        if (fragment == null) {
            fragment = EventListFragment.newInstance(null);
            getFragmentManager().beginTransaction().add(R.id.fragment_content, fragment, "content").commit();
        } 


    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return false;
    }
}
