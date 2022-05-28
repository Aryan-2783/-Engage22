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

public class demseg extends AppCompatActivity {
    Button but1;
    EditText et1;
    EditText et2;
    EditText et3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demseg);
        et1=findViewById(R.id.Salary);
        et2=findViewById(R.id.FamilyS);
        et3=findViewById(R.id.Age);
        but1=findViewById(R.id.dembut);
        tv=findViewById(R.id.texy);
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        final Python py=Python.getInstance();
        PyObject pyobj= py.getModule("demgrap");
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PyObject obj=pyobj.callAttr("demo",et1.getText().toString(),et2.getText().toString(),et3.getText().toString());
                tv.setText(obj.toString());
            }
        });
    }
}