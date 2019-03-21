package com.example.wiideas;

import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class StartActivity extends AppCompatActivity {

    public void showAlertDialog (View v){
        // setup the alert builder
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Important message de Gandalf");
        alert.setMessage("Es-tu sûr de vouloir continuer sur ce chemin pauvre fou ? ");
        // add a button
        alert.setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(StartActivity.this, "A tes risques et périls !", Toast.LENGTH_SHORT).show();
            }
        });
        // create and show the alert dialog
        alert.setNegativeButton("Refuser", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(StartActivity.this, "T'as bien raison, ce n'est pas une app pour les mauviettes !", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Button button = findViewById(R.id.buttonGo);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                AlertDialog.Builder alert = new AlertDialog.Builder(StartActivity.this);
                alert.setTitle("Important message de Gandalf");
                alert.setMessage("Es-tu sûr de vouloir continuer sur ce chemin pauvre fou ? ");
                // add a button
                alert.setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(StartActivity.this, "A tes risques et périls !", Toast.LENGTH_LONG).show();

                        EditText firstName = findViewById(R.id.editTextFirstName);
                        String firstNameText = firstName.getText().toString();

                        EditText lastName = findViewById(R.id.editTextLastName);
                        String lastNameText = lastName.getText().toString();


                Uri uri = Uri.parse("android.resource://com.example.wiideas/drawable/enstein");

                //Initialization of idea and user
                Idea ideaStartActivity = new Idea("Tittle","Description",uri.toString());
                User userStarActivity = new User(firstNameText,lastNameText, ideaStartActivity);

                        Intent fromStartActivity = new Intent(StartActivity.this, MainActivity.class);
                        fromStartActivity.putExtra("toMainActivity", (Parcelable) userStarActivity);
                        startActivity(fromStartActivity);
                    }
                });
                // create and show the alert dialog
                alert.setNegativeButton("Refuser", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(StartActivity.this, "T'as bien raison, ce n'est pas une app pour les mauviettes !", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();






            }
        });

    }
}
