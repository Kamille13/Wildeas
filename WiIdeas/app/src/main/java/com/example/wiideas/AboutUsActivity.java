package com.example.wiideas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    User muUserAddActivity;

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

            Intent goAboutUsActivity = new Intent(AboutUsActivity.this, AboutUsActivity.class);
            goAboutUsActivity.putExtra("userGoAboutUsActivity", (Parcelable) muUserAddActivity);
            startActivity(goAboutUsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
