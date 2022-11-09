package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.texto1);
        et2 = findViewById(R.id.texto2);
        tv1 = findViewById(R.id.resultado);
    }

    public void sumar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);
        int suma = nro1 + nro2;
        String resu = String.valueOf(suma);
        tv1.setText(resu);
    }

    public void restar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int valortexto = Integer.parseInt(valor1);
        int valortexto2 = Integer.parseInt(valor2);
        int result = valortexto-valortexto2;
        String strResultado = String.valueOf(result);
        tv1.setText(strResultado);
    }

    public void dividir(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int valortexto = Integer.parseInt(valor1);
        int valortexto2 = Integer.parseInt(valor2);
        try {
            int result = valortexto / valortexto2;
            String strResultado = String.valueOf(result);
            tv1.setText(strResultado);
        }catch (Exception e){
            tv1.setText("0");
        }

    }

    public void multiplicar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int valortexto = Integer.parseInt(valor1);
        int valortexto2 = Integer.parseInt(valor2);
        int result = valortexto*valortexto2;
        String strResultado = String.valueOf(result);
        tv1.setText(strResultado);
    }
}