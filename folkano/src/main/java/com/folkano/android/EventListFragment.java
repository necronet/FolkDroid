package com.folkano.android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EventListFragment extends Fragment {

    ListView list;
    EventListCallback listener;
    EventAdapter mAdapter;

    public static EventListFragment newInstance(Bundle extras) {
        EventListFragment fragment = new EventListFragment();
        if (extras != null) {
            fragment.setArguments(extras);
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_event_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = (ListView)view.findViewById(R.id.list);

        List<Event> events = new ArrayList<Event>();
        events.add(new Event(1l, "Title 1", "Subtitle 2", null, null));
        events.add(new Event(2l, "Title 1", "Subtitle 2", null, null));
        events.add(new Event(3l, "Title 1", "Subtitle 2", null, null));

        mAdapter = new EventAdapter(events);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getListener().select(mAdapter.getItem(position));
            }
        });
    }

    public EventListCallback getListener() {
        if (listener == null)
            listener = (EventListCallback)getActivity();

        return listener;
    }


    @Override
    public void onPause() {
        listener = null;
        super.onPause();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    class EventAdapter extends BaseAdapter {

        List<Event> mEvents;

        public EventAdapter(List<Event> events) {
            mEvents = events;
        }

        @Override
        public int getCount() {
            return mEvents.size();
        }

        @Override
        public Event getItem(int position) {
            return mEvents.get(position);
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.event_row, parent, false);
            }



            return convertView;
        }
    }

    public interface EventListCallback {
        public void select(Event event);
    }
}
