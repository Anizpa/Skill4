package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView etiqueta;
    EditText campo1, campo2;

    CheckBox c1, c2;
    RadioButton r1;

    ToggleButton tg1;
    TextView etiEstado;
    Switch sw;

    private static final String TAG="Seguimiuento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta = (TextView) findViewById(R.id.textView);
        campo1 = (EditText) findViewById(R.id.txt1);
        campo2 = (EditText) findViewById(R.id.txt2);

        c1 = (CheckBox) findViewById(R.id.check1);
        c2 = (CheckBox) findViewById(R.id.check2);
        r1 = (RadioButton) findViewById(R.id.rdbtn);

        tg1 = (ToggleButton) findViewById(R.id.tgbtn);
        etiEstado= (TextView) findViewById(R.id.etiSel);
        sw = (Switch) findViewById(R.id.switch1);

        Log.i("info", "Valor informacion");
        Log.i( TAG, "Mensaje seguimiento 1");
        Log.d("debug", "Valor debug");
        Log.w("warning", "Valor warning");
        Log.e("error", "Valor error");
        Log.d("verbose", "Valor verbose");




    }

    public void onclick(View view){
        /*switch (view.getId()){
            case R.id.btn1:
                obtenerInfo();
                break;
        }*/

        if(view.getId()==R.id.btn1){
            validar();
        }

        if(view.getId()==R.id.rdbtn){
            validar();
        }

        if(view.getId() ==R.id.tgbtn){
            if(tg1.isChecked()){
                etiEstado.setText("Boton On");
            }else{
                etiEstado.setText("Boton Off");

            }
        }

        if(view.getId() ==R.id.switch1){
            if(sw.isChecked()){
                etiEstado.setText("Boton On");
            }else{
                etiEstado.setText("Boton Off");

            }
        }


    }

    private void obtenerInfo(){
        String pass = campo2.getText().toString();
        String parrafo = campo1.getText().toString();

        etiqueta.setText("Nuevo titulo");
        Toast.makeText(getApplicationContext(), "Dato Parrafo: " + parrafo, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Dato Pass: " + pass, Toast.LENGTH_SHORT).show();

    }

    private void validar(){
        String cad="Seleccionado:  \n";

        if (c1.isChecked()==true || r1.isChecked()){
            cad += "1";
        }else{
            cad += "2";
        }

        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_SHORT).show();

    }
}