/*
    *DB object holds both PhotoModel ArrayList and CommentModel.

    *Author Yiğit Can Yılmaz.
    *Written for Nuevo.
---------------------------------------------------------------------

 */


package com.example.nuevotest;

import com.example.nuevotest.Models.CommentModel;
import com.example.nuevotest.Models.PhotoModel;

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
