package com.b3espi.gamelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Puissance4Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puissance4_play);

        Puissance4Grille jeu = new Puissance4Grille();

        final Button switchCaseButton = (Button) findViewById(R.id.switchCase);
        switchCaseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ImageButton case00 = (ImageButton) findViewById(R.id.case00);
                case00.setImageResource(R.drawable.boutonjaune);
            }

        });
    }
}
