package com.example.srinjoy10.contactsapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;

import java.io.File;

public class details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String name=getIntent().getStringExtra("text");
        String number=getIntent().getStringExtra("text2");
        TextView tv =(TextView) findViewById(R.id.textView1);
        TextView tv2 =(TextView) findViewById(R.id.textView2);
        tv.setText(name);
        tv.setTextSize(24);
        tv.setPadding(10, 10, 10, 10);
        tv.setTextColor(Color.BLACK);

        Bundle extras = getIntent().getExtras();
        String fileName = extras.getString("picname");
        File filePath = getFileStreamPath(fileName);
        Drawable d = Drawable.createFromPath(filePath.toString());
        ImageView iv=(ImageView) findViewById(R.id.imageView2);
        iv.setImageDrawable(d);
       LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(600,600);
        iv.setLayoutParams(parms);
        tv2.setText(number);
        tv2.setTextSize(24);
        tv2.setPadding(10, 10, 10, 10);
        tv2.setTextColor(Color.BLACK);
    }
}
