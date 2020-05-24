package com.charity.bloodbank.view.activity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


import com.charity.bloodbank.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.charity.bloodbank.data.local.SharedPreferencesManger.LoadData;
import static com.charity.bloodbank.data.local.SharedPreferencesManger.SaveData;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @BindView(R.id.map_activity_set_location)
    Button mapActivitySetLocation;
    private GoogleMap mMap;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().title("my place").position(latLng));
                longitude = latLng.longitude;
                latitude = latLng.latitude;


            }
        });


    }

    @OnClick(R.id.map_activity_set_location)
    public void onViewClicked() {
        try {
            getLocation(latitude,longitude);
        }catch (Exception e){
            e.printStackTrace();
        }
        finish();
    }

    private void getLocation(double latitude, double longitude) throws IOException {
        Geocoder geocoder = new Geocoder(MapsActivity.this, Locale.getDefault());
        if (geocoder.isPresent()) {
            List<Address> addressList = geocoder.getFromLocation(latitude,longitude,1);
            Address address = addressList.get(0);
            String loc=address.getAddressLine(0);
            Toast.makeText(this, loc, Toast.LENGTH_SHORT).show();
            SaveData(MapsActivity.this,"LOCATION",loc);
            Toast.makeText(this, LoadData(this,"LOCATION"), Toast.LENGTH_SHORT).show();

            SaveData(MapsActivity.this,"LATITUDE",latitude);
            SaveData(MapsActivity.this,"LONGITUDE",longitude);


        }
    }
}
