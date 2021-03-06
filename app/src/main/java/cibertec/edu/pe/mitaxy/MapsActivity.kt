package cibertec.edu.pe.mitaxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)

        val EstadioNacionalPeru = LatLng(-12.067305, -77.034044)
        mMap.addMarker(MarkerOptions().position(EstadioNacionalPeru).title("Estadio Nacional Perú"))
        
        val CibertecBrena = LatLng(-12.066049, -77.047087)
        mMap.addMarker(MarkerOptions().position(CibertecBrena).title("Cibertec Breña - T5BB"))

        val zoomLevel = 16.0f //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CibertecBrena, zoomLevel))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(EstadioNacionalPeru))

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(EstadioNacionalPeru))
    }
}