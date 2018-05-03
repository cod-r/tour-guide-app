package com.example.panea.tourguideapp;import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.panea.tourguideapp.R;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.MyViewHolder> {
    private int mExpandedPosition = -1;
    private List<TheLocation> locationsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView location_name, location_address, location_description;
        public ImageView location_image;

        public MyViewHolder(View view) {
            super(view);
            location_name = (TextView) view.findViewById(R.id.location_name_text_view);
            location_address = (TextView) view.findViewById(R.id.location_address_text_view);
            location_description = (TextView) view.findViewById(R.id.location_description_text_view);
            location_image = (ImageView) view.findViewById(R.id.location_image);
        }
    }


    public LocationAdapter(List<TheLocation> locationsList) {
        this.locationsList = locationsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        TheLocation location = locationsList.get(position);
        holder.location_name.setText(location.getLocationName());
        holder.location_address.setText(location.getLocationAddress());
        holder.location_description.setText(location.getDescription());
        holder.location_image.setImageResource(location.getImageResourceId());

        // Expand the description on item click
        final boolean isExpanded = position==mExpandedPosition;
        holder.location_description.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;

                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }
}