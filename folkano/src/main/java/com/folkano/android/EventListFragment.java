package com.folkano.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class EventListFragment extends Fragment {

    ListView list;

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

        Event event = new Event();
        event.address = "Somewhere around";
        event.title = "Concert title";

        List<Event> events = new ArrayList<Event>();
        events.add(event);

        EventAdapter adapter = new EventAdapter(events);
        list.setAdapter(adapter);
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
}
