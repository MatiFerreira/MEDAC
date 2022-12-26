package com.example.ui_user_inteface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn; //Indicamos que debe ser tipo boton por que la accion es en un boton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.buttonAcceptar); //buscamos la id del boton que le hayamos puesto ademas de hacer casting para indicar que sera de tipo boton y no el valor de referencia
        btn.setOnClickListener(new View.OnClickListener() {//llamamos al metodo
            @Override
            public void onClick(View v) {//este codigo se genera y dentro de ella podemos trabajar e  indicar que va hacer
                Toast.makeText(MainActivity.this, "Datos Aceptados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}