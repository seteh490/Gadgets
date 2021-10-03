package com.example.gadget;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class MainActivity extends ListActivity {
    String [] gadgets = {"Tello Quadcopter Drone",
            "Wine preservation System",
            "Fire TV Cube",
            "Wireless Charger",
            "Turn Table"};

    int[] gadgetsPics = {
            R.drawable.tqd,
            R.drawable.wps,
            R.drawable.ftc,
            R.drawable.wlc,
            R.drawable.tnt
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter = new MyListAdapter(this, gadgets, gadgetsPics);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(MainActivity.this, Gadget_List.class);
        intent.putExtra("name", gadgets[position]);
        intent.putExtra("url", "https://www.townandcountrymag.com/leisure/g13094996/cool-tech-gifts/");
        intent.putExtra("uri", gadgetsPics[position]);
        startActivity(intent);

    }

        class MyListAdapter extends ArrayAdapter<String> {

            private final Activity outline;
            private final String[] heading;
            private final int[] imageid;

            public MyListAdapter(Activity outline, String[] heading, int[] imageid) {
                super(outline, R.layout.gadget_list, heading);

                this.outline = outline;
                this.heading = heading;
                this.imageid = imageid;
            }

       // setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, uniPng));


                public View getView(int position, View view, ViewGroup parent) {
                    LayoutInflater inflater = outline.getLayoutInflater();
                    View rowView = inflater.inflate(R.layout.gadget_list, null,true);

                    TextView titleText = (TextView) rowView.findViewById(R.id.name);
                    ImageView imageView = (ImageView) rowView.findViewById(R.id.picture);

                    titleText.setText(heading[position]);
                    imageView.setImageResource(imageid[position]);

                    return rowView;
                   // Toast.makeText(this," "+gadgets[position], Toast.LENGTH_SHORT).show();
                };

            }

//

}
