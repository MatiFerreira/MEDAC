package com.example.lista_de_coche;

import java.util.ArrayList;

public class Listado {
    public ArrayList<ListaEntrada> datos;

    Listado() {

        datos = new ArrayList<ListaEntrada>();
        datos.add(new ListaEntrada(R.drawable.platano, "PLATANO", "el platano es una fruta "));
        datos.add(new ListaEntrada(R.drawable.pera, "PERA", "la pera es una fruta "));
        datos.add(new ListaEntrada(R.drawable.manzana, "MANZANA", "la manzana es una fruta"));
        datos.add(new ListaEntrada(R.drawable.kiwi, "KIWI", "el kiwi es una fruta"));
        datos.add(new ListaEntrada(R.drawable.naranja, "NARANJA", "la naranja es una fruta "));
        datos.add(new ListaEntrada(R.drawable.sandia, "SANDIA", "la sandia es una fruta"));
        datos.add(new ListaEntrada(R.drawable.melon, "MELON", "el melon es una fruta"));
        datos.add(new ListaEntrada(R.drawable.pina, "PIÑA", "la piña es una fruta"));
    }

    public ArrayList<ListaEntrada> devolverDatos() {
        return datos;
    }
}