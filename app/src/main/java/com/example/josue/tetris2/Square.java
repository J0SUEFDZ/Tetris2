package com.example.josue.tetris2;
import android.widget.ImageView;
/**
 * Created by Josue on 09/03/2018.
 */

public class Square {
    public  ImageView imagen;
    public int id;


    public Square(ImageView imagen, int id) {
        this.imagen = imagen;
        this.id = id;
    }
}
