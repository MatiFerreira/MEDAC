package com.example.yelmoscines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listalayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listado listado = new Listado();
        ArrayList<ListaEntrada> datospeli = listado.getDatosPelicula();
        listalayout = (ListView) findViewById(R.id.ListView_listado);

        listalayout.setAdapter(new Adaptador(this, R.layout.articulopelicula, datospeli) {

            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((ListaEntrada) entrada).getTextoArriba());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((ListaEntrada) entrada).getTextoAbajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((ListaEntrada) entrada).getIdImagen());

                }
            }
        });

        listalayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListaEntrada seleccion = (ListaEntrada) parent.getItemAtPosition(position);
                CharSequence texto = "Descripcion: " + seleccion.getTextoAbajo();
                Context context = getApplicationContext();
                int longitud = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, texto, longitud);
                switch (position) {
                    case 0:
                        paginaWebBladeRunner();
                        break;
                    case 1:
                        paginaWebAmercanPhysco();
                        break;
                    case 2:
                        paginawebAmericanAssasin();
                        break;
                    case 3 :
                            OtraActividad(view);
                        break;
                    case 4:
                        paginaWebTaxiDriver();
                        break;
                }
                toast.show();
            }
        });


    }

    private void paginaWebBladeRunner() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sensacine.com/peliculas/pelicula-197686/criticas-espectadores/"));
        startActivity(intent);
    }

    private void paginaWebAmercanPhysco() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sensacine.com/peliculas/pelicula-24847/criticas-espectadores/"));
        startActivity(intent);
    }

    private void paginawebAmericanAssasin() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.espinof.com/criticas/american-assassin-su-trio-protagonista-no-logra-salvar-un-thriller-mediocre/"));
        startActivity(intent);
    }
    private void paginaWebTaxiDriver(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sensacine.com/peliculas/pelicula-308/criticas-espectadores/"));
        startActivity(intent);
    }

    public void OtraActividad(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra(null,"Probando pasar una cadena de texto entre intents");
        startActivity(intent);
    }

}