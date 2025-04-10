package com.example.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashscreen extends AppCompatActivity {
    EditText edt_nombre;
    EditText edt_edad;

    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        validarMainActivity()


    }

    private void validarMainActivity() {

        usuario = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("user","0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (usuario.equalsIgnoreCase("0")){
                    Intent i = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(i);
                }else if{

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
        };
    }
}