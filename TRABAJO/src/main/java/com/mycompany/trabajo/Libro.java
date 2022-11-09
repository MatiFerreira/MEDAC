package com.mycompany.trabajo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 1810d
 */
public class Libro {

    String nombre, libro, apellido;

    public Libro(String s, String s1, String s2) {
        this.nombre = s;
        this.libro = s1;
        this.apellido = s2;
    }

    public Libro() {
        //Constructor vacio
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + this.nombre + ", libro=" + this.libro + ", apellido=" + this.apellido+"}";
    }

}
