package com.example.wiideas;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wiideas.Idea;
import com.example.wiideas.R;

import java.io.IOException;
import java.util.List;

import static android.os.Build.VERSION_CODES.N;



class IdeasAdapter extends ArrayAdapter<Idea> {

    public IdeasAdapter(Context context, List<Idea> idea) {
        super(context, 0, idea);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Idea idea = getItem(position);

        if (null == convertView) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.activity_idea_main, parent, false);
        }

        TextView tittle = convertView.findViewById(R.id.textView3);
        TextView content = convertView.findViewById(R.id.textView4);
        ImageView image = convertView.findViewById(R.id.imageView3);


        Uri imageView = Uri.parse(idea.getImage());


        Bitmap bitmap = null;

        try {

            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageView);

        } catch (IOException e) {

            e.printStackTrace();
        }

        tittle.setText(idea.getTittle());
        content.setText(idea.getContent());
        image.setImageBitmap(bitmap);

        return convertView;
    }
}


