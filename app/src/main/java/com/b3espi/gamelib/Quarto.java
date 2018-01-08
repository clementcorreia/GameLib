package com.b3espi.gamelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Quarto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_play);

        // Assign the touch listener to your view which you want to move
        //final ImageButton buttonTest = (ImageButton) findViewById(R.id.pion1);
        //findViewById(R.id.pion1).setOnTouchListener(new MyTouchListener());

    }
}

// Test pour le drag and drop
// This defines your touch listener
/*final class MyTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }
}*/