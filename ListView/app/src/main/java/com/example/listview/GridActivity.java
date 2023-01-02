package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    List<String> Names;
    GridView gridView;
    private int contador =0;
    myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.gridview);
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

        /*ES EL ADAPATAOR  LA FORMA VISUAL EN QUE VA MOSTRAR NUESTRO DATOS*/
        /*DENTRO DE ANDROID R.LAYOUT INDICAMOS EL VALOR O NAME DEL LOS COMPONENTES ED LA LISTA*/
        // ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Names);
        /*METEMOS EL ADAPTADOR EN NUESTRO LISTVIEW (enlazar)*/
        //listView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "CLICKED "+Names.get(position), Toast.LENGTH_SHORT).show();/*AL HACER CLICK DEVUELVE EL NOMBRE CON TOAST DE LA POSICION QUE SE ENCUENTRE*/

            }
        });
        /*enlazamos nuestro adaptador personalizado*/
         myadapter = new myadapter(this,R.layout.griditem,Names);
        gridView.setAdapter(myadapter);
        //tenemos que registrar el contextmenu
        registerForContextMenu(gridView); /*LE decimos que cuando haga click sobre un gridview va ha*/

    }
 /*ESTO NOS VA A SERVIR PARA INFLAR ESE TOOLBAR CON DATOS*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }
    /*El comportamiento que va a tener al seleccionar los  botoncito*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item: /*id de menu.xml*/
                /*añade nuevo nombre con nuevo valor :)*/
                this.Names.add("ADDED nº "+(++contador));
                this.myadapter.notifyDataSetChanged(); /*ENVIA Y ACTUALIZA LOS NUEVOS DATOS A NUESTRO ADAPTADOR :) */
                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    /*inflamos layout de context_menu*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(Names.get(info.position)); /*obtiene la informacion del nuestro arraylist pasandole la posicion donde se obtione por el menuinfo*/
        menuInflater.inflate(R.menu.context_main,menu);

    }
    /*MANEJAMOS EVENTO CLICK DEL CONTEXT_MENU*/
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo(); /*optiene la informacion de donde nosotros hagamos click*/
        switch (item.getItemId()){
            case R.id.delete_item:
                this.Names.remove(info.position); /*borramos item seleccionado obtiendo el valor de la posicion sacada de info*/
                this.myadapter.notifyDataSetChanged(); /*ENVIA Y ACTUALIZA LOS NUEVOS DATOS A NUESTRO ADAPTADOR :) */

                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}