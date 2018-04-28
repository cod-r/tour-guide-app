package com.example.panea.tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainAttractionsFragment extends Fragment {

    public MainAttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an array of locations
        final ArrayList<TheLocation> locations = new ArrayList<TheLocation>();

        locations.add(new TheLocation(R.string.prague_castle_name, R.string.prague_castle_address,
                R.string.prague_castle_description, R.drawable.prague_castle));
        locations.add(new TheLocation(R.string.charles_bridge_name, R.string.charles_bridge_address,
                R.string.charles_bridge_description, R.drawable.charles_bridge));
        locations.add(new TheLocation(R.string.old_town_name, R.string.old_town_address,
                R.string.old_town_description, R.drawable.old_town));
        locations.add(new TheLocation(R.string.vitus_cathedral_name, R.string.vitus_cathedral_address,
                R.string.vitus_cathedral_description, R.drawable.vitus_cathedral));

        // Create an {@link ArrayAdapter}, whose data source is list_item.xml
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);


        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each location in the list of locations.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }

}
