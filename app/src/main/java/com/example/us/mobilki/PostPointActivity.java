package com.example.us.mobilki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PostPointActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_point);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map3);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map=googleMap;

        map.addMarker(new MarkerOptions()
                .position(new LatLng(53.130000, 23.129806))
                .title("InPost1")
                .snippet("ul.Bema 12, Białystok")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pushpin)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(53.119670, 23.170000))
                .title("InPost2")
                .snippet("ul.Lipowa 12, Białystok")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green)));

        map.addMarker(new MarkerOptions()
                .position(new LatLng(53.118250, 23.149806))
                .title("InPost3")
                .snippet("ul.Wiejska 12, Białystok")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue)));
    }
}
