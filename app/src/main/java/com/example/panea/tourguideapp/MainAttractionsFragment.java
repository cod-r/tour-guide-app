package com.example.panea.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainAttractionsFragment extends Fragment {

    public MainAttractionsFragment() {
        // Required empty public constructor
    }
    //private List<TheLocation> locationList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LocationAdapter mAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create the RecyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        //Create an array of locations
        final ArrayList<TheLocation> locationList = new ArrayList<TheLocation>();

        locationList.add(new TheLocation(R.string.prague_castle_name, R.string.prague_castle_address,
                R.string.prague_castle_description, R.drawable.prague_castle));
        locationList.add(new TheLocation(R.string.charles_bridge_name, R.string.charles_bridge_address,
                R.string.charles_bridge_description, R.drawable.charles_bridge));
        locationList.add(new TheLocation(R.string.old_town_name, R.string.old_town_address,
                R.string.old_town_description, R.drawable.old_town));
        locationList.add(new TheLocation(R.string.vitus_cathedral_name, R.string.vitus_cathedral_address,
                R.string.vitus_cathedral_description, R.drawable.vitus_cathedral));

        // Create an {@link ArrayAdapter}, whose data source is list_item.xml
        mAdapter = new LocationAdapter(locationList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list layout file.
        //ListView listView = (ListView) rootView.findViewById(R.id.list);


        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each location in the list of locations.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
