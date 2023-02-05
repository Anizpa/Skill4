package com.example.skill4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MensajeActivity extends AppCompatActivity {

    TextView msj;
    ListView listaDias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        msj = (TextView) findViewById(R.id.textView2);

        Bundle miBundle = this.getIntent().getExtras();

        if (miBundle != null){
            String nombre = miBundle.getString("nombre");
            String mensj = getString(R.string.titulo);
            msj.setText(mensj + nombre);
        }


        listaDias = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.combo_dias, android.R.layout.simple_list_item_1);
        listaDias.setAdapter(adaptador);

        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), "Seleccionado: " +adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onclick(View view){
        finish();
    }
}