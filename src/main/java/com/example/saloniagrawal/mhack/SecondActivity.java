package com.example.saloniagrawal.mhack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "SALONI";
    ImageView im = (ImageView) findViewById(R.id.imageView);;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Intent intent = getIntent();
        //Uri abc = intent.getData();
        Log.i(TAG, "bleh");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), abc);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
      //  im.setImageURI(abc);

    }

}
