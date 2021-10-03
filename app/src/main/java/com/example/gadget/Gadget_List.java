package com.example.gadget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Gadget_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");
        int uri = intent.getIntExtra("uri",0);

        ImageView imageView = findViewById(R.id.gadgetpic);
        TextView textView = findViewById(R.id.gadgetName);
        Button button = findViewById(R.id.gadgetBtn);

        imageView.setImageResource(uri);
        textView.setText(name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });


    }
}