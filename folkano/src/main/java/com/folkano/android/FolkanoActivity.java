package com.folkano.android;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;



public class FolkanoActivity extends Activity implements ActionBar.OnNavigationListener, EventListFragment.EventListCallback {

    private ViewPager mPager;
    private EventPagerAdapter mPagerAdapter;
    private static final String[] titles = { "Todos los eventos", "Concierto", "Deportes", "Danza", "Taller" };


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

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new EventPagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }

    @Override
    public void select(Event event) {
        Intent intent = new Intent(this, EventDetailActivity.class);
        startActivity(intent);
    }

    private class EventPagerAdapter extends FragmentStatePagerAdapter {
        public EventPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position].toUpperCase();
        }

        @Override
        public Fragment getItem(int position) {
            return EventListFragment.newInstance(null);
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return false;
    }
}
