package com.mycompany.java_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author MATI
 */

public class java_sql {

    /*AQUI PONDREMOS EL DRIVER A CONECTAR Y LA URL DE CONEXION*/
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/libreria2";
    /*le pasamos nuestros datos de conexion de mysql*/
    final String usuario = "root";
    final String password = "lolo2000";
    Connection conexion = null;
    Statement statement = null;
    ResultSet rs;

    /*Aqui me encargo de crear la conexion a la base de datos*/
    protected void ConectSql() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        conexion = (Connection) DriverManager.getConnection(URL_CONEXION, usuario, password);

    }

    /*Metodo donde le pasamos por parametro los datos que queremos insertar*/
    protected void InsertarValores(String dni, String nombre, String Apellido) throws SQLException, ClassNotFoundException {
        /*metemos el primer insert de la tabla*/
        String insertTableSQL = "INSERT INTO cliente(dni,nombre,apellido) VALUES('" + dni + "','" + nombre + "','" + Apellido + "');";
        PreparedStatement sentencia = conexion.prepareStatement(insertTableSQL);
        statement = conexion.createStatement();
        int res = statement.executeUpdate(insertTableSQL);
        System.out.println("se han insertado " + res + " tablas.");
        CloseStatement(statement);
    }

    /*Aqui metemos metodo donde eliminará los valores que nosotros le pasemos por parametro*/
    protected void EliminarValores(String dni) throws SQLException, ClassNotFoundException {
        String deleteSQL = "DELETE FROM cliente WHERE (dni='" + dni + "');";
        PreparedStatement sentencia = conexion.prepareStatement(deleteSQL);
        statement = conexion.createStatement();
        int res = statement.executeUpdate(deleteSQL);
        System.out.println("Se ha eliminado " + res + " clientes");
        CloseStatement(statement);
    }

    /*Aqui vamos a modificar los valores donde creamos parametros se pida por teclado y utilizamos switch para la seleccion  que querramos*/
    protected void ModificarValores() throws SQLException, ClassNotFoundException {
        Scanner tc = new Scanner(System.in);
        System.out.println("Dame tu dni : ");
        String dni = tc.nextLine(); //dni almacenado 
        Statement statement = conexion.createStatement();
        String dnis2 = "SELECT dni FROM cliente";
        ResultSet result = statement.executeQuery(dnis2);
        //comprobar si existe el dni :)
        String dnis;
        while (result.next()) {
            dnis = result.getString("dni");
            if (dni.equals(dnis)) {
                System.out.println("1-MODIFICAR NOMBRE 2-MODIFICAR APELLIDO 3-MODIFICAR DNI ");
                System.out.println("Opcion -> ");
                int valor = tc.nextInt();
                /*SWITCH DE LO QUE VAMOS A MODIFICAR*/
                switch (valor) {
                    case 1:
                        Scanner tc2 = new Scanner(System.in);
                        System.out.println("Dime el nuevo nombre");
                        String nombre = tc2.nextLine();
                        String sentenciaNombre = "UPDATE cliente SET nombre ='" + nombre + "' WHERE (dni = '" + dnis + "');";
                        System.out.println(sentenciaNombre);
                        Statement statement2 = conexion.createStatement();
                        statement2.execute(sentenciaNombre);
                        CloseStatement(statement2);
                        break;

                    case 2:
                        Scanner scaner = new Scanner(System.in);
                        System.out.println("Dime el nuevo apellido");
                        String apellido = scaner.nextLine();
                        String sentenciaApellido = "UPDATE cliente SET apellido ='" + apellido + "' WHERE (dni = '" + dnis + "')";
                        System.out.println(sentenciaApellido);
                        Statement statement3 = conexion.createStatement();
                        statement3.execute(sentenciaApellido);
                        CloseStatement(statement3);
                        break;

                    case 3:
                        Scanner scaner2 = new Scanner(System.in);
                        System.out.println("Dime el nuevo dni");
                        String dninuevo = scaner2.nextLine();
                        String sentenciaDni = "UPDATE cliente SET dni ='" + dninuevo + "' WHERE (dni = '" + dnis + "')";
                        System.out.println(sentenciaDni);
                        Statement statement4 = conexion.createStatement();
                        statement4.execute(sentenciaDni);
                        CloseStatement(statement4);
                        break;

                }
            }
        }

        CloseStatement(statement);
    }

    /*Aqui se producira las consulta a mysql donde hacemos pedir todo por teclado con swicth y case*/
    protected void ConsultaLike() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("1-Bucar un libro 2-Buscar Nombre cliente 3-Buscar un prooverdor");
        System.out.print("Que deseas buscar ? -> ");
        int seleccion = teclado.nextInt();

        switch (seleccion) {
            case 1:
                Scanner teclado2 = new Scanner(System.in);
                System.out.println("Dime el nombre del libro que quieres buscar : ");
                String nombrelibro = teclado2.nextLine();
                Statement statement2 = conexion.createStatement();
                rs = statement2.executeQuery("SELECT nombre FROM libros WHERE nombre LIKE'" + nombrelibro + "%'");
                while (rs.next()) {
                    String Nombrelibros = rs.getString("nombre");
                    System.out.println("-------------------------------");
                    System.out.println("Nombre Libro: " + Nombrelibros);
                    System.out.println("-------------------------------");

                }
                CloseStatement(statement2);
                break;

            case 2:
                Scanner teclado3 = new Scanner(System.in);
                System.out.println("Dime el nombre del cliente que quieres buscar : ");
                String nombreUsuario = teclado3.nextLine();
                Statement statement3 = conexion.createStatement();
                rs = statement3.executeQuery("SELECT nombre FROM cliente WHERE nombre LIKE'" + nombreUsuario + "%'");
                while (rs.next()) {
                    String clienteNombre = rs.getString("nombre");
                    System.out.println("-------------------------------");
                    System.out.println("Nombre Persona: " + clienteNombre);
                    System.out.println("-------------------------------");
                }

                CloseStatement(statement3);

                break;

            case 3:
                Scanner teclado4 = new Scanner(System.in);
                System.out.println("Dime el nombre del proovedor o la incial que desea buscar:");
                String NombreProveedor = teclado4.nextLine();
                Statement statement4 = conexion.createStatement();
                rs = statement4.executeQuery("SELECT Nombre_proovedor FROM proveedor where Nombre_proovedor LIKE '" + NombreProveedor + "%'");
                while (rs.next()) {
                    
                    String nombreProve = rs.getString("Nombre_proovedor");
                    System.out.println("-------------------------------");
                    System.out.println("Nombre del proveedor : " + nombreProve);
                    System.out.println("-------------------------------");
                }
                CloseStatement(statement4);
                break;
        }

    }

    /*Aqui agrupamos las tablas segun lo que nosotros pensamos que deberia ser aqui esta vez ya establecemos las busquedas*/
    protected void ConsultaGroupBy() throws SQLException {
        Scanner group = new Scanner(System.in);
        System.out.println("1-Mostrar precio de más caro a más barato 2-Mostrar precio de más barato al más Caro");
        int seleccion = group.nextInt();
        switch (seleccion) {
            case 1:
                Statement statement = conexion.createStatement();
                rs = statement.executeQuery("SELECT precio,Cliente_dni from ticket_compra GROUP BY Cliente_dni ORDER BY AVG(precio)DESC;");
                while (rs.next()) {
                    String precio = rs.getString("precio");
                    String dni = rs.getString("Cliente_dni");
                    if (dni == null) {
                        System.out.println("Precio Libro : " + precio + " Libro del usuario con dni: Sin dueño)");
                    } else {
                        System.out.println("Precio Libro : " + precio + " Libro del usuario con dni: " + dni);
                    }
                }
                CloseStatement(statement);
                break;
            case 2:
                Statement statement2 = conexion.createStatement();
                rs = statement2.executeQuery("SELECT precio,Cliente_dni from ticket_compra GROUP BY Cliente_dni ORDER BY AVG(precio)ASC;");
                while (rs.next()) {
                    String precio = rs.getString("precio");
                    String dni = rs.getString("Cliente_dni");
                    if (dni == null) {
                        System.out.println("Precio Libro : " + precio + "  y el dueño del libro es dni: Sin dueño)");
                    } else {
                        System.out.println("Precio Libro  : " + precio + " y el dueño del libro es dni " + dni);
                    }
                }
                CloseStatement(statement2);
                break;
        }

    }

    /*Inner join pedimos por teclado las opciones que desea mostrando las diferentes posibilidades que tiene*/
    protected void ConsultaInnerJoin() throws SQLException {
        Scanner tecladosInner = new Scanner(System.in);
        System.out.println("Que deseas hacer? ");
        System.out.println("1-Mostrar Cliente con su ticket? 2-Mostrar Proveedores con y los identificadores de la Editorial? 3-Mostrar Libro y su proovedor? ");
        int SeleccionInnerJoin = tecladosInner.nextInt();
        switch (SeleccionInnerJoin) {
            case 1:
                Statement statment = conexion.createStatement();
                rs = statment.executeQuery("SELECT * FROM cliente cl JOIN ticket_compra tc ON cl.dni = tc.Cliente_dni");
                while (rs.next()) {
                    String dni = rs.getString("dni");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String idFactura = rs.getString("idFactura");
                    String precio = rs.getString("precio");
                    System.out.println("DNI|" + dni + "| |Nombre|" + nombre + " ||apellido ||" + apellido + "|| NºFactura | |" + idFactura + " || Precio Libro ||" + precio);
                }
                CloseStatement(statement);
                break;
            case 2:
                Statement statement2 = conexion.createStatement();
                rs = statement2.executeQuery("SELECT*FROM proveedor pr JOIN editorial ed ON pr.Editorial_idEditorial = ed.idEditorial");
                while (rs.next()) {
                    String idproveedor = rs.getString("idProveedor");
                    String NombreProveedor = rs.getString("Nombre_proovedor");
                    String idEditorial = rs.getString("Editorial_idEditorial");
                    System.out.println("=============================================");
                    System.out.println("Identificador Proveedor|" + idproveedor + "| |Nombre Proveedor|" + NombreProveedor + " ||Identificador Editorial ||" + idEditorial);
                    System.out.println("=============================================");
                }
                CloseStatement(statement2);
                break;
            case 3:
                Statement statement3 = conexion.createStatement();
                rs = statement3.executeQuery("SELECT * FROM libros li JOIN libros_y_proveedores lp ON li.id_libro = lp.Proveedor_idProveedor JOIN proveedor pr ON pr.idProveedor = lp.Proveedor_idProveedor");
                while (rs.next()) {

                    String NombreLibro = rs.getString("nombre");
                    String Nombreproveedor = rs.getString("Nombre_proovedor");
                    System.out.println("=============================================");
                    System.out.println("Nombre del Libro -> " + NombreLibro);
                    System.out.println("Nombre del Proveedor -> " + Nombreproveedor);
                    System.out.println("=============================================");
                }
                CloseStatement(statement3);
                break;
        }

    }

    /*Metodo donde cerramos los statement de esa forma ahorramos mucho codigo para cerrar cada conexion solo sera necesario pasarle el statement*/
    private void CloseStatement(Statement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
}
