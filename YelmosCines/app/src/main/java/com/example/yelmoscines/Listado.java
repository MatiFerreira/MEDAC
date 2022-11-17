package com.example.yelmoscines;

import java.util.ArrayList;

public class Listado {
    public ArrayList<ListaEntrada>datosPelicula;

        Listado(){
            datosPelicula = new ArrayList<ListaEntrada>();
            datosPelicula.add(new ListaEntrada(R.drawable.blade,"blade Runner 2049","es una película neo-noir y de ciencia ficción estadounidense dirigida por Denis Villeneuve, estrenada en 2017"));
            datosPelicula.add(new ListaEntrada(R.drawable.american,"American Psycho ","es una película estadounidense de 2000 de terror y humor negro coescrita y dirigida por Mary Harron, basada en la novela homónima de Bret Easton Ellis"));
            datosPelicula.add(new ListaEntrada(R.drawable.assasin,"American Assassin","es una película de suspenso y acción de 2017 dirigida por Michael Cuesta y basada en la novela homónima de 2010 escrita por Vince Flynn"));
            datosPelicula.add(new ListaEntrada(R.drawable.fight,"Fight Club"," es una película satírica estadounidense de 1999 basada en la novela homónima de Chuck Palahniuk. "));
            datosPelicula.add(new ListaEntrada(R.drawable.taxi,"Taxi Driver","Ambientada en la Nueva York de la década de 1970, poco después de que terminara la guerra de Vietnam, se centra en la vida de Travis Bickle, un excombatiente solitario e inestable que debido a su insomnio crónico comienza a trabajar como taxista"));
        }

        public ArrayList<ListaEntrada>getDatosPelicula(){
            return datosPelicula;
        }
}
