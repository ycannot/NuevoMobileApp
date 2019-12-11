package com.example.nuevotest;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoDownloader extends AsyncTask<Void, Void, Void> {
    private String myUrlString;
    private URL myUrl;
    private HttpURLConnection httpURLConnection;
    private InputStream inputStream;
    private Bitmap img;

    public void setMyUrlString(String myUrlString) {
        this.myUrlString = myUrlString;
    }

    public PhotoDownloader(String urlString) {

        this.myUrlString = urlString;
    }

    public Bitmap getImg() {
        return img;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            myUrl = new URL(myUrlString);
            httpURLConnection = (HttpURLConnection) myUrl.openConnection();
            inputStream = httpURLConnection.getInputStream();
            img = BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }

        }

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //imageView.setImageBitmap(img);
        //FirstView.data.setText(this.data);


    }
}
