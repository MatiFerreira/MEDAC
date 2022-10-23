import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {
    /**
     * Creo un scanner para pedir datos por consola. Le doy 5 opciones al usuario.
     * La 4 es para salir del bucle do while y del programa
     */
    public static void main(String[] args) {
        int opcion = 0;
        //Enrtro en el do mientras no sea 5
        do {
            Scanner sc = new Scanner(System.in);
            //intenta esto si no dame el error
            try {
                GeneradorDom gD = new GeneradorDom();
                System.out.println(
                        "Dime la opcion : \n 1.Procesar el documento XML creado \n 2.Guardar los valores del documento XML en otro fichero \n 3.Mostrar valores del fichero \n 4.Crear un objeto con los valores del XML. \n 5.Salir del programa");
                System.out.print("OPCION NUMERO? --> ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        // Procesar el documento XML creado.
                        gD.generarDocumento();
                        System.out.println();
                        System.out.println("-----------------------------------------");
                        System.out.println("El documento se ha generado correctamente");
                        System.out.println("-----------------------------------------");
                        System.out.println();
                        break;
                    case 2:
                        // TODO MIRAR  Guardar los valores del documento XML en otro fichero
                        gD.copiarXml();
                        System.out.println();
                        System.out.println("-----------------------------------------");
                        System.out.println("El documento se Copiado en el archivo copia.txt en formato de texto.");
                        System.out.println("-----------------------------------------");
                        System.out.println();
                        break;
                    case 3:
                        // Mostrar valores del fichero
                        gD.leerXml();
                        break;
                    case 4:
                        // TODO Crear un objeto con los valores del XML. Mostrar valores de dicho objeto.
                        break;
                    default:
                        break;
                }


            } catch (Exception errorValor) {
                System.out.println("PARAMETRO NO VALIDO :(");
            }
        } while (opcion != 5);
    }
}
