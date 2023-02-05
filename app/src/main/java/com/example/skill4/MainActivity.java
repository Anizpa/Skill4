package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
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

    Spinner comboDias;


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
        comboDias = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_dias, android.R.layout.simple_spinner_item);
        //Tambien se puede hacer creando un arraylist string desde el meain y cambiando esta linea por new ArrayAdapters y nombrando el arrayList al final
        comboDias.setAdapter(adapter);

        comboDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Seleccionado: " +adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });



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

        if(view.getId() == R.id.btn2){
            Intent miIntent = new Intent(MainActivity.this, MensajeActivity.class);

            Bundle miBundle = new Bundle();
            miBundle.putString("nombre", etiqueta.getText().toString());

            miIntent.putExtras(miBundle);

            startActivity(miIntent);
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