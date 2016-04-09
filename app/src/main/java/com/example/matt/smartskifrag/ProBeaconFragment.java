package com.example.matt.smartskifrag;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Matt on 17/03/2016.
 */
public class ProBeaconFragment extends Fragment {
    private ImageView scattoV;
    private int CAMERA_APP_REQ_CODE=100;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.probeacon_fragment, container, false);

        scattoV = (ImageView) view.findViewById(R.id.scatto);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, CAMERA_APP_REQ_CODE);
        }





        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //controllo se il requestCode coincide con quello specificato
        //quando abbiamo lanciato l'intent
        if(requestCode == CAMERA_APP_REQ_CODE ) {

            //recupero i dati dall'intent
            Bundle extras = data.getExtras();
            //e ci creo un oggetto Bitmap
            Bitmap capturedImage = (Bitmap) extras.get("data");
            //infine, imposto l'attributo src di in ImageView
            //con la Bitmap appena creata
            //scattoV = (ImageView)getView().findViewById(R.id.scatto);
            scattoV.setImageBitmap(capturedImage);
        }
    }
}
