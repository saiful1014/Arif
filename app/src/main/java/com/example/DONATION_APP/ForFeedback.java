package com.example.DONATION_APP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForFeedback extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editText1 = findViewById(R.id.mailBtn);
        editText2 = findViewById(R.id.cmntBtn);
        button1 = findViewById(R.id.sndBtn);
        button2 = findViewById(R.id.cncleBtn);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        try {
            String mail = editText1.getText().toString();
            String commnet = editText2.getText().toString();
            if (view.getId() == R.id.sndBtn) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shafetullah02@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK FROM APP");
                intent.putExtra(Intent.EXTRA_TEXT, "Name " + mail + "\n Message " + commnet);
                startActivity(Intent.createChooser(intent, "FEEDBACK WITH"));
            } else if (view.getId() == R.id.cncleBtn) {
                editText1.setText(" ");
                editText2.setText(" ");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SOMETHING WRONG", Toast.LENGTH_LONG).show();
        }
    }
}