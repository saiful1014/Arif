package com.example.DONATION_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SlashScreen extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("DONATION APP");
        setContentView(R.layout.activity_slash_screen);

        progressBar=findViewById(R.id.barID);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startAPP();
            }
        });
        thread.start();



    }
    public void doWork()
    {
        for(int progress=10;progress<=100;progress+=15)
        {
            try{
                Thread.sleep(500);
                progressBar.setProgress(progress);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void startAPP()
    {
        Intent intent=new Intent(SlashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}