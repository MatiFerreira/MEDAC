package com.example.intent_implicito;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btn;
    private final String texto = "Hola a TODOS SOY UNA APP EJECUTANDOSE :)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activar flecha para ir atras
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);// en el manifest de android se indica cual sera a donde llevara la flecha
        //fuerza y carga el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);// esto activa la posibilidad de visualizar el la parte superio el icono
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);// indica cual es la imagen del icono
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.buttonAcceptar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ACCEDEMOS AL SEGUNDO ACTIVITY DONDE MANDAREMOS EL STRING
                Intent intent = new Intent(MainActivity.this,MainActivity2.class); //le pasas donde se encuentra el contexto osea aqui y donde se dirige osea secondactivity
                intent.putExtra("texto",texto);
                startActivity(intent);
            }
        });
    }
}