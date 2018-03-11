package com.example.josue.tetris2;

import java.util.Timer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.util.Log;

public class Tetris extends AppCompatActivity {
    protected Timer myTimer;
    protected ArrayList<Square> cuadros;
    protected float[][] tablero = new float[14][13];
    protected int contShape;
    protected Shape actual;
    protected float s1x,s1y,s2x,s2y,s3x,s3y,s4x,s4y;
    protected int puntaje;
    protected int mov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        cuadros = getCuadros();
        mov=0;
        puntaje=0;
        for (float[] row: tablero)
            Arrays.fill(row, -1f);

        for(int i=0;i<14;i++) {
            tablero[i][0]=1000;
            tablero[i][12]=1000;
        }
        for(int i=0;i<12;i++){
            tablero[13][i]=1000;
        }
        contShape=0;
        getPieza();

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getPoinst();
                if(tablero[(int)s1y+1][(int)s1x]==-1 && tablero[(int)s2y+1][(int)s2x]==-1 && tablero[(int)s3y+1][(int)s3x]==-1 && tablero[(int)s4y+1][(int)s4x]==-1){
                    actual.bajar();
                    mov++;
                }
                else{
                    if(mov==0){
                        myTimer.cancel();
                    }
                    tablero[(int)s1y][(int)s1x]=actual.s1.id;
                    tablero[(int)s2y][(int)s2x]=actual.s2.id;
                    tablero[(int)s3y][(int)s3x]=actual.s3.id;
                    tablero[(int)s4y][(int)s4x]=actual.s4.id;
                    boolean change=true;
                    for(int i=0;i<13;i++){
                        if(tablero[12][i]==-1)
                            change = false;
                    }
                    if(change){
                        for(Square s:cuadros){
                            s.imagen.setY(s.imagen.getY()+70f);
                        }puntaje++;
                        for(int i=12;i>=1;i--){
                            for(int j=11;j>=1;j--){
                                tablero[i][j]=tablero[i-1][j];
                            }
                        }
                        for(int i=1;i<12;i++){
                            tablero[0][i]=-1;
                        }
                    }
                    mov=0;
                    getPieza();
                }
            }

        }, 0, 400);
    }

    protected void ClickDer(View v) {
        getPoinst();
        if(tablero[(int)s1y][(int)s1x+1]==-1 && tablero[(int)s2y][(int)s2x+1]==-1 && tablero[(int)s3y][(int)s3x+1]==-1 && tablero[(int)s4y][(int)s4x+1]==-1)
            actual.der();
    }
    protected void ClickIzq(View v){
        getPoinst();
        if(tablero[(int)s1y][(int)s1x-1]==-1 && tablero[(int)s2y][(int)s2x-1]==-1 && tablero[(int)s3y][(int)s3x-1]==-1 && tablero[(int)s4y][(int)s4x-1]==-1)
            actual.izq();
    }
    protected void Vuelta(View v){
        actual.turn();
    }

    protected void getPoinst(){
        s1x=(actual.s1.imagen.getX()-35)/70+1;
        s1y=actual.s1.imagen.getY()/70;
        s2x=(actual.s2.imagen.getX()-35)/70+1;
        s2y=actual.s2.imagen.getY()/70;
        s3x=(actual.s3.imagen.getX()-35)/70+1;
        s3y=actual.s3.imagen.getY()/70;
        s4x=(actual.s4.imagen.getX()-35)/70+1;
        s4y=actual.s4.imagen.getY()/70;
    }

    protected void getPieza(){
        if(contShape>=120)
            contShape=0;
        for(int i=0;i<4;i++){
            cuadros.get(i+contShape).imagen.setAlpha(1f);
        }
        actual = new Shape(cuadros.get(contShape),cuadros.get(contShape+1),cuadros.get(contShape+2),cuadros.get(contShape+3));
        actual.getPieza();
        contShape = contShape+4;
    }
    protected void clickSalir(View v){
        myTimer.cancel();
        CharSequence text = "Completó "+Integer.toString(puntaje)+" lineas";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
        toast.show();
    }
    protected ArrayList<Square> getCuadros(){
        cuadros =  new ArrayList<>();
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView1),1));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView2),2));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView3),3));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView4),4));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView5),5));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView6),6));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView7),7));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView8),8));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView9),9));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView10),10));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView11),11));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView12),12));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView13),13));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView14),14));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView15),15));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView16),16));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView17),17));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView18),18));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView19),19));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView20),20));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView21),21));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView22),22));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView23),23));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView24),24));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView25),25));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView26),26));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView27),27));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView28),28));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView29),29));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView30),30));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView31),31));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView32),32));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView33),33));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView34),34));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView35),35));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView36),36));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView37),37));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView38),38));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView39),39));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView40),40));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView41),41));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView42),42));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView43),43));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView44),44));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView45),45));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView46),46));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView47),47));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView48),48));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView49),49));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView50),50));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView51),51));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView52),52));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView53),53));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView54),54));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView55),55));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView56),56));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView57),57));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView58),58));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView59),59));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView60),60));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView61),61));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView62),62));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView63),63));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView64),64));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView65),65));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView66),66));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView67),67));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView68),68));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView69),69));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView70),70));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView71),71));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView72),72));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView73),73));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView74),74));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView75),75));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView76),76));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView77),77));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView78),78));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView79),79));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView80),80));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView81),81));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView82),82));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView83),83));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView84),84));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView85),85));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView86),86));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView87),87));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView88),88));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView89),89));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView90),90));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView91),91));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView92),92));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView93),93));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView94),94));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView95),95));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView96),96));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView97),97));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView98),98));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView99),99));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView100),100));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView101),101));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView102),102));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView103),103));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView104),104));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView105),105));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView106),106));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView107),107));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView108),108));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView109),109));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView110),110));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView111),111));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView112),112));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView113),113));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView114),114));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView115),115));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView116),116));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView117),117));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView118),118));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView119),119));
        cuadros.add(new Square ( (ImageView) findViewById(R.id.imageView120),120));
        return cuadros;
    }


}
