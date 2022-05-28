package com.example.automobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class SafestCar extends AppCompatActivity {
TextView bestspecos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safest_car);
        bestspecos=findViewById(R.id.deographicsval);
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        final Python py=Python.getInstance();
        PyObject pyobj= py.getModule("safest");

        PyObject obj=pyobj.callAttr("safety");
        String str=obj.toString();
        bestspecos.setText(str);
    }
}