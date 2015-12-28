package nbii.na.edu.busapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewBusStopsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private Double latitude = 0.0;
    private Double longitude = 0.0;

    static final String TAG = "BusApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bus_stops);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if(checkPlayServices()){

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }else{
            Toast.makeText(getApplicationContext(), "This device is not supported", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng B1 = new LatLng(-22.53233268, 17.04952635);
        LatLng B2 = new LatLng(-22.53233268, 17.04952635);
        LatLng B3 = new LatLng(-22.527984619140625, 17.053117752075195);
        LatLng B4 = new LatLng(-22.53233268, 17.04952635);
        LatLng B5 = new LatLng(-22.314266204833984, 17.023405075073242);
        LatLng B6 = new LatLng(-22.524642944335938, 17.040145874023438);
        LatLng B7 = new LatLng(-22.517393112182617, 17.04051399230957);
        LatLng B8 = new LatLng(-22.514413833618164, 17.04323387145996);
        LatLng B9 = new LatLng(-22.515127182006836, 17.052745819091797);
        LatLng B12 = new LatLng(-22.52018082, 17.06271082);
        LatLng B14 = new LatLng(-22.52295221, 17.05579);
        LatLng B15 = new LatLng(-22.52600274, 17.05453216);
        LatLng B16 = new LatLng(-22.53233268, 17.04952635);
        LatLng B17 = new LatLng(-22.53368331, 17.06628985);
        LatLng B18 = new LatLng(-22.52789912, 17.05629283);
        LatLng B19 = new LatLng(-22.52652169, 17.04810573);
        LatLng B20 = new LatLng(-22.52210988, 17.03758658);
        LatLng B38 = new LatLng(-22.54337011, 17.03453975);
        LatLng B47 = new LatLng(-22.57762163, 17.04837952);
        LatLng B49 = new LatLng(-22.53233268, 17.04952635);
        LatLng B64 = new LatLng(-22.60725863, 17.06908581);
        LatLng B67 = new LatLng(-22.61358161, 17.06009536);
        LatLng B124 = new LatLng(-22.5667843, 17.08695917);
        LatLng B125 = new LatLng(-22.571897506713867, 17.088489532470703);
        LatLng B126 = new LatLng(-22.577430725097656, 17.0915470123291);
        LatLng B127 = new LatLng(-22.581628799438477, 17.092727661132812);
        LatLng B131 = new LatLng(-22.5667973, 17.10174627);
        LatLng B132 = new LatLng(-22.5617628, 17.09813455);
        LatLng B135 = new LatLng(-22.54549719, 17.07521193);
        LatLng B137 = new LatLng(-22.569366455078125, 17.0822696685791);
        LatLng B141 = new LatLng(-22.57950439, 17.08178963);
        LatLng B142 = new LatLng(-22.57576153, 17.0810247);
        LatLng B143 = new LatLng(-22.564250946044922, 17.080936431884766);
        LatLng B144 = new LatLng(-22.53233268, 17.04952635);
        LatLng B145 = new LatLng(-22.53233268, 17.04952635);
        LatLng B146 = new LatLng(-22.53233268, 17.04952635);
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(B126));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(-22.577430725097656, 17.0915470123291)).zoom(15).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        mMap.addMarker(new MarkerOptions()
                .title("B3")
                .snippet("Herero Bus Stop")
                .position(B3)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B4")
                .snippet("Single Quarters Engine Service Bus Stop")
                .position(B4)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B5")
                .snippet("CNN (Council of Churches)")
                .position(B5)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B6")
                .snippet("Otjikaendu Bus stop")
                .position(B6)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B7")
                .snippet("Wanaheda Bus Stop")
                .position(B7)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B8")
                .snippet("A Shipena Bus Stop")
                .position(B8)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B9")
                .snippet("Golgota 13 Bus Stop")
                .position(B9)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B12")
                .snippet("Geemende Bus Stop")
                .position(B12)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B14")
                .snippet("Damara  Bus Stop")
                .position(B14)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B15")
                .snippet("Miami Service Bus Stop")
                .position(B15)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B16")
                .snippet("Swapo headquarters Bus Stop")
                .position(B16)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B17")
                .snippet("Katutura Hospital Bus Stop")
                .position(B17)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B18")
                .snippet("Miami Service (Right) Bus Stop")
                .position(B18)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B19")
                .snippet("Yetu Yama Bus Stop")
                .position(B19)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B20")
                .snippet("John ya Otto Soccer field Bus Stop")
                .position(B20)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B38")
                .snippet("Ramatex (Khomasdal) Bus Stop")
                .position(B38)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B47")
                .snippet("Ramatex (Otjomuise) Bus Stop")
                .position(B47)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B49")
                .snippet("Rocky Crest Bus Stop")
                .position(B49)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B64")
                .snippet("Academia Bus Stop")
                .position(B64)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B67")
                .snippet("Unam Bus Stop")
                .position(B67)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B124")
                .snippet("Parliament Bus Stop")
                .position(B124)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B125")
                .snippet("WHS Bus Stop")
                .position(B125)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B126")
                .snippet("Michelle Mclean Bus Stop")
                .position(B126)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B127")
                .snippet("Marua mall Bus Stop")
                .position(B127)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));


        mMap.addMarker(new MarkerOptions()
                .title("B131")
                .snippet("KW1 Bus Stop")
                .position(B131)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B135")
                .snippet("KW2 Bus Stop")
                .position(B132)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B135")
                .snippet("Rhino park Bus Stop")
                .position(B135)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B137")
                .snippet("KFC Bus Stop")
                .position(B137)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B141")
                .snippet("Air Namibia Bus Stop")
                .position(B141)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B142")
                .snippet("Nandos (Southern Industrial area) Bus Stop")
                .position(B142)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B143")
                .snippet("Werhnill Bus Stop")
                .position(B143)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B144")
                .snippet("Roman Catholic Hospital Bus Stop")
                .position(B144)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B145")
                .snippet("Single Quarters Engine Service Bus Stop")
                .position(B145)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

        mMap.addMarker(new MarkerOptions()
                .title("B146")
                .snippet("Single Quarters Engine Service Bus Stop")
                .position(B146)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_stop)));

    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                                    // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
