/*
    *This class is for fetching and parsing json array data from webservice.
    * Converts json array to PhotoModel ArrayList.

    *Author Yiğit Can Yılmaz.
    *Writed for Nuevo.
---------------------------------------------------------------------

 */

package com.example.nuevotest.Services;


import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.example.nuevotest.Models.PhotoModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PhotoService extends AsyncTask<Void, Void, Void> {
    private String myUrlString = "https://jsonplaceholder.typicode.com/photos?albumId=1&albumId=2";
    private URL myUrl;
    private HttpURLConnection httpURLConnection;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private String data="";
    private JSONArray jsonArray;
    public ArrayList<PhotoModel> photomodels = new ArrayList<>();
    private JSONObject jsonObject;
    private Bitmap thumbPhoto;
    private Bitmap coverPhoto;
    private Gson gson = new Gson();

    public void setId(int position){
        myUrlString+="?id="+String.valueOf(position);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            myUrl = new URL(myUrlString);
            httpURLConnection = (HttpURLConnection) myUrl.openConnection();
            inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line="";
            while (line!=null){
                line = bufferedReader.readLine();
                if (line!=null){
                    data=data+line;
                }
            }
            jsonArray= new JSONArray(data);
            for (int i=0; i<jsonArray.length(); i++){
                jsonObject = (JSONObject) jsonArray.get(i);
                photomodels.add(gson.fromJson(jsonObject.toString(),PhotoModel.class));
                photomodels.get(i).toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public ArrayList<PhotoModel> getPhotomodels() {

        return photomodels;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //FirstView.data.setText(this.data);


    }
}
