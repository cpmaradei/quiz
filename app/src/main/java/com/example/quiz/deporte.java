package com.example.quiz;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class deporte extends AppCompatActivity {
    TextView txt_nombre,txt_edad;

    public static final String dataUserCache = "dataUser";
    private static final int modo_priv = Context.MODE_PRIVATE;
    String Nombre;
    String Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deporte);
        txt_nombre = findViewById(R.id.txt_nombre);
        txt_edad = findViewById(R.id.txt_name_edad);

        Nombre = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("name","0");
        Edad = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("age","0");

        txt_nombre.setText(Nombre);
        txt_edad.setText(Edad);

    }
}