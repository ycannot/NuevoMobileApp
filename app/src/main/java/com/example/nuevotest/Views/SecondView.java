package com.example.nuevotest.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nuevotest.Controllers.SecondController;
import com.example.nuevotest.R;
import com.squareup.picasso.Picasso;

public class SecondView extends AppCompatActivity {
    Intent intent;
    int position;
    String photoUrl;
    String photoTitle;
    SecondController c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);
        intent = getIntent();
        photoUrl = intent.getStringExtra("photoUrl");
        photoTitle = intent.getStringExtra("photoTitle");
        position = intent.getIntExtra("position",0);
        Log.i("clickedItems", "Clicked: "+position+" "+photoUrl);

        ImageView photo = (ImageView) findViewById(R.id.secondImageView) ;
        TextView title = (TextView) findViewById(R.id.secondViewTitle);
        TextView name = (TextView) findViewById(R.id.secondViewName);
        TextView email = (TextView) findViewById(R.id.secondViewEmail);
        TextView body = (TextView) findViewById(R.id.secondViewBody);
        Button backButton = (Button) findViewById(R.id.backButton);
        c = new SecondController(position);
        title.setText(photoTitle);
        name.setText(c.getComment().getName());
        email.setText(c.getComment().getEmail());
        body.setText(c.getComment().getBody());
        Picasso.get().load(photoUrl).into(photo);


    }

    public void goBack(View view) {
        finish();
    }
}
