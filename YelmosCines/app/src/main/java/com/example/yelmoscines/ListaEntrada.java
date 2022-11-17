package com.example.yelmoscines;

public class ListaEntrada {
    private int IdImagen;
    private String textoArriba;
    private String textoAbajo;

    public ListaEntrada(int idimng ,String textoArriba,String textoAbajo){
            this.IdImagen = idimng;
            this.textoAbajo = textoAbajo;
            this.textoArriba = textoArriba;
    }

    public String getTextoArriba(){
        return this.textoArriba;
    }
    public String getTextoAbajo(){
        return this.textoAbajo;
    }

    public int getIdImagen() {
        return IdImagen;
    }

}
