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
        validarMainActivity();


    }

    private void validarMainActivity() {

        String usuario = getApplicationContext().getSharedPreferences("dataUserCache", Context.MODE_PRIVATE).getString("user", "0");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (usuario.equalsIgnoreCase("0")) {

                    Intent i = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(i);

                }
            }
        }, 2000);
    }

