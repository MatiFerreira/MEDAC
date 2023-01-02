package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class myadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String>nombres;

    public myadapter(Context context,int layout , List<String>nombres){
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override
    public int getCount() { /*NOS DA EL NUMEROS DE ELEMENTOS QUE VA A DIBUJAR */
        return nombres.size();
    }

    @Override
    public Object getItem(int position) {/*DEVUELVE EL ITEM DE LA COLECCION QUE LE DAMOS LA POSICION */
        return nombres.get(position);
    }

    @Override
    public long getItemId(int id) {/*DELVUELVE EL ID del item*/
        return id;
    }

    @Override
    public View getView(int positicion, View convertView, ViewGroup parent) { /*coge los item y dibuja lo que queremos hacer*/
        //viewholderAdapter basicamente actua como almacenador de la vista
        viewHolder holder;
        if (convertView ==null){
            /*SE INFLA LA VISTA QUE HA LLEGADO CON NUESTRO LAYOUT PERSONALIZADO*/
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);
            holder = new viewHolder();/*ESTA CREARIA LA CLASE POR CADA TEXTVIEW ALMACENANDO EL VALOR*/
            /*referenciamos el elemento a modificar y lo rellenamos*/
            holder.textView = convertView.findViewById(R.id.editTextTextPersonName); /*el view viene del layoutinflater.inflate(r.layout.list_item)... por eso podemos acceder al findview*/
            convertView.setTag(holder);
        }else{
            holder = (viewHolder) convertView.getTag();

        }
        /*TRAEMOS EL VALOR ACTUAL */
         String currentname =  nombres.get(positicion);/*Recoge el valor string segun la posicion donde entre*/
        /*referenciamos el elemento a modificar y lo rellenamos*/
        holder.textView.setText(currentname);
        /*devolvemos la vista inflada y modificada*/
        return convertView;
    }

    static class viewHolder{
        private TextView textView;

    }
}
