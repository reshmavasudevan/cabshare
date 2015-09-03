package com.example.admin.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import android.os.Bundle;
import android.app.Activity;
import android.location.Geocoder;
import java.util.Locale;
import java.util.List;
import android.location.Address;
import android.widget.TextView;
import android.content.Intent;

public class MapActivity extends Activity {
    private GoogleMap googleMap;
    TextView tv;
    String str;
    public double latitude;
    public double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle bundle = getIntent().getExtras();
        String str= bundle.getString("msg");
        tv   = (TextView)findViewById(R.id.textView2);
        tv.setText("String is"+str);



        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses;
            addresses = geocoder.getFromLocationName(str, 1);
            if (addresses.size() > 0) {
                latitude = addresses.get(0).getLatitude();
                longitude = addresses.get(0).getLongitude();
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("locationName == null");
        }


        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            googleMap.setTrafficEnabled(true);
            Marker myMarker = googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title("Hello world"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myMarker.getPosition(),14));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
