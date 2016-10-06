package com.example.user.manigbas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ontouch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);

        final ImageView imahe = (ImageView) findViewById(R.id.asa);

        imahe.setOnTouchListener(new View.OnTouchListener() {
            float intX=0,finalX=0,intY=0,finalY=0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        intX = motionEvent.getX();
                        intY = motionEvent.getY();
                        Toast.makeText(getApplicationContext(), "" + String.format("ACTION_DOWN___X:%.2f,Y:%.2f", intX, intY), Toast.LENGTH_SHORT).show();
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        displayAction(intX, intY, finalX, finalY);
                        return true;
                }
                return false;
            }
        });
    }

    public void displayAction(float x1, float x2, float y1, float y2){
        String msg = "";

        if(x1 < x2) {
            msg = String.format("SWIPED LEFT TO RIGHT");
        }else if(x1 > x2) {
            msg = String.format("SWIPED RIGHT TO LEFT");
        }

        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();

        if(y1 < y2) {
            msg = String.format("SWIPED UP TO DOWN");
        }else if(y1 > y2) {
            msg = String.format("SWIPE DOWN TO UP");
        }
        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();

    }
}
