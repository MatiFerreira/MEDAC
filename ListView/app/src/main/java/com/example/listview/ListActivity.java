package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    List<String>Names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview);
        /*DATOS A MOSTRAR*/
        Names = new ArrayList<>();
        Names.add("PACO");
        Names.add("JUAN");
        Names.add("FERNANDO");
        Names.add("RODRIGO");
        Names.add("MATHIAS");
        Names.add("NATHALIA");
        Names.add("ZARA");
        Names.add("MARTA");
        Names.add("FERNANDO");
        Names.add("RODRIGO");
        Names.add("MATHIAS");
        Names.add("NATHALIA");
        Names.add("ZARA");
        Names.add("MARTA");
        /*ES EL ADAPATAOR  LA FORMA VISUAL EN QUE VA MOSTRAR NUESTRO DATOS*/
                                                                            /*DENTRO DE ANDROID R.LAYOUT INDICAMOS EL VALOR O NAME DEL LOS COMPONENTES ED LA LISTA*/
       // ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Names);
        /*METEMOS EL ADAPTADOR EN NUESTRO LISTVIEW (enlazar)*/
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "CLICKED "+Names.get(position), Toast.LENGTH_SHORT).show();/*AL HACER CLICK DEVUELVE EL NOMBRE CON TOAST DE LA POSICION QUE SE ENCUENTRE*/

            }
        });
        /*enlazamos nuestro adaptador personalizado*/
        myadapter myadapter = new myadapter(this,R.layout.list_item,Names);
        listView.setAdapter(myadapter);
    }
}
