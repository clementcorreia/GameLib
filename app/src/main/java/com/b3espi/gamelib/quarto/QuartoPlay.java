package com.b3espi.gamelib.quarto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.b3espi.gamelib.R;

public class QuartoPlay extends AppCompatActivity {

    // On déclare une constante dans la classe FirstClass
    public final static String NOMS = "com.b3espi.gamelib.quarto.NOMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_play);

        final TextView joueur1 = (EditText) findViewById(R.id.nomJoueur1);
        final TextView joueur2 = (EditText) findViewById(R.id.nomJoueur2);

        final Button jouerQuarto = (Button) findViewById(R.id.jouerQuarto);
        jouerQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuartoPlay.this, Quarto.class);

                String [] noms = new String[] {joueur1.getText().toString(), joueur2.getText().toString()};
                intent.putExtra(QuartoPlay.NOMS, noms);
                startActivity(intent);
            }
        });
    }
}
