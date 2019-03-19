package com.example.wiideas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Intent receiveMainActivity = getIntent();
        final User muUserAddActivity = receiveMainActivity.getParcelableExtra("userGoAboutUsActivity");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMainActivity = new Intent(AboutUsActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });
        final Button button = findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                String aEmailList[] = { "user@fakehost.com" };
                String aEmailCCList[] = {findViewById(R.id.editTextComment).toString()};

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, aEmailCCList);
                startActivity(emailIntent);

            }
        });
    }
}
