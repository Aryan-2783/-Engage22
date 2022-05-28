package com.example.automobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity2 extends AppCompatActivity {
    Button but1;
    Button but2;
    Button butspec;
    Button but3;
    Button but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        butspec=(Button)findViewById(R.id.butspec);
        butspec.setOnClickListener(v -> openspecifications());



     if(!Python.isStarted())
         Python.start(new AndroidPlatform(this));
     final Python py=Python.getInstance();
     PyObject pyobj= py.getModule("main");

        PyObject obj=pyobj.callAttr("specific");
        String str=obj.toString();

        but4=(Button) findViewById(R.id.but4);
        but4.setOnClickListener(v -> openSafestCar());
        but3=(Button) findViewById(R.id.but3);
        but3.setOnClickListener(v -> opendailyuse());

    but2=(Button) findViewById(R.id.but2);
    but2.setOnClickListener(v -> opencsegment());
    but1=(Button)findViewById(R.id.but1);
    but1.setOnClickListener(v -> {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    });
    }



    private void opendailyuse() {
        Intent intent=new Intent(this,dailyUse.class);
        startActivity(intent);
    }

    private void openSafestCar() {
        Intent intent=new Intent(this,SafestCar.class);
        startActivity(intent);
    }

    private void openspecifications() {
        Intent intent=new Intent(this,specifications.class);
        startActivity(intent);
    }

    private void opencsegment() {
        Intent intent=new Intent(this,csegment.class);
        startActivity(intent);
    }
}