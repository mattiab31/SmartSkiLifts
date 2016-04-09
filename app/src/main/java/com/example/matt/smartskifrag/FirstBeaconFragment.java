package com.example.matt.smartskifrag;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Matt on 15/03/2016.
 */
public class FirstBeaconFragment extends Fragment {

    private ImageView imgSlope;
    private ImageView imgMask;
    private int temp;
    private double light;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //get the extra value from main activity
        temp= this.getArguments().getInt("temp");
        light= this.getArguments().getDouble("light");

        View view=inflater.inflate(R.layout.firstbeacon_fragment, container, false);

        //set the image and the value on the screen
        imgSlope= (ImageView)view.findViewById(R.id.imgSlope);
        imgSlope.setImageResource(R.drawable.slope);

        TextView tempView = (TextView)view.findViewById(R.id.textTemp);
        TextView lightView = (TextView)view.findViewById(R.id.textLight);

        tempView.setText("Temperature: "+temp+ " C°");
        lightView.setText("Brightness: "+light+" LUX");

        imgMask = (ImageView) view.findViewById(R.id.imgMask);

        if(light<1){
            imgMask.setImageResource(R.drawable.mask_low);
        }
        else if (light<10){
            imgMask.setImageResource(R.drawable.mask_med);
        }
        else {
            imgMask.setImageResource(R.drawable.mask_high);
        }


        return view;
    }



}
