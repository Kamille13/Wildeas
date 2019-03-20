package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Todo obligation = new Todo("Récupérer ma voiture", "01/01/2019");
        Todo obligation2 = new Todo("Passer l'aspirateur", "03/01/2019");
        Todo obligation3 = new Todo("Acheter des tacos", "06/02/2019");
        Todo obligation4 = new Todo("Tondre la pelouse", "07/02/2019");

        List<Todo> menu = Arrays.asList(obligation, obligation2, obligation3, obligation4);

        ListView listMenu = findViewById(R.id.listTodo);
        TodoAdapter adapter = new TodoAdapter(MainActivity.this, menu);
        listMenu.setAdapter(adapter);
    }
}
