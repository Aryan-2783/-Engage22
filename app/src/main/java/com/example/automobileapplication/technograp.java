package com.example.automobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class technograp extends AppCompatActivity {
    Button but1;
    EditText et1;
    EditText et2;
    EditText et3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technograp);
        et1=findViewById(R.id.abc);
        et2=findViewById(R.id.type);
        et3=findViewById(R.id.fuel);
        but1=findViewById(R.id.dembut);
        tv=findViewById(R.id.techxy);
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        final Python py=Python.getInstance();
        PyObject pyobj= py.getModule("techcode");
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PyObject obj=pyobj.callAttr("tech",et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                tv.setText(obj.toString());
            }
        });
    }
}