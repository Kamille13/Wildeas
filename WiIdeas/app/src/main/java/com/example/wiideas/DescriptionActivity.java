package com.example.wiideas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent receiveMainActivity = getIntent();
        final User userDescriptiontActivity = receiveMainActivity.getParcelableExtra("userGoDescriptionActivity");
        final String indexDescriptionActivity = receiveMainActivity.getStringExtra("indexGoDescriptionActivity");
        int index = Integer.parseInt(indexDescriptionActivity);

        index =Integer.parseInt(indexDescriptionActivity);

        TextView tittle = (TextView) findViewById(R.id.textView);
        TextView description = (TextView) findViewById(R.id.textView2);

        description.setText(userDescriptiontActivity.getIdea().get(index).getIdeaTittle());
        tittle.setText(userDescriptiontActivity.getIdea().get(index).getIdeaContent());


    }

}

