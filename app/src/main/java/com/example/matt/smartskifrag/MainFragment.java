package com.example.matt.smartskifrag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.Image;
import android.opengl.Matrix;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewFragment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Matt on 15/03/2016.
 */
public class MainFragment extends Fragment {

    public ImageButton button;
    public ImageView img;



    public MainFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment

           final View view= inflater.inflate(R.layout.main_fragment, container, false);
            //final View thumb1View = (View) view.findViewById(R.id.imgSmall);
            //imgMap.setImageResource(R.drawable.skimap);

            button=(ImageButton)view.findViewById(R.id.imgSmall);
            button.setImageResource(R.drawable.skimap);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //img=(ImageView) view.findViewById(R.id.imgBig);
                    //img.setImageResource(R.drawable.slope);
                    //img.setVisibility(View.VISIBLE);
                    button.setImageResource(R.drawable.mapbig);
                    //button.setVisibility(View.INVISIBLE);

                }

            });



            return view;
        }





    }
