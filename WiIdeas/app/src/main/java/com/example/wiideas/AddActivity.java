package com.example.wiideas;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import static android.os.Build.VERSION_CODES.KITKAT;

public class AddActivity extends AppCompatActivity {

    User muUserAddActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //Crée la ToolBar avec le bouton retour
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMainActivity = new Intent(AddActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });

        Intent receiveMainActivity = getIntent();
        muUserAddActivity = receiveMainActivity.getParcelableExtra("userGoAddActivity");


        final Button Add = findViewById(R.id.buttonAdd);
        final Button Image = findViewById((R.id.buttonAdd2));

        final int PICK_IMAGE_REQUEST = 1;


        // Add an Idea
        Add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                EditText Title = findViewById(R.id.editTextTitle);
                EditText Description = findViewById(R.id.editTextDescription);
                String TitleText = Title.getText().toString();
                String DescriptionText = Description.getText().toString();

                Idea newIdea = new Idea(TitleText,DescriptionText);
                muUserAddActivity.getIdea().add(newIdea);

                Intent goMainActivity = new Intent(AddActivity.this, MainActivity.class);
                goMainActivity.putExtra("toMainActivity", (Parcelable) muUserAddActivity);
                startActivity(goMainActivity);
            }
        });


        //Add an image
        Image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                Intent intent = new Intent();
                // Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);


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

            Intent goAboutUsActivity = new Intent(AddActivity.this, AboutUsActivity.class);
            goAboutUsActivity.putExtra("userGoAboutUsActivity", (Parcelable) muUserAddActivity);
            startActivity(goAboutUsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
