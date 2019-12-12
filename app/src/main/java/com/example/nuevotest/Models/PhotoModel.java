/*
    **** Photo Model ****
    * * This object is for parsing json array data.

    Json file format:
    {
    "albumId": 1,
    "id": 1,
    "title": "accusamus beatae ad facilis cum similique qui sunt",
    "url": "https://via.placeholder.com/600/92c952",
    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
  },

  *Author Yiğit Can Yılmaz.
  *Written for Nuevo.
---------------------------------------------------------------------
 */



package com.example.nuevotest.Models;

import android.graphics.Bitmap;
import android.util.Log;

public class PhotoModel {
    private String albumId;
    private String id;
    private String title;
    private String url;
    private String thumbnailUrl;


    public PhotoModel(String albumId, String id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public PhotoModel() {
        this.albumId = null;
        this.id = null;
        this.title = null;
        this.url = null;
        this.thumbnailUrl = null;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {

        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "PhotoModel{" +
                "albumId='" + albumId + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}

