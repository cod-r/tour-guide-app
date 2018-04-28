package com.example.panea.tourguideapp;

/**
 * {@link TheLocation} represents a location that the user wants to visit.
 * It contains the name, adress and a short description about location.
 * Optionally it contains an image of the location
 * It is called like that to not be mistaken by Location class
 */
public class TheLocation {

    /**
     * Name of the location
     */
    private int mLocationName;

    /**
     * Address of the location
     */
    private int mLocationAddress;

    /**
     * Short description about the location
     */
    private int mDescription;

    /**
     * Used for storing the image resource ID
     */
    private int mImageResourceID = NO_IMAGE_PROVIDED;


    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new TheLocation object.
     *
     * @param locationName is the name of the location the user wants to visit
     * @param locationAddress   is the address of the location the user wants to visit
     * @param description is a short description about the location
     * @param imageResourceId is a picture of the location
     */

    public TheLocation(int locationName, int locationAddress, int description, int imageResourceId) {
        mLocationName = locationName;
        mLocationAddress = locationAddress;
        mDescription = description;
        mImageResourceID = imageResourceId;

    }

    //Constructor for location without image
    public TheLocation(int locationName, int locationAddress, int description) {
        mLocationName = locationName;
        mLocationAddress = locationAddress;
        mDescription = description;

    }


    /**
     * Get the location name
     */
    public int getLocationName() {
        return mLocationName;
    }

    /**
     * Get the location address
     */
    public int getLocationAddress() {
        return mLocationAddress;
    }

    /**
     * Get the location description
     */
    public int getDescription() {
        return mDescription;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceID;
    }

    /**
     * Checks whether or not there is an image for this word
     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

}
