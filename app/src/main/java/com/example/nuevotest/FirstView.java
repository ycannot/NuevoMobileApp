package com.example.nuevotest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;



public class FirstView extends AppCompatActivity {

    ListView listView;
    FirstController c = new FirstController();
    ArrayList<PhotoModel> photos = c.getPhotoModelArray();
    //PhotoAdapter adapter = new PhotoAdapter(this, photos) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        listView = (ListView) findViewById(R.id.listView1);
        //Log.i("ycy1", c.getPhotoModelArray().toString());



        PhotoAdapter photoAdapter= new PhotoAdapter(FirstView.this,photos);
        listView.setAdapter(photoAdapter);

    }


}
