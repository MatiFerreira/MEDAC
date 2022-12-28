package com.example.intent_implicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // activar flecha para ir atras
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);// en el manifest de android se indica cual sera a donde llevara la flecha
        textView = (TextView) findViewById(R.id.textViewsecond);
        btn = (Button) findViewById(R.id.GO);

        //tomar los datos del intent
        Bundle bundle = getIntent().getExtras(); // es como una caja donde guarda los datos de la otra actividad
        if (bundle.getString("texto") != null && bundle != null){
            String datos = bundle.getString("texto");
            textView.setText(datos);
            Toast.makeText(this, datos, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Is empty", Toast.LENGTH_SHORT).show();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}