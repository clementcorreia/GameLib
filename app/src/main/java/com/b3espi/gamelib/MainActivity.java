package com.b3espi.gamelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button playSudokuButton = (Button) findViewById(R.id.play_sudoku);
        playSudokuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SudokuPlay.class);
                startActivity(intent);
            }

        });

        final Button statsSudokuButton = (Button) findViewById(R.id.stats_sudoku);
        statsSudokuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SudokuStats.class);
                startActivity(intent);
            }

        });

        final Button playQuizzButton = (Button) findViewById(R.id.play_quizz);
        playQuizzButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizzPlay.class);
                startActivity(intent);
            }

        });

        final Button statsQuizzButton = (Button) findViewById(R.id.stats_quizz);
        statsQuizzButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizzStats.class);
                startActivity(intent);
            }

        });

        final Button playDemineurButton = (Button) findViewById(R.id.play_demineur);
        playDemineurButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemineurPlay.class);
                startActivity(intent);
            }

        });

        final Button statsDemineurButton = (Button) findViewById(R.id.stats_demineur);
        statsDemineurButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemineurStats.class);
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

        final Button statsPuissance4Button = (Button) findViewById(R.id.stats_puissance4);
        statsPuissance4Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Puissance4Stats.class);
                startActivity(intent);
            }

        });
    }
}
