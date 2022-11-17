package com.example.yelmoscines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class Adaptador extends BaseAdapter {
    private ArrayList<?> entrada;
    private int R_layout_IsView;
    private Context context;

    public Adaptador(Context context, int r_layout_IsView, ArrayList<?> entrada) {
        super();
        this.context = context;
        this.entrada = entrada;
        this.R_layout_IsView = r_layout_IsView;
    }

    @Override
    public View getView(int pos, View view, ViewGroup group) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R_layout_IsView, null);
        }
        onEntrada(entrada.get(pos), view);
        return view;
    }

    @Override
    public int getCount() {
        return entrada.size();
    }

    @Override
    public Object getItem(int posicion) {
        return entrada.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }


    public abstract void onEntrada(Object entrada, View view);
}


