package com.b3espi.gamelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.b3espi.gamelib.demineur.DemineurPlay;
import com.b3espi.gamelib.demineur.DemineurStats;
import com.b3espi.gamelib.pendu.JeuPendu;
import com.b3espi.gamelib.pendu.Pendu;
import com.b3espi.gamelib.puissance4.Puissance4Play;
import com.b3espi.gamelib.puissance4.Puissance4Stats;
import com.b3espi.gamelib.quarto.QuartoPlay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button playDemineurButton = (Button) findViewById(R.id.play_demineur);
        playDemineurButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemineurPlay.class);
                startActivity(intent);
            }

        });

        final Button playPuissance4Button = (Button) findViewById(R.id.play_puissance4);
        playPuissance4Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Puissance4Play.class);
                startActivity(intent);
            }

        });

        final Button playQuartoButton = (Button) findViewById(R.id.play_quarto);
        playQuartoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuartoPlay.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD
        final Button playQuartoButton = (Button) findViewById(R.id.play_quarto);
        playQuartoButton.setOnClickListener(new View.OnClickListener() {
=======

        final Button playPenduButton = (Button) findViewById(R.id.play_pendu);
        playPenduButton.setOnClickListener(new View.OnClickListener() {
>>>>>>> devQuarto

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pendu.class);
                startActivity(intent);
            }
        });

        final Button playMorpionButton = (Button) findViewById(R.id.play_morpion);
        playMorpionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pendu.class);
                startActivity(intent);
            }
        });
    }
}
