package model;

import model.OOP.Book;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLController {
    public void createXML(List<Book> BL) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element students = doc.createElement("Books");

        List<Book> BookList = new ArrayList<>();
        BookList = BL;
        BookList.forEach(book ->{
            Element student = doc.createElement("Book");
            students.appendChild(student);
            Attr attr = doc.createAttribute("n0");
            attr.setValue(String.valueOf(book));
            student.setAttributeNode(attr);

            Element id = doc.createElement("Id");
            id.appendChild(doc.createTextNode(String.valueOf(book.getId())));
            student.appendChild(id);

            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode(book.getName()));
            student.appendChild(name);

            Element type = doc.createElement("Type");
            type.appendChild(doc.createTextNode(book.getType()));
            student.appendChild(type);

            Element date = doc.createElement("Date");
            date.appendChild(doc.createTextNode(book.getDate_created()));
            student.appendChild(date);

            Element quantity = doc.createElement("Quantity");
            quantity.appendChild(doc.createTextNode(String.valueOf(book.getQuantity())));
            student.appendChild(quantity);

            Element quantity_borrow = doc.createElement("Borrow");
            quantity_borrow.appendChild(doc.createTextNode(String.valueOf(book.getQuantity_borrow())));
            student.appendChild(quantity_borrow);

            Element price = doc.createElement("Price");
            price.appendChild(doc.createTextNode(String.valueOf(book.getPrice())));
            student.appendChild(price);

        });
        doc.appendChild(students);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        String file = "C://Users//Hiki_ne//Desktop//test.xml";
        File f = new File(file);
        int counter = 0;
        while (f.exists()) {
            f = new File("C://Users//Hiki_ne//Desktop//test" + counter + ".xml");
            counter++;
        }

        StreamResult result = new StreamResult(f);
        transformer.transform(source, result);
    }

    public  List<Book> readXMl(String file){
        List<Book> bookList = new ArrayList<>();
        File input = new File(file);


        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuider = dbFactory.newDocumentBuilder();
            Document doc = dBuider.parse(input);
            doc.getDocumentElement().getNodeName();
            NodeList nodeListBook = doc.getElementsByTagName("Book");
            for (int i = 0; i < nodeListBook.getLength(); i++) {
                Book book = new Book();
                Node nNode = nodeListBook.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    book.setId(Integer.parseInt(eElement.getElementsByTagName("Id")
                            .item(0).getTextContent()));
                    book.setName((eElement.getElementsByTagName("Name")
                            .item(0).getTextContent()));
                    book.setType((eElement.getElementsByTagName("Type")
                            .item(0).getTextContent()));
                    book.setDate_created((eElement.getElementsByTagName("Date")
                            .item(0).getTextContent()));
                    book.setQuantity(Integer.parseInt(eElement.getElementsByTagName("Quantity")
                            .item(0).getTextContent()));
                    book.setQuantity_borrow(Integer.parseInt(eElement.getElementsByTagName("Borrow")
                            .item(0).getTextContent()));
                    book.setPrice(Float.parseFloat(eElement.getElementsByTagName("Id")
                            .item(0).getTextContent()));

                }

                bookList.add(book);
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
            return bookList;
    }
}

