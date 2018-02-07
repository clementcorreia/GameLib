package com.b3espi.gamelib.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.b3espi.gamelib.R;
import com.b3espi.gamelib.pendu.JeuPendu;

public class Pendu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_play);

        final Button jouerPendu = (Button) findViewById(R.id.jouerPendu);
        jouerPendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pendu.this, JeuPendu.class);
                startActivity(intent);
            }
        });
    }
}
