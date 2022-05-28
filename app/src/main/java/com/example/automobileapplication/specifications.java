package com.example.automobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class specifications extends AppCompatActivity {
    TextView bestspecos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifications);
        bestspecos=findViewById(R.id.spocos);
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        final Python py=Python.getInstance();
        PyObject pyobj= py.getModule("main");

        PyObject obj=pyobj.callAttr("specific");
        String str=obj.toString();
        bestspecos.setText(str);
    }
}