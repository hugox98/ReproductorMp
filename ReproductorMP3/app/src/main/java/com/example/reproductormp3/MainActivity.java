package com.example.reproductormp3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button play_pausar;
    MediaPlayer mp3;
    ImageView iv;
    TextView C;
    int  posicion =0;
    String [] vect = {"Happier", "Dancin", "TheNneverland", "The tropper", "Shingeki"};


    MediaPlayer vectormp [] = new MediaPlayer[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pausar = (Button)findViewById(R.id.btnPlay);
        iv = (ImageView)findViewById(R.id.imageView);
        C = (TextView)findViewById(R.id.txtCancion);

        vectormp[0] = MediaPlayer.create(this, R.raw.hapier);
        vectormp[1] = MediaPlayer.create(this, R.raw.dancin);
        vectormp[2] = MediaPlayer.create(this, R.raw.promised);
        vectormp[3] = MediaPlayer.create(this, R.raw.tropper);
        vectormp[4] = MediaPlayer.create(this, R.raw.shingekit);

    }

    //Metodo para boton Play

    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pausar.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pausar.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }
    //Meotodo para boton Stop

    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this, R.raw.hapier);
            vectormp[1] = MediaPlayer.create(this, R.raw.dancin);
            vectormp[2] = MediaPlayer.create(this, R.raw.promised);
            vectormp[3] = MediaPlayer.create(this, R.raw.tropper);
            vectormp[4] = MediaPlayer.create(this, R.raw.shingekit);
            posicion =0;
            play_pausar.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.happier);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo para saltar la siguiente cancion
    public void Next(View view){
        if(posicion<vectormp.length -1){
            if(vectormp[posicion].isPlaying()){
            vectormp[posicion].stop();
            posicion++;
            vectormp[posicion].start();

            if(posicion ==0) {
                iv.setImageResource(R.drawable.happier);
                C.setText(vect[0]);

            }else if(posicion==1){
                iv.setImageResource(R.drawable.dancin);
                C.setText(vect[1]);
            }
            else if(posicion==2){
                iv.setImageResource(R.drawable.neverland);
                C.setText(vect[2]);
            }
            else if(posicion==3){
                iv.setImageResource(R.drawable.single_iron_maiden_trooper);
                C.setText(vect[3]);
            }
            else if(posicion==4){
                iv.setImageResource(R.drawable.shingeki);
                C.setText(vect[4]);
            }
            }else{
                posicion++;
                if(posicion ==0) {
                    iv.setImageResource(R.drawable.happier);
                    C.setText(vect[0]);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.dancin);
                    C.setText(vect[1]);
                }
                else if(posicion==2){
                    iv.setImageResource(R.drawable.neverland);
                    C.setText(vect[2]);
                }
                else if(posicion==3){
                    iv.setImageResource(R.drawable.single_iron_maiden_trooper);
                    C.setText(vect[3]);
                }
                else if(posicion==4){
                    iv.setImageResource(R.drawable.shingeki);
                    C.setText(vect[4]);
                }
            }

        }else{
            Toast.makeText(this, "No hay cancion", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo regresar

    public void Anterior(View view){
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.hapier);
                vectormp[1] = MediaPlayer.create(this, R.raw.dancin);
                vectormp[2] = MediaPlayer.create(this, R.raw.promised);
                vectormp[3] = MediaPlayer.create(this, R.raw.tropper);
                vectormp[4] = MediaPlayer.create(this, R.raw.shingekit);
                posicion --;

                if(posicion ==0) {
                    iv.setImageResource(R.drawable.happier);
                    C.setText(vect[0]);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.dancin);
                    C.setText(vect[1]);
                }
                else if(posicion==2){
                    iv.setImageResource(R.drawable.neverland);
                    C.setText(vect[2]);
                }
                else if(posicion==3){
                    iv.setImageResource(R.drawable.single_iron_maiden_trooper);
                    C.setText(vect[3]);
                }
                else if(posicion==4){
                    iv.setImageResource(R.drawable.shingeki);
                    C.setText(vect[4]);
                }
                vectormp[posicion].start();

            }else{
                posicion--;

                if(posicion ==0) {
                    iv.setImageResource(R.drawable.happier);
                    C.setText(vect[0]);
                }else if(posicion==1){
                    iv.setImageResource(R.drawable.dancin);
                    C.setText(vect[1]);
                }
                else if(posicion==2){
                    iv.setImageResource(R.drawable.neverland);
                    C.setText(vect[2]);
                }
                else if(posicion==3){
                    iv.setImageResource(R.drawable.single_iron_maiden_trooper);
                    C.setText(vect[3]);
                }
                else if(posicion==4){
                    iv.setImageResource(R.drawable.shingeki);
                    C.setText(vect[4]);
                }
            }

        }else{
            Toast.makeText(this, "No hay cancion", Toast.LENGTH_SHORT).show();

        }
    }
}
