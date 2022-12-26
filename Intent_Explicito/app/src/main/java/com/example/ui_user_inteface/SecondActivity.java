package com.example.ui_user_inteface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.textViewsecond);

        //tomar los datos del intent
        Bundle bundle = getIntent().getExtras(); // es como una caja donde guarda los datos de la otra actividad
        if (bundle.getString("texto") != null && bundle != null){
            String datos = bundle.getString("texto");
            textView.setText(datos);
            Toast.makeText(this, datos, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Is empty", Toast.LENGTH_SHORT).show();
        }
    }
}