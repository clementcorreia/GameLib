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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_play);

        final EditText joueur1 = (EditText) findViewById(R.id.nomJoueur1);
        final EditText joueur2 = (EditText) findViewById(R.id.nomJoueur2);

        final Button jouerQuarto = (Button) findViewById(R.id.jouerQuarto);
        jouerQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(QuartoPlay.this, Quarto.class);
                intent.putExtra("nomJoueur1", joueur1.getText());
                intent.putExtra("nomJoueur2", joueur2.getText());
                startActivity(intent);
            }
        });
    }

}
