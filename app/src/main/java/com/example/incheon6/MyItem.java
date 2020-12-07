package com.example.incheon6;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class MyItem implements ClusterItem {
    private final LatLng mPosition;
    private final String mTitle;

    public MyItem(double lat, double lon, String title) {
        mPosition = new LatLng(lat, lon);
        mTitle = title;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public String getTitle() {
        return mTitle;
    }


    public String getSnippet() {
        return null;
    }

}
