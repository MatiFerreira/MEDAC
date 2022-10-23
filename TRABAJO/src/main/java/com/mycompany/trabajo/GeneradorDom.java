package com.mycompany.trabajo;

import java.io.*;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class GeneradorDom {

    //CREAMOS UN LISTA DE NUESTRAS CLASES A MOSTRAR SE ALMACENA AQUI :)
    private final ArrayList<Libro> listaLibro = new ArrayList<Libro>();

    public GeneradorDom() throws Exception {
        //Constructor vacio
    }

    /*COPIA EL XML EN EL ARCHIVO TXT CON TODO INCLUIDO SE PUEDE SOLO METER LOS DATOS*/
    public void copiarXml() {
        try {
            File fFile1 = new File("./libro.xml");
            BufferedReader bfrReader = new BufferedReader(new FileReader(fFile1));
            File fFile2 = new File("./copia.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fFile2));
            String linea;
            while ((linea = bfrReader.readLine()) != null) {
                bw.write(linea);
                // new line para q pase a siguiente
                bw.newLine();
            }
            bfrReader.close();
            bw.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    //SE VA A MOSTRAR LA LISTA DE OBJETOS CREADO EN CONCRETO LOS LIBROS que se han generado :)
    public void mostrarObjetos() {
        for (Libro valor : listaLibro) {
            System.out.println(valor.toString());
        }

    }

    //AQUI RECORREMOS EL XML Y MOSTRAMOS POR PANTALLA LOS DATOS QUE TENEMOS
    public void leerXml() {
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse("libro.xml");

            // Cojo todas las etiquetas coche del documento
            NodeList list = documento.getElementsByTagName("libro");

            // Recorro las etiquetas
            for (int i = 0; i < list.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = list.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos
                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            System.out
                                    .println(hijo.getNodeName() + "  " + hijo.getTextContent());

                        }

                    }
                    System.out.println("");
                }

            }


        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    //muestra el contenido de todo el archivo txt :) Con el bufferReader lee cada linea hasta que esté vacio
    public void MostrarFicheroTXT() throws IOException {
        BufferedReader bfrReader = new BufferedReader(new FileReader("libro.xml"));
        String valor;
        while ((valor = bfrReader.readLine()) != null) {
            System.out.println(valor);
        }

    }


    //Basicamente creo el objeto libro creo variable temporales vacios y meto esos valores dentro de nuestro objeto recorriendolo
    public void TransformObject() throws ParserConfigurationException, IOException, SAXException {

        String libro = "";
        String nombre = "";
        String apellido = "";
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Obtengo el documento, a partir del XML
        Document documento = builder.parse("libro.xml");

        // Cojo todas las etiquetas coche del documento
        NodeList list = documento.getElementsByTagName("libro");

        for (int i = 0; i < list.getLength(); i++) {
            Node nNode = list.item(i);
            Element elElement = (Element) nNode;
            NodeList nlistsoon = elElement.getChildNodes();
            for (int j = 0; j < nlistsoon.getLength(); j++) {
                Node nNode2 = nlistsoon.item(j);
                if (nNode2.getNodeType() == Node.ELEMENT_NODE && "titulo".equals(nNode2.getNodeName())) {
                    libro = nNode2.getTextContent();
                }

                if (nNode2.getNodeType() == Node.ELEMENT_NODE && "nombre".equals(nNode2.getNodeName())) {
                    nombre = nNode2.getTextContent();
                }

                if (nNode2.getNodeType() == Node.ELEMENT_NODE && "apellido".equals(nNode2.getNodeName())) {
                    apellido = nNode2.getTextContent();
                }
            }
            listaLibro.add(new Libro(libro, nombre, apellido));
        }
        mostrarObjetos();
    }

}
