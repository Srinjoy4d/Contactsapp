package com.example.srinjoy10.contactsapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import java.util.*;
/**
 * Created by srinjoy10 on 25-12-2016.
 */
public class s extends AppCompatActivity {

    private static s instance = null;
    public ArrayList<String> name = new ArrayList<String>();
    public ArrayList<String> number = new ArrayList<String>();
    public ArrayList<String> d=new ArrayList<String>();
    public ArrayList<ArrayList<String>> main = new ArrayList<ArrayList<String>>();

    protected s() {

    }

    public static s getInstance() {
        if (instance == null) {
            instance = new s();
        }
        return instance;
    }
    public ArrayList<String> getArrayList1()
    {
        return name;
    }
    public ArrayList<String> getArrayList2()
    {
        return number;
    }
    public ArrayList<ArrayList<String>> getArrayList3()
    {
        return main;
    }
    public ArrayList<String> getArrayd()
    {
        return d;
    }
}