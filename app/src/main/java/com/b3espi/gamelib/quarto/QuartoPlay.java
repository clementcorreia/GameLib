package com.b3espi.gamelib.quarto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.b3espi.gamelib.R;

public class QuartoPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_play);

        final Button jouerQuarto = (Button) findViewById(R.id.jouerQuarto);
        jouerQuarto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuartoPlay.this, Quarto.class);
                startActivity(intent);
            }
        });
    }

}
