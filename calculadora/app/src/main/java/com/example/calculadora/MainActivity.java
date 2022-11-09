package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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
        try {
            int valortexto = Integer.parseInt(valor1);
            int valortexto2 = Integer.parseInt(valor2);
            int result = valortexto + valortexto2;
            String strResultado = String.valueOf(result);
            tv1.setText(strResultado);
        }catch (Exception e){
            tv1.setText("Solo numeros porfavor");
        }
    }

    public void restar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        try {
            int valortexto = Integer.parseInt(valor1);
            int valortexto2 = Integer.parseInt(valor2);
            int result = valortexto - valortexto2;
            String strResultado = String.valueOf(result);
            tv1.setText(strResultado);
        }catch (Exception e){
            tv1.setText("Solo numeros porfavor");
        }
    }

    public void dividir(View view) {
        try {
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int valortexto = Integer.parseInt(valor1);
            int valortexto2 = Integer.parseInt(valor2);
            int result = valortexto / valortexto2;
            String strResultado = String.valueOf(result);
            tv1.setText(strResultado);
        } catch (ArithmeticException e) {
            tv1.setText("0");
        }catch (Exception z){
            tv1.setText("NUMEROS PORFAVOR");
        }
    }

    public void multiplicar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        try {
            int valortexto = Integer.parseInt(valor1);
            int valortexto2 = Integer.parseInt(valor2);
            int result = valortexto * valortexto2;
            String strResultado = String.valueOf(result);
            tv1.setText(strResultado);
        }catch (Exception e){
            tv1.setText("Solo numeros porfavor");
        }
    }
}