package com.example.nuevotest;

import android.util.Log;

import java.util.ArrayList;

public class DB {
    private ArrayList<PhotoModel> photoModels = null;
    private ArrayList<CommentModel> commentModels = null;

    public DB(ArrayList<PhotoModel> photoModels, ArrayList<CommentModel> commentModels) {
        this.photoModels = photoModels;
        this.commentModels = commentModels;
    }

    public ArrayList<PhotoModel> getPhotoModels() {
        return photoModels;
    }

    public void setPhotoModels(ArrayList<PhotoModel> photoModels) {
        this.photoModels = photoModels;
    }

    public ArrayList<CommentModel> getCommentModels() {
        return commentModels;
    }

    public void setCommentModels(ArrayList<CommentModel> commentModels) {
        this.commentModels = commentModels;
    }
}
