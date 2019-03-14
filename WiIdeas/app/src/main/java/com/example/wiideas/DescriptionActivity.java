package com.example.wiideas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent receiveMainActivity = getIntent();
        final User userDescriptiontActivity = receiveMainActivity.getParcelableExtra("userGoDescriptionActivity");
        final String indexDescriptionActivity = receiveMainActivity.getParcelableExtra("indexGoDescriptionActivity");


    }
}