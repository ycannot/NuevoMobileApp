package com.example.nuevotest;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FirstController {
    PhotoService photoService = new PhotoService();
    CommentService commentService = new CommentService();
    DB db;

    public FirstController() {
        fetchData();

    }

    public void fetchData(){
        //Fetches and saves data from url to db object
        //Uses PhotoService and CommentService to fetch

        try {
            photoService.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            commentService.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        db = new DB(photoService.getPhotomodels(),commentService.getCommentmodels());


    }

    public PhotoModel getPhoto(int id){
        return db.getPhotoModels().get(id);
    }

    public ArrayList<PhotoModel> getPhotoModelArray() {
        return db.getPhotoModels();
    }
    public ArrayList<CommentModel> getCommentModelArray() {
        return db.getCommentModels();
    }

    public CommentModel getComment(int id){
        return db.getCommentModels().get(id);
    }

    public void updateView(){

    }





}
