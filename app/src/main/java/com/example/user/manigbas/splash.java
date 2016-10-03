package com.example.user.manigbas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){

            public void run(){
                try{
                    sleep(4000);
                }catch(Exception exception){
                    exception.printStackTrace();
                }finally{
                    Intent intent = new Intent(splash.this, LoginScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        thread.start();
    }

}