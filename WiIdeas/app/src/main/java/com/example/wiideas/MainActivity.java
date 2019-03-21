package com.example.wiideas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    User userMaintActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Receive variable user value
        Intent receiveStartActivity = getIntent();
        userMaintActivity = receiveStartActivity.getParcelableExtra("toMainActivity");



        //Display Hello User
        TextView HelloUser = (TextView) findViewById(R.id.textViewHello);
        HelloUser.setText("Hello " + userMaintActivity.getFirstname() + " " + userMaintActivity.getName() + " " +  "!");


        final ListView listView = findViewById(R.id.listView);
        IdeasAdapter ideasAdapter = new IdeasAdapter(MainActivity.this, userMaintActivity.getIdea());
        listView.setAdapter(ideasAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String index = Integer.toString(position);
                Intent goDescriptionActivity = new Intent(MainActivity.this, DescriptionActivity.class);

                goDescriptionActivity.putExtra("userGoDescriptionActivity", (Parcelable) userMaintActivity);
                goDescriptionActivity.putExtra("indexGoDescriptionActivity", index);
                startActivity(goDescriptionActivity);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goAddActivity = new Intent(MainActivity.this, AddActivity.class);
                goAddActivity.putExtra("userGoAddActivity", (Parcelable) userMaintActivity);
                startActivity(goAddActivity);
            }
            });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.



        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_us) {

            Intent goAboutUsActivity = new Intent(MainActivity.this, AboutUsActivity.class);
            goAboutUsActivity.putExtra("userGoAboutUsActivity", (Parcelable) userMaintActivity);
            startActivity(goAboutUsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
