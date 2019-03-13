package com.example.wiideas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent receiveStartActivity = getIntent();
        String firstNameText = receiveStartActivity.getStringExtra("firstName");
        String lastNameText = receiveStartActivity.getStringExtra("name");

        Idea idea1 = new Idea("Tittle","Description");

        User user1 = new User(firstNameText,lastNameText, idea1);

        ArrayList<Idea> test = user1.getIdea();

        Idea test1 = test.get(0);

                TextView HelloUser = (TextView) findViewById(R.id.textViewHello);
        HelloUser.setText("Hello " + user1.getUserFirstName() + " " + user1.getUserName() + " " + test1.getIdeaTittle() +  "!");


        FloatingActionButton fab = findViewById(R.id.fab);;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newActivity = new Intent(MainActivity.this, AddActivity.class);
                startActivity(newActivity);
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
            Intent aboutUsActivity = new Intent(MainActivity.this, AboutUsActivity.class);
            startActivity(aboutUsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
