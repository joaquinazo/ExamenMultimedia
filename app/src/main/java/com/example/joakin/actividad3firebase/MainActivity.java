package com.example.joakin.actividad3firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.joakin.actividad3firebase.R;

public class MainActivity extends AppCompatActivity {
    Button SVButton;
    EditText ETUSer;
    EditText ETMensaje;
    TextView ETHOLA;
    TextView ETMUNDO;
    Button BTEn;
    Button BTSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityC mainActivity= new MainActivityC(this);
        SVButton = (Button)findViewById(R.id.Send);
        ETUSer = (EditText)findViewById(R.id.nombre);
        //ETMensaje = (EditText)findViewById(R.id.me);
        ETMUNDO = (TextView) findViewById(R.id.PALABRA2);
        ETHOLA =(TextView) findViewById(R.id.PALABRA1);
        BTEn = (Button) findViewById(R.id.ENGLISHBUTTON);
        BTSp = (Button) findViewById(R.id.SPANISHBUTTON);
        SVButton.setOnClickListener(mainActivity);
        BTEn.setOnClickListener(mainActivity);
        BTSp.setOnClickListener(mainActivity);
    }

}
