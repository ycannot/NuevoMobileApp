package com.example.nuevotest.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nuevotest.Controllers.FirstController;
import com.example.nuevotest.PhotoAdapter;
import com.example.nuevotest.Models.PhotoModel;
import com.example.nuevotest.R;

import java.util.ArrayList;



public class FirstView extends AppCompatActivity {

    ListView listView;
    FirstController c = new FirstController();
    ArrayList<PhotoModel> photos = c.getPhotoModelArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

        PhotoAdapter photoAdapter= new PhotoAdapter(FirstView.this,photos);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(photoAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // controller'a position gönderecek

                Intent intent = new Intent(FirstView.this, SecondView.class);
                intent.putExtra("photoUrl", photos.get(position).getUrl());
                intent.putExtra("position",position+1); //enumerator id of data starts from 1 thats why 1 added to position
                intent.putExtra("photoTitle",photos.get(position).getTitle());
                startActivity(intent);

            }
        });
    }


}
