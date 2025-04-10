package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_nombre;
    EditText edt_edad;
    Button btn_guardar;
    Spinner Categorias;
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);
        btn_guardar = findViewById(R.id.btn_guardar);
        Categorias =findViewById(R.id.spinner2);

        String[] opciones = {"Cine", "Musica", "Deporte"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        Categorias.setAdapter(adapter);

        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor = sharedPreferences.edit();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesar();
            }
        });

    }

    private void procesar() {
        String name = edt_nombre.getText().toString();
        String edad = edt_edad.getText().toString();
        String seleccion= Categorias.getSelectedItem().toString();
        if (name.isEmpty()||edad.isEmpty()){
            Toast.makeText(MainActivity.this,"por favor llenar todos los campos",Toast.LENGTH_LONG).show();
        }else{
            if (seleccion.equals("Cine")) {
                editor.putString("user",edt_nombre.getText().toString());
                editor.commit();
                editor.putString("user",edt_edad.getText().toString());
                editor.commit();

                Intent i = new Intent(MainActivity.this, cine.class);
                startActivity(i);


            } else if (seleccion.equals("Musica")) {
                editor.putString("user",edt_nombre.getText().toString());
                editor.commit();
                editor.putString("user",edt_edad.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this, musica.class);
                startActivity(i);

            } else if (seleccion.equals("Deportes")) {
                editor.putString("user",edt_nombre.getText().toString());
                editor.commit();
                editor.putString("user",edt_edad.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this, deporte.class);
                startActivity(i);

            }
            }

        }
    }
