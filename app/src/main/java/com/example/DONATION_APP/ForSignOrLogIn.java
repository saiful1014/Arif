package com.example.DONATION_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForSignOrLogIn extends AppCompatActivity implements View.OnClickListener {

    private Button sgnIn,lgIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("SIGN_IN OR LOG_IN");
        setContentView(R.layout.activity_for_sign_or_log_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sgnIn=findViewById(R.id.signInId);
        lgIn=findViewById(R.id.logInId);

        lgIn.setOnClickListener(this);
        sgnIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signInId)
        {
            Intent intent=new Intent(this,ForLgPage.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.logInId)
        {
            Intent intent=new Intent(this,ForLogInActivity.class);
            startActivity(intent);
        }
    }
}