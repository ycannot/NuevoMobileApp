package com.example.nuevotest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PhotoAdapter extends ArrayAdapter<PhotoModel> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<PhotoModel> photos;


    public PhotoAdapter(Context context, ArrayList<PhotoModel> photos) {
        super(context, 0, photos);
        this.context = context;
        this.photos = photos;
        inflater=LayoutInflater.from(context);
    }

    public int getCount() {
        return photos.size();
    }

    @Override
    public PhotoModel getItem(int position) {
        return photos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photos.get(position).hashCode();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (position==0){
            convertView =inflater.inflate(R.layout.cover,null);
            TextView title = (TextView) convertView.findViewById(R.id.coverTitle) ;
            ImageView photo = (ImageView) convertView.findViewById(R.id.coverPhoto) ;

            photo.setImageBitmap(photos.get(position).getCoverBitmap());
            title.setText(photos.get(position).getTitle());
        }
        else{
            convertView =inflater.inflate(R.layout.line,null);
            TextView title = (TextView) convertView.findViewById(R.id.photoTitle) ;
            ImageView photo = (ImageView) convertView.findViewById(R.id.photo) ;

            photo.setImageBitmap(photos.get(position).getThumbnailBitmap());
            title.setText(photos.get(position).getTitle());
        }

        return convertView;
    }
}