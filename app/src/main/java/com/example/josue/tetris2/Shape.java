package com.example.josue.tetris2;
import java.util.Random;

/**
 * Created by Josue on 10/03/2018.
 */

public class Shape {
    public Square s1;
    public Square s2;
    public Square s3;
    public Square s4;
    public int pos; //posicion de rotacion 0-3
    public int id; //id de figura, son 7 efectos de rotacion

    public Shape(Square s1, Square s2, Square s3, Square s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s1.imagen.setY(0);
        this.s1.imagen.setX(0);
        this.s2.imagen.setY(0);
        this.s2.imagen.setX(0);
        this.s3.imagen.setY(0);
        this.s3.imagen.setX(0);
        this.s4.imagen.setY(0);
        this.s4.imagen.setX(0);
        this.pos = 0;
    }

    public void turn() {
        switch(id){
            case 0:
                switch (pos){
                    case 0:
                        s1.imagen.setY(s1.imagen.getY()-70f*2);
                        s1.imagen.setX(s1.imagen.getX()+70f*2);
                        s2.imagen.setY(s2.imagen.getY()-70f);
                        s2.imagen.setX(s2.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos++;
                        break;
                    case 1:
                        s1.imagen.setY(s1.imagen.getY()+70f*2);
                        s1.imagen.setX(s1.imagen.getX()+70f*2);
                        s2.imagen.setY(s2.imagen.getY()+70f);
                        s2.imagen.setX(s2.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 2:
                        s1.imagen.setY(s1.imagen.getY()+70f*2);
                        s1.imagen.setX(s1.imagen.getX()-70f*2);
                        s2.imagen.setY(s2.imagen.getY()+70f);
                        s2.imagen.setX(s2.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 3:
                        s1.imagen.setY(s1.imagen.getY()-70f*2);
                        s1.imagen.setX(s1.imagen.getX()-70f*2);
                        s2.imagen.setY(s2.imagen.getY()-70f);
                        s2.imagen.setX(s2.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos=0;
                        break;

                }break;
            case 1:
                switch (pos){
                    case 0:
                        s2.imagen.setY(s2.imagen.getY()+70f);
                        s2.imagen.setX(s2.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()+70f*2);
                        s3.imagen.setX(s3.imagen.getX()-70f*2);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos++;
                        break;
                    case 1:
                        s2.imagen.setY(s2.imagen.getY()-70f);
                        s2.imagen.setX(s2.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()-70f*2);
                        s3.imagen.setX(s3.imagen.getX()-70f*2);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 2:
                        s2.imagen.setY(s2.imagen.getY()-70f);
                        s2.imagen.setX(s2.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()-70f*2);
                        s3.imagen.setX(s3.imagen.getX()+70f*2);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 3:
                        s2.imagen.setY(s2.imagen.getY()+70f);
                        s2.imagen.setX(s2.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()+70f*2);
                        s3.imagen.setX(s3.imagen.getX()+70f*2);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos=0;
                        break;
                }break;
            case 2:
                break;
            case 3:
                switch (pos){
                    case 0:
                        s1.imagen.setY(s1.imagen.getY()-70f*2);
                        s1.imagen.setX(s1.imagen.getX()+70f*2);
                        s2.imagen.setY(s2.imagen.getY()-70f);
                        s2.imagen.setX(s2.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos++;
                        break;
                    case 1:
                        s1.imagen.setY(s1.imagen.getY()+70f*2);
                        s1.imagen.setX(s1.imagen.getX()-70f*2);
                        s2.imagen.setY(s2.imagen.getY()+70f);
                        s2.imagen.setX(s2.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos=0;
                        break;

                }break;
            case 4:
                switch (pos){
                    case 0:
                        s1.imagen.setY(s1.imagen.getY()-70f);
                        s1.imagen.setX(s1.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()+70f);
                        s3.imagen.setX(s3.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos++;
                        break;
                    case 1:
                        s1.imagen.setY(s1.imagen.getY()+70f);
                        s1.imagen.setX(s1.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()-70f);
                        s3.imagen.setX(s3.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()-70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 2:
                        s1.imagen.setY(s1.imagen.getY()+70f);
                        s1.imagen.setX(s1.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()-70f);
                        s3.imagen.setX(s3.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()+70f);
                        pos++;
                        break;
                    case 3:
                        s1.imagen.setY(s1.imagen.getY()-70f);
                        s1.imagen.setX(s1.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()+70f);
                        s3.imagen.setX(s3.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()+70f);
                        s4.imagen.setX(s4.imagen.getX()-70f);
                        pos=0;
                        break;

                }break;
            case 5:
                switch (pos){
                    case 0:
                        s1.imagen.setY(s1.imagen.getY()-70f);
                        s1.imagen.setX(s1.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()-70f);
                        s3.imagen.setX(s3.imagen.getX()-70f);
                        //s4.imagen.setY(s4.imagen.getY()+70f*2);
                        s4.imagen.setX(s4.imagen.getX()-70f*2);
                        pos++;
                        break;
                    case 1:
                        s1.imagen.setY(s1.imagen.getY()+70f);
                        s1.imagen.setX(s1.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()+70f);
                        s3.imagen.setX(s3.imagen.getX()+70f);
                        s4.imagen.setX(s4.imagen.getX()+70f*2);
                        pos--;
                        break;
                }
                break;
            case 6:
                switch (pos){
                    case 0:
                        s1.imagen.setY(s1.imagen.getY()-70f);
                        s1.imagen.setX(s1.imagen.getX()+70f);
                        s3.imagen.setY(s3.imagen.getY()+70f);
                        s3.imagen.setX(s3.imagen.getX()+70f);
                        s4.imagen.setY(s4.imagen.getY()+70f*2);
                        pos++;
                        break;
                    case 1:
                        s1.imagen.setY(s1.imagen.getY()+70f);
                        s1.imagen.setX(s1.imagen.getX()-70f);
                        s3.imagen.setY(s3.imagen.getY()-70f);
                        s3.imagen.setX(s3.imagen.getX()-70f);
                        s4.imagen.setY(s4.imagen.getY()-70f*2);
                        pos--;
                        break;
                }

        }
    }

    public void bajar(){
        s1.imagen.setY(s1.imagen.getY()+70f);
        s2.imagen.setY(s2.imagen.getY()+70f);
        s3.imagen.setY(s3.imagen.getY()+70f);
        s4.imagen.setY(s4.imagen.getY()+70f);
    }
    public void der(){
            s1.imagen.setX(s1.imagen.getX() + 70f);
            s2.imagen.setX(s2.imagen.getX() + 70f);
            s3.imagen.setX(s3.imagen.getX() + 70f);
            s4.imagen.setX(s4.imagen.getX() + 70f);
    }
    public void izq(){
            s1.imagen.setX(s1.imagen.getX() - 70f);
            s2.imagen.setX(s2.imagen.getX() - 70f);
            s3.imagen.setX(s3.imagen.getX() - 70f);
            s4.imagen.setX(s4.imagen.getX() - 70f);

    }

    public void getPieza(){
        Random r=new Random();
        int op=r.nextInt(7);
        switch (op){
            case 0:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*6);
                s3.imagen.setX(35+70f*7);
                s4.imagen.setX(35+70f*7);
                s4.imagen.setY(70f);
                this.id=0;
                break;
            case 1:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*6);
                s3.imagen.setX(35+70f*7);
                s4.imagen.setX(35+70f*5);
                s4.imagen.setY(70f);
                this.id=1;
                break;
            case 2:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*5);
                s2.imagen.setY(70f);
                s3.imagen.setX(35+70f*6);
                s4.imagen.setX(35+70f*6);
                s4.imagen.setY(70f);
                this.id=2;
                break;
            case 3:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*6);
                s3.imagen.setX(35+70f*7);
                s4.imagen.setX(35+70f*8);
                this.id = 3;
                break;
            case 4:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*6);
                s3.imagen.setX(35+70f*7);
                s4.imagen.setX(35+70f*6);
                s4.imagen.setY(70f);
                this.id=4;
                break;
            case 5:
                s1.imagen.setX(35+70f*5);
                s2.imagen.setX(35+70f*6);
                s3.imagen.setX(35+70f*6);
                s3.imagen.setY(70f);
                s4.imagen.setX(35+70f*7);
                s4.imagen.setY(70f);
                this.id=5;
                break;
            case 6:
                s1.imagen.setX(35+70f*5);
                s1.imagen.setY(70f);
                s2.imagen.setX(35+70f*6);
                s2.imagen.setY(70f);
                s3.imagen.setX(35+70f*6);
                s4.imagen.setX(35+70f*7);
                this.id=6;
                break;

        }

    }


}
