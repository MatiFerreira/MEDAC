
import java.io.*;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class GeneradorDom {
    private static Document documentoXML; // Va contener nuestro XML
    private static Document documentoXML2;

    /**
     * @throws �ado Exception para controlar posibles errores que pudiesen
     *              saltar.
     */
    public GeneradorDom() throws Exception {
        //Constructor vacio
    }

    // Metodo dar contenido al XML
    public void generarDocumento() throws Exception {

        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documentoXML = builder.newDocument();
        /*-------------------------CREACION XML EN JAVA---------------------------------------------------------*/
        Element libros = documentoXML.createElement("libros"); // Etiqueta raiz
        documentoXML.appendChild(libros);// La convertimos en elemento raiz. La etiqueta es hija del elemento raiz
        // Creamos la etiqueta libro
        Element libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L001"); // le doy atributo

        Element nombreLibro = documentoXML.createElement("libro"); // Creo etiqueta nombre
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Mujercitas")); // La meto dentro de libro

        Element nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Louisa")); // Le doy valor

        Element apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("May Scott"));

        // Segundo libro
        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L002");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Las uvas de la ira"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("John"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Steinbeck"));

        // Tercero
        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L003");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Dracula"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Bram"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Stoker"));

        // cuarto

        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L004");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Crimen y Castigo"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Fiodor"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Dovstoyeski"));

        // quinto

        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L005");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Crimen y Castigo"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Fiodor"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Dovstoyeski"));
        // Sexto

        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L006");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("El exorcista"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("William"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Peter Blatty"));

        // septimo

        libro = documentoXML.createElement("libro");
        libros.appendChild(libro);
        libro.setAttribute("codigo", "L007");

        nombreLibro = documentoXML.createElement("libro");
        libro.appendChild(nombreLibro);
        nombreLibro.appendChild(documentoXML.createTextNode("Peter Pan"));

        nombre = documentoXML.createElement("nombre");
        libro.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("James M"));

        apellido = documentoXML.createElement("apellido");
        libro.appendChild(apellido);
        apellido.appendChild(documentoXML.createTextNode("Barry"));
        generarlXml();
    }


    // Metodo que genera o transforma el XML
    private void generarlXml() throws TransformerException {

        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
        // Creamos origen
        DOMSource origen = new DOMSource(documentoXML);
        // Creamos destino
		/*File ruta = new File("libro.xml");
		FileWriter fw = new FileWriter(ruta);
		PrintWriter pw = new PrintWriter(fw);
		Result res = new StreamResult(pw);*/
        // Nos pide el origen y destino
        StreamResult resultado = new StreamResult(new File("libro.xml"));
        transformer.transform(origen, resultado);

    }

    // Si en mi metodo trato el error uso throw. Aqui tengo varios metodos q cada
    // uno tiene su catch, lo optimo es q todos lancen las excepciones pero las
    // controle el main.

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
                                    .println("Propiedad: " + hijo.getNodeName() + ", Valor: " + hijo.getTextContent());
                        }

                    }
                    System.out.println("");
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void procesarXml() {

        try {
            // Creamos la instancia de dbf
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Creamos un nuevo documento vac�o a partir de dicha instancia
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Creamos un objeto File con nuestro fichero XML
            File fichXML = new File("libros.xml");
            // Creamos el arbol DOM a partir del fichero
            Document doc = db.parse(fichXML);
            // normalize. Elimina nodos vac�os y combina nodos adyacentes en caso de que los
            // hubiera
            doc.getDocumentElement().normalize();
            // Elemento ra�z
            System.out.println("Elemento raiz:" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("libro");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    if (eElement.hasChildNodes()) {
                        NodeList nl = node.getChildNodes();
                        for (int j = 0; j < nl.getLength(); j++) {
                            Node nd = nl.item(j);
                            System.out.println(nd.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

    }
}
