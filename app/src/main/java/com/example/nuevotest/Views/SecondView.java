/*
    *This SecondView class takes clicked item's photoUrl, photoTitle data as String by using intent
    *Also takes String data of previous item and next item by using intent

    *Author Yiğit Can Yılmaz.
    *Writed for Nuevo.
-----------------------------------------------------------------------
 */

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class SecondView extends AppCompatActivity {
    private Intent intent;
    private int position;
    private String photoUrl;
    private String photoTitle;
    private SecondController c;
    private String prev;
    private String next;
    private String prevTitle;
    private String nextTitle;
    private Boolean canPrev=true;
    private Boolean canNext=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);
        intent = getIntent();
        photoUrl = intent.getStringExtra("photoUrl");
        photoTitle = intent.getStringExtra("photoTitle");
        position = intent.getIntExtra("position",0);
        prev = intent.getStringExtra("prev");
        next = intent.getStringExtra("next");
        prevTitle = intent.getStringExtra("prevTitle");
        nextTitle = intent.getStringExtra("nextTitle");
        Log.i("clickedItems", "Clicked: "+position+" "+photoUrl);

        final ImageView photo = (ImageView) findViewById(R.id.secondImageView) ;
        final TextView title = (TextView) findViewById(R.id.secondViewTitle);
        final TextView name = (TextView) findViewById(R.id.secondViewName);
        final TextView email = (TextView) findViewById(R.id.secondViewEmail);
        final TextView body = (TextView) findViewById(R.id.secondViewBody);
        Button backButton = (Button) findViewById(R.id.backButton);
        final FloatingActionButton prevButton = findViewById(R.id.prevButton);
        final FloatingActionButton nextButton = findViewById(R.id.nextButton);
        c = new SecondController(position);

        title.setText(photoTitle);
        name.setText(c.getComment().getName());
        email.setText(c.getComment().getEmail());
        body.setText(c.getComment().getBody());
        Picasso.get().load(photoUrl).into(photo);

        //NEXT 2 OnClickListener IS FOR PREV AND NEXT BUTTONS
        //THESE BUTTON HELPS TO DISPLAY ONE PREVIOUS AND ONE NEXT ITEM OF THE FIRSTVIEW'S LISTVIEW
        //YOU CAN ONLY DISPLAY ONE PREVIOUS AND ONE NEXT ITEM OF ITEM THAT YOU CLICKED IN LISTVİEW
        //PREV-NEXT BUTTON CODE STARTS FROM HERE: ****************************************************
        prevButton.setOnClickListener(
                new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       //checks whether previous item is displaying now or not
                       if (canNext==false && title.getText()!=photoTitle){
                           title.setText(photoTitle);
                           name.setText(c.getComment().getName());
                           email.setText(c.getComment().getEmail());
                           body.setText(c.getComment().getBody());
                           Picasso.get().load(photoUrl).into(photo);
                           canPrev=true;
                       }

                       //checks is it posible to display previous item
                       else if (canPrev!=false) {
                           if (prev!=null){
                               c = new SecondController(position-1);
                               title.setText(prevTitle);
                               Picasso.get().load(prev).into(photo);
                               name.setText(c.getComment().getName());
                               email.setText(c.getComment().getEmail());
                               body.setText(c.getComment().getBody());
                           }

                           canPrev=false;
                           canNext=true;
                           //prevTitle=null;
                           nextButton.setClickable(true);
                           prevButton.setClickable(false);
                       }

                   }
                }
        );

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    //checks whether next item is displaying now or not
                    public void onClick(View v) {
                        if (canPrev==false && title.getText()!=photoTitle){
                            title.setText(photoTitle);
                            name.setText(c.getComment().getName());
                            email.setText(c.getComment().getEmail());
                            body.setText(c.getComment().getBody());
                            Picasso.get().load(photoUrl).into(photo);
                            canNext=true;
                        }

                        //checks is it posible to display next item
                        else if (canNext!=false) {
                            if (next!=null){
                                c = new SecondController(position+1);
                                title.setText(nextTitle);
                                name.setText(c.getComment().getName());
                                email.setText(c.getComment().getEmail());
                                body.setText(c.getComment().getBody());
                                Picasso.get().load(next).into(photo);

                            }
                            canNext=false;
                            canPrev=true;
                            //prevTitle=null;
                            nextButton.setClickable(false);
                            prevButton.setClickable(true);
                        }

                    }
                }
        );

        //PREV-NEXT BUTTON CODE ENDS HERE. *****************************************************************

    }

    public void goBack(View view) {
        finish();
    }

    public void goPrev(View view) {
        if (this.prev!=null){

        }
    }
}
