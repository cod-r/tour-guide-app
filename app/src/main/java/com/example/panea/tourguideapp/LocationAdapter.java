package com.example.panea.tourguideapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class LocationAdapter extends ArrayAdapter<TheLocation> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param locations   A List of locations objects to display in a list
     */
    public LocationAdapter(Activity context, ArrayList<TheLocation> locations) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, locations);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @TargetApi(26)
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link TheLocation} object located at this position in the list
        TheLocation currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name_text_view
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name_text_view);
        // Get the location name from the current TheLocation object and
        // set this text on the name TextView
        locationNameTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID location_address_text_view
        TextView locationAddressTextView = (TextView) listItemView.findViewById(R.id.location_address_text_view);
        // Get the location name from the current TheLocation object and
        // set this text on the name TextView
        locationAddressTextView.setText(currentLocation.getLocationAddress());

        // Find the TextView in the list_item.xml layout with the ID description_text_view
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.location_description_text_view);
        // Get the location name from the current TheLocation object and
        // set this text on the name TextView
        descriptionTextView.setText(currentLocation.getDescription());

        descriptionTextView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        // Find the ImageView in the list_item.xml layout with the ID location_image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.location_image);
        // Get the image resource ID from the current TheLocation object and
        // set the image to iconView
        if (currentLocation.hasImage()) {

            iconView.setImageResource(currentLocation.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 3 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
