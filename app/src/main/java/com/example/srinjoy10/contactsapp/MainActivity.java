package com.example.srinjoy10.contactsapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.io.*;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.lang.Object;
import android.graphics.*;
import java.util.Collections;

import android.graphics.Bitmap;

public class MainActivity extends s{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LinearLayout main = (LinearLayout) findViewById(R.id.content_main);


        ArrayList<String> name=s.getInstance().getArrayList1();
        ArrayList<String> number=s.getInstance().getArrayList2();
        ArrayList<String> d2=s.getInstance().getArrayd();
        //ArrayList<ArrayList<String>> m=s.getInstance().getArrayList3();

        int i = 0;int j=0;
        //ImageView iv=new ImageView();

            while (i < name.size()) {
                //while (j < name.get(i).size()) {
                    LinearLayout ll = new LinearLayout(this);

                Bundle extras = getIntent().getExtras();
                String fileName = d2.get(i);
                File filePath = getFileStreamPath(fileName);
                Drawable d = Drawable.createFromPath(filePath.toString());

                    TextView tv = new TextView(this);
                    tv.setText(name.get(i));
                TextView tv2 = new TextView(this);
                tv2.setText(number.get(i));
                    tv.setTextSize(24);
                    tv.setPadding(10, 10, 10, 10);
                    ll.setPadding(16, 16, 16, 16);
                    tv.setTextColor(Color.BLACK);
                    tv2.setVisibility(TextView.INVISIBLE);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    ll.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            opendetails(v);
                        }
                    });
                    ImageView image = new ImageView(MainActivity.this);
                   image.setImageDrawable(d);

                    //image.setImageResource(R.drawable.harambe);
               // ImageView img = new ImageView(this);
                //img.setImageBitmap(bmp);

                int width = 200;
                    int height = 200;
                    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(175, 175);
                    image.setLayoutParams(parms);


                    //ll.addView(img);
                   ll.addView(image);
                    ll.addView(tv);
                    ll.addView(tv2);

                    //ll.addView(tv2);
                    i++;
                    j++;
                    main.addView(ll);
                }



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

    }
    public void opennew(View view) {
        Intent intent = new Intent(this, addcontact.class);
        //intent.putExtra("namearray",name);
        startActivity(intent);

    }
    public void opendetails(View view) {
        Intent intent = new Intent(this, details.class);
        LinearLayout l=(LinearLayout)view;
        TextView t=(TextView) l.getChildAt(1);
        String tn=t.getText().toString();
        intent.putExtra("text",tn);
        TextView t2=(TextView) l.getChildAt(2);
        String tn2=t2.getText().toString();
        intent.putExtra("text2",tn2);
        ImageView iv=(ImageView) l.getChildAt(0);
        iv.buildDrawingCache();
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.harambe);
        Bitmap bitmap=iv.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();

        String fileName = "SomeName.png";
        try {
            FileOutputStream fileOutStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutStream.write(b);
            fileOutStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        intent.putExtra("picname",fileName);
        startActivity(intent);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
