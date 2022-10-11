/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2FlujosFicheros;

import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 * La clase StringTokenizer se usa para separar una cadena de caracteres en una serie de elementos o tokens.
 * Se incluye en el paquete java.util
 * Los tokens se separan mediante delimitadores.
 * Un objeto StringTokenizer se construye a partir de un objeto String.
 * hasMoreTokens() devuelve true si hay más tokens que obtener en la cadena.
 * nextToken() devuelve un String con el siguiente token.
 * countTokens()
 * Delimitadores
 * espacio en blanco, \t,\n, \r, \f (avance página) 
 */
public class Tokens {
    public static void main(String args[]){
        String s = "uno, dos, tres, cuatro. cinco";
        StringTokenizer st = new StringTokenizer(s,",");                                                                      
        while (st.hasMoreTokens())                                                                                        
            System.out.println(st.nextToken());
    }
}
