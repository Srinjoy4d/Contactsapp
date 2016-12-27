package com.example.srinjoy10.contactsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.net.Uri;
import java.io.*;
import android.widget.ImageView;
import java.util.ArrayList;
import android.view.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.app.Activity;

public class addcontact extends s {

    private static final int PICK_IMAGE = 100;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        imageView = (ImageView) findViewById(R.id.imageView3);

        Button pickImageButton = (Button) findViewById(R.id.button3);
        pickImageButton.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }


    public void submit(View view)
    {


        //ArrayList<String> array = getIntent().getStringArrayListExtra("namearray");
        EditText et= (EditText)findViewById(R.id.e1);
        String string = et.getText().toString();
        EditText et2= (EditText)findViewById(R.id.e2);
        String no = et2.getText().toString();
        ArrayList<String> name=s.getInstance().getArrayList1();
        ArrayList<String> number=s.getInstance().getArrayList2();
        ArrayList<ArrayList<String>> main=s.getInstance().getArrayList3();
        ImageView iv = (ImageView) findViewById(R.id.imageView3);
        //iv.getDrawable();
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

        if(string.equals("")==false) {
            name.add(string);
            Intent i = new Intent(this, MainActivity.class);
            number.add(no);
            i.putExtra("picname",fileName);
            startActivity(i);
           main.add(name);
           main.add(number);
            startActivity(i);
            finish();
        }

    }



    private void openGallery() {
        Intent gallery =
                new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}

