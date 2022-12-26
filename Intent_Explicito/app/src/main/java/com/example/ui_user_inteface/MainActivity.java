package com.example.ui_user_inteface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private final String texto = "Hola a TODOS SOY UNA APP EJECUTANDOSE :)";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.buttonAcceptar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ACCEDEMOS AL SEGUNDO ACTIVITY DONDE MANDAREMOS EL STRING
                Intent intent = new Intent(MainActivity.this,SecondActivity.class); //le pasas donde se encuentra el contexto osea aqui y donde se dirige osea secondactivity
                intent.putExtra("texto",texto);
                startActivity(intent);
            }
        });
    }
}