package com.proyecto.centest;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocalizacionActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button botonOviedo;
    private Button botonGijon;
    private Button botonAviles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        botonOviedo = (Button) findViewById(R.id.botonOviedo);
        botonGijon = (Button) findViewById(R.id.botonGijon);
        botonAviles = (Button) findViewById(R.id.botonAviles);

        botonOviedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng oviedo = new LatLng(43.364190, -5.845291);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oviedo,7));
            }
        });

        botonGijon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng gijon = new LatLng(43.364190, -5.845291);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gijon,7));
            }
        });

        botonAviles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng aviles = new LatLng(43.364190, -5.845291);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aviles,7));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        LatLng oviedo1 = new LatLng(43.364190, -5.845291);
        LatLng oviedo2 = new LatLng(43.368232, -5.875271);
        LatLng oviedo3 = new LatLng(43.370273 , -5.832376);

        mMap.addMarker(new MarkerOptions().position(oviedo1).title("El Vasco").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(oviedo2).title("La Florida").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(oviedo3).title("Santullano").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        LatLng gijon1 = new LatLng(43.527005, -5.663828);
        LatLng gijon2 = new LatLng(43.536391, -5.665824);
        LatLng gijon3 = new LatLng(43.536356, -5.660700);

        mMap.addMarker(new MarkerOptions().position(gijon1).title("El Llano").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.addMarker(new MarkerOptions().position(gijon2).title("Ceuias").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.addMarker(new MarkerOptions().position(gijon3).title("Praxis").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng aviles1 = new LatLng(43.554647, -5.919220);
        LatLng aviles2= new LatLng(43.554491, -5.923472);

        mMap.addMarker(new MarkerOptions().position(aviles1).title("Conde del Real Agrado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mMap.addMarker(new MarkerOptions().position(aviles2).title("Biblioteca municipal de Avilés").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
    }
}