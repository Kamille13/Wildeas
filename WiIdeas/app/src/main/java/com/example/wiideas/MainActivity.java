package com.example.wiideas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

        // Receive variable user value
        Intent receiveStartActivity = getIntent();
        final User userMaintActivity = receiveStartActivity.getParcelableExtra("userGoStartActivity");

        //Display Hello User
        TextView HelloUser = (TextView) findViewById(R.id.textViewHello);
        HelloUser.setText("Hello " + userMaintActivity.getFirstname() + " " + userMaintActivity.getName() + " " +  "!");

        //Fill the list (table)
        String[] listUserIdea = new String[userMaintActivity.getIdea().size()];
        for (int index=0; index < userMaintActivity.getIdea().size(); index++){
            listUserIdea[index] = userMaintActivity.getIdea().get(index).getIdeaTittle();
        }

        //Display list
        final ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> ideasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listUserIdea);
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
