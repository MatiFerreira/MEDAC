package com.mycompany.java_sql;

import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author MATI
 */
public class LIBRERIA_MENU {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int opcion; //almacenamos la opcion
        java_sql conexionsql = new java_sql(); // instancia de la clase
        Scanner tc = new Scanner(System.in); // recibir 
        String sn;//opcion 2 de salida o entrada
        boolean conexiontrue = false;
        /*no terminara hasta que el usuario diga lo contrario*/
        do {

            System.out.println("LIBRERIA");
            System.out.println("Seleccione una de las opciones");
            System.out.println("1-Conexion a base de datos");
            System.out.println("2-Registrar un cliente,eliminar o actualizar lista");
            System.out.println("3-CONSULTAS con JDBC");
            System.out.println("4-Salir de la APP");
            System.out.println("OPCION? ");
            opcion = tc.nextInt();
            /*CREAMOS UN SWITCH DONDE ELIGIRÁ LO QUE EL DESEE Y BLOQUEARA SI NO SE CONECTA A LA CONEXION SERÁ OBLIGATORIO*/
            switch (opcion) {
                case 1:
                    if (!conexiontrue) {
                        conexionsql.ConectSql();
                        conexiontrue = true;
                        System.out.println("SE HA REALIZADO LA CONEXION CORRECTAMENTE");
                    } else {
                        System.out.println("YA ESTAS CONECTADO NO LO INTENTES MAS!!");
                    }
                    break;
                case 2:
                    if (conexiontrue) {
                        int iOpcion;
                        do {
                            System.out.println("1-Crear nuevo cliente 2-Eliminar cliente 3-Modificar Cliente 4-salir");
                            System.out.print("OPCION ->");
                            iOpcion = tc.nextInt();
                            switch (iOpcion) {
                                case 1:
                                    Scanner tc2 = new Scanner(System.in);
                                    System.out.println("dni clientes : ");
                                    String nif = tc2.nextLine();
                                    System.out.println("Nombre Cliente :");
                                    String valor2 = tc2.nextLine();
                                    System.out.println("Apellido Cliente :");
                                    String valor3 = tc2.nextLine();
                                    conexionsql.InsertarValores(nif, valor2, valor3);
                                    break;
                                case 2:
                                    Scanner tc3 = new Scanner(System.in);
                                    System.out.println("DIME EL DNI DEL USUARIO A ELIMINAR: ");
                                    String sDni = tc3.nextLine();
                                    conexionsql.EliminarValores(sDni);
                                    System.out.println("Proceso finalizado.");
                                    break;
                                case 3:
                                    conexionsql.ModificarValores();
                                    break;
                            }

                        } while (iOpcion != 4);

                    } else {
                        System.out.println("No te has conectado a la base de datos :(");
                    }

                    break;

                case 3:
                    /*Aqui elegimos lo que desea hacer y le damos la posibilidad de salir*/
                    if (conexiontrue) {
                        int select;
                        do {
                            System.out.println("1-Hacer consulta like 2-Hacer consulta Join 3-Hacer consulta Group by 4-Salir");
                            System.out.println("Opcion -> ");
                            select = tc.nextInt();

                            switch (select) {
                                case 1:
                                    conexionsql.ConsultaLike();
                                    break;
                                case 2:
                                    conexionsql.ConsultaInnerJoin();
                                    break;
                                case 3:
                                    conexionsql.ConsultaGroupBy();
                                    break;
                            }
                        } while (select != 4);
                    } else {
                        System.out.println("No te has conectado a la bas de datos :( ");

                    }
                    break;

            }
            /*Sentencia de salida*/
        } while (opcion != 4);
    }

}
