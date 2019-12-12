/*
    *This class prepare data to view Part.
    *Fetches data by using CommentService class and stores data to new DB class.
    *Specialized for SecondView.

    *Author Yiğit Can Yılmaz.
    *Written for Nuevo.
    ---------------------------------------------------------------------

    */
package com.example.nuevotest.Controllers;

import com.example.nuevotest.Models.CommentModel;
import com.example.nuevotest.Services.CommentService;
import com.example.nuevotest.DB;
import com.example.nuevotest.Models.PhotoModel;
import com.example.nuevotest.Services.PhotoService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SecondController {
    private CommentService commentService = new CommentService();
    private DB db;
    private int position;

    public SecondController() {
        fetchData();

    }

    public void setPosition(int position) {
        this.position = position;
    }

    public SecondController(int position) {
        this.position = position;
        commentService.setId(position);
        fetchData();
    }

    public void fetchData(){
        try {
            commentService.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        db = new DB(null, commentService.getCommentmodels());


    }

    public ArrayList<CommentModel> getCommentModelArray() {
        return db.getCommentModels();
    }

    public CommentModel getComment(){
        return db.getCommentModels().get(0);
    }




}
