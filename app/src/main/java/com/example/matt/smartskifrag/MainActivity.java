package com.example.matt.smartskifrag;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.sensoro.beacon.kit.Beacon;
import com.sensoro.beacon.kit.BeaconManagerListener;
import com.sensoro.cloud.SensoroManager;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    Fragment fr;
    FragmentManager fm;
    private int temp;
    private double light;
    Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr = new MainFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fr);
        fragmentTransaction.commit();

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());


        SensoroManager sensoroManager = SensoroManager.getInstance(getApplicationContext());

        //Check whether the Bluetooth is on

        if (sensoroManager.isBluetoothEnabled()) {

            //Enable cloud service (upload sensor data, including battery status, UMM, etc.)。Without setup, it keeps in closed status as default.
            sensoroManager.setCloudServiceEnable(true);

            //Enable SDK service
            try {
                sensoroManager.startService();
            }
            catch (Exception e) {
                e.printStackTrace(); // Fetch abnormal info
            }
        }
        else{
            Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(bluetoothIntent, RESULT_OK);//REQUEST_ENABLE_BT
        }

        BeaconManagerListener beaconManagerListener = new BeaconManagerListener() {

            @Override
            public void onUpdateBeacon(ArrayList<Beacon> beacons) {
                // Refresh sensor info
            }

            @Override
            public void onNewBeacon(Beacon beacon) {
                if (beacon.getSerialNumber().equals("0117C53F7D4C")){
                    // Yunzi with SN "0117C53F7D4C" enters the range

                    temp=beacon.getTemperature();
                    light=beacon.getLight();
                    Bundle bundle=new Bundle();
                    bundle.putInt("temp",temp);
                    bundle.putDouble("light",light);


                    fr = new FirstBeaconFragment();
                    fr.setArguments(bundle);

                    fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fr);
                    fragmentTransaction.commit();
                }
                if (beacon.getSerialNumber().equals("0117C5578442")){
                    // Yunzi with SN "0117C5456A36" enters the range
                    fr = new SecondBeaconFragment();
                    fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fr);
                    fragmentTransaction.commit();
                }

                if (beacon.getSerialNumber().equals("0117C59B4EC7")){
                    fr = new ProBeaconFragment();
                    fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fr);
                    fragmentTransaction.commit();
                }
                

            }

            @Override
            public void onGoneBeacon(Beacon beacon) {
                    Fragment fr = new MainFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fr);
                    fragmentTransaction.commit();
                }

            }
        };
        sensoroManager.setBeaconManagerListener(beaconManagerListener);

    }







}
