package com.example.automobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class csegment extends AppCompatActivity {
   TextView butspeca;
   Button but5;
   Button but6;
   Button but7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csegment);
        but5=(Button)findViewById(R.id.butdem);
        but5.setOnClickListener(v -> opendemseg());
        but6=(Button)findViewById(R.id.buttec);
        but6.setOnClickListener(v -> opentechnograp());
        but7=(Button) findViewById(R.id.butgeo);
        but7.setOnClickListener(v -> openGeographic());


    }

    private void openGeographic() {
        Intent intent=new Intent(this,Geographic.class);
        startActivity(intent);
    }

    private void opentechnograp() {
        Intent intent=new Intent(this,technograp.class);
        startActivity(intent);
    }

    private void opendemseg() {
        Intent intent=new Intent(this,demseg.class);
        startActivity(intent);
    }
}