/*
    *This class prepare data to view Part.
    *Fetches data by using PhotoService class and stores data to new DB class.
    *Specialized for FirstView.

    *Author Yiğit Can Yılmaz.
    *Writed for Nuevo.
------------------------------------------------------------------------

 */

package com.example.nuevotest.Controllers;

import com.example.nuevotest.Models.CommentModel;
import com.example.nuevotest.DB;
import com.example.nuevotest.Models.PhotoModel;
import com.example.nuevotest.Services.PhotoService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class FirstController {
    private PhotoService photoService = new PhotoService();
    private DB db;

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


        db = new DB(photoService.getPhotomodels(),new ArrayList<CommentModel>());


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




}
