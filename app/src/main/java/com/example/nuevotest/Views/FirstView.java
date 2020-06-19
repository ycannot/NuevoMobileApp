package com.example.nuevotest.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nuevotest.BuildConfig;
import com.example.nuevotest.Controllers.FirstController;
import com.example.nuevotest.PhotoAdapter;
import com.example.nuevotest.Models.PhotoModel;
import com.example.nuevotest.R;

import java.util.ArrayList;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;



public class FirstView extends AppCompatActivity {

    private ListView listView;
    private FirstController c = new FirstController();
    private ArrayList<PhotoModel> photos = c.getPhotoModelArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        AppCenter.start(getApplication(),BuildConfig.APPCENTER_APP_SECRET, Analytics.class, Crashes.class);
        PhotoAdapter photoAdapter= new PhotoAdapter(FirstView.this,photos);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(photoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstView.this, SecondView.class);
                ArrayList<String> prevnext=getPrevNext(position);
                Analytics.trackEvent("Photo "+photos.get(position).getUrl()+" clicked.");
                intent.putExtra("photoUrl", photos.get(position).getUrl());
                intent.putExtra("position",position+1); //enumerator id of data starts from 1 thats why 1 added to position
                intent.putExtra("prev",prevnext.get(0));
                intent.putExtra("next",prevnext.get(1));
                intent.putExtra("prevTitle",prevnext.get(2));
                intent.putExtra("nextTitle",prevnext.get(3));
                intent.putExtra("photoTitle",photos.get(position).getTitle());
                startActivity(intent);

            }
        });
    }

    public ArrayList<String> getPrevNext(int position){
        //returs ArrayList<String> item that is {previous photo url, next photo url, previous photo title, next photo title}

        String prev=null;
        String prevTitle=null;
        String next=null;
        String nextTitle=null;


        if (position>0){ prev=c.getPhotoModelArray().get(position-1).getUrl(); prevTitle=c.getPhotoModelArray().get(position-1).getTitle();}
        if (position<c.getPhotoModelArray().size()-1){ next=c.getPhotoModelArray().get(position+1).getUrl();nextTitle=c.getPhotoModelArray().get(position+1).getTitle();}


        ArrayList<String> output = new ArrayList<String>();
        output.add(prev);
        output.add(next);
        output.add(prevTitle);
        output.add(nextTitle);
        return output;
    }


}
