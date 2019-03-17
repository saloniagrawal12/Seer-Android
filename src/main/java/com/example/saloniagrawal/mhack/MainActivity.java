package com.example.saloniagrawal.mhack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "SALONI";
    private static final int REQUEST_SELECT_IMAGE = 1;
    //private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        handler = new Handler((Handler.Callback) this);

        /*classifier = TensorFlowImageClassifier.create(
                assets, MODEL_FILE, LABEL_FILE, INPUT_WIDTH, INPUT_HEIGHT,
                IMAGE_MEAN, IMAGE_STD, INPUT_NAME, OUTPUT_NAME)*/

    }

   public void handleCameraIconClick(View v) {
       Log.i(TAG, "handleOnCameraIconClicked");
       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       if (intent.resolveActivity(getPackageManager()) != null) {

               startActivityForResult(intent, RequestCodes.TAKE_PICTURE);
       }

       else {
           Log.e(TAG, "No Activity available to handle camera photo");
       }


   }

    private void handleCameraPictureTaken(int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            Log.e(TAG, "Camera did not produce data - aborting");
        }
        Log.i(TAG, "Received image uri data from the camera");
    }


    public void selectImage(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        //Log.i(TAG,"call");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Uri imageUri = data.getData();


        switch (requestCode) {
            case RequestCodes.TAKE_PICTURE:
                Log.i(TAG, "handle");

               /* try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                handleCameraPictureTaken(resultCode, data);
                break;

            case REQUEST_SELECT_IMAGE:

                if (resultCode == RESULT_OK) {
                    Uri imageUri = data.getData();
                    //String stringUri;
                    //stringUri = imageUri.toString();
                    //Log.i(TAG, stringUri);
                    //FileUploadUtility.doFileUpload(stringUri, handler);
                    Log.i(TAG, "bleh2");
                    Intent intent = new Intent();
                    //intent.setData(imageUri);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                Log.i(TAG, "bleh3");
                Intent intent = new Intent(this, SecondActivity.class);
                //intent.setData(imageUri);
                startActivity(intent);
                break;
        }



    }

}



