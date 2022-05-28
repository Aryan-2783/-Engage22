
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

public class Geographic extends AppCompatActivity {
    Button but16;
    EditText et11;
    EditText et21;
    EditText et31;
    TextView tva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geographic);
        et11=findViewById(R.id.abcd);
        et21=findViewById(R.id.xyz);
        et31=findViewById(R.id.wrt);
        but16=findViewById(R.id.geogbut);
        tva=findViewById(R.id.geohxy);
        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        final Python py=Python.getInstance();
        PyObject pyobj= py.getModule("geogra");
        but16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PyObject obj=pyobj.callAttr("gego",et11.getText().toString(),et21.getText().toString(),et31.getText().toString());
                tva.setText(obj.toString());
            }
        });
    }
}