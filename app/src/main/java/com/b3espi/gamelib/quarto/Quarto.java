package com.b3espi.gamelib.quarto;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.b3espi.gamelib.R;

public class Quarto extends AppCompatActivity {

    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_game);

        // Listener de drag n drop
        findViewById(R.id.pion1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion4).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.pion5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion7).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion8).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.pion9).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion10).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion11).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion12).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.pion13).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion14).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion15).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.pion16).setOnTouchListener(new MyTouchListener());

        // Listener des drop zone
        findViewById(R.id.case1).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case2).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case3).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case4).setOnDragListener(new myDragEventListener());

        findViewById(R.id.case5).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case6).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case7).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case8).setOnDragListener(new myDragEventListener());

        findViewById(R.id.case9).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case10).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case11).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case12).setOnDragListener(new myDragEventListener());

        findViewById(R.id.case13).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case14).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case15).setOnDragListener(new myDragEventListener());
        findViewById(R.id.case16).setOnDragListener(new myDragEventListener());


    }
}

final class MyTouchListener implements View.OnTouchListener {
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
}

final class myDragEventListener implements View.OnDragListener {

    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    // This is the method that the system calls when it dispatches a drag event to the
    // listener.
    public boolean onDrag(View v, DragEvent event) {
        switch(event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                // Do nothing
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                int x_cord = (int) event.getX();
                int y_cord = (int) event.getY();
                break;

            case DragEvent.ACTION_DRAG_EXITED :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                x_cord = (int) event.getX();
                y_cord = (int) event.getY();
                layoutParams.leftMargin = x_cord;
                layoutParams.topMargin = y_cord;
                v.setLayoutParams(layoutParams);
                break;

            case DragEvent.ACTION_DRAG_LOCATION  :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                x_cord = (int) event.getX();
                y_cord = (int) event.getY();
                break;

            case DragEvent.ACTION_DRAG_ENDED   :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");

                // Do nothing
                break;

            case DragEvent.ACTION_DROP:
                Log.d(msg, "ACTION_DROP event");

                // Do nothing
                break;
            default: break;
        }
        return true;
    }
};