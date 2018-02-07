package com.b3espi.gamelib.quarto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.b3espi.gamelib.MainActivity;
import com.b3espi.gamelib.R;

import java.util.ArrayList;

public class QuartoGagne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_gagne);

        // On récupère les intents
        Intent intent = getIntent();
        String joueur = intent.getStringExtra(Quarto.GAGNANT);
        ArrayList<String> combinaisonsGagnante = intent.getStringArrayListExtra(Quarto.COMBINAISONS);

        // Affichage
        TextView textView = (TextView) findViewById(R.id.gagnantQuarto);

        StringBuilder str = new StringBuilder();
        str.append("Bravo "+joueur+"\nVous avez gagné avec la combinaison :\n ");

        /*for(int i=0; i<combinaisonsGagnante.size(); i+=2){
            str.append(combinaisonsGagnante.get(i));
            str.append(" : ");
            str.append(combinaisonsGagnante.get(i+1));
            str.append("\n");
        }*/

        while(!combinaisonsGagnante.isEmpty()){
            str.append(combinaisonsGagnante.remove(0));
            str.append(" : ligne [");
            int j = Integer.parseInt(combinaisonsGagnante.remove(0)); // On dépile le premier indice de la ligne gagnante
            str.append(QuartoGrille.getListeComb(j));
            str.append(", ");
            str.append(QuartoGrille.getListeComb(j+1));
            str.append(", ");
            str.append(QuartoGrille.getListeComb(j+2));
            str.append(", ");
            str.append(QuartoGrille.getListeComb(j+3));
            str.append("]\n");
        }

        str.append("\n[0 ][1 ][2 ][3 ]\n[4 ][5 ][6 ][7 ]\n[8 ][9 ][10][11]\n[12][13][15][16]\n");

        textView.setText(str.toString());

        // Bouton de retour
        Button boutonRetour = (Button) findViewById(R.id.boutonRetour);
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuartoGagne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
