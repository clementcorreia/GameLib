package com.b3espi.gamelib.morpion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.b3espi.gamelib.R;

public class morpionPlay extends AppCompatActivity {

    public final static String JOUEUR1 = "com.b3espi.gamelib.quarto.JOUEUR1";
    public final static String JOUEUR2 = "com.b3espi.gamelib.quarto.JOUEUR2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion_play);

        final TextView joueur1 = (EditText) findViewById(R.id.nomJoueur1_morpion);
        final TextView joueur2 = (EditText) findViewById(R.id.nomJoueur2_morpion);

        final Button jouerMorpion = (Button) findViewById(R.id.jouerMorpion);
        jouerMorpion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(morpionPlay.this, Morpion.class);

                String nomJoueur1 = new String(joueur1.getText().toString());
                String nomJoueur2 = new String(joueur2.getText().toString());

                intent.putExtra(morpionPlay.JOUEUR1, nomJoueur1);
                intent.putExtra(morpionPlay.JOUEUR2, nomJoueur2);
                startActivity(intent);
            }
        });
    }
}