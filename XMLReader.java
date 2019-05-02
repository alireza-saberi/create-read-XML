/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

//import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author alans
 */
public class XMLReader {
    
    public void readXML(String fileName) throws ParserConfigurationException, SAXException, IOException{
        InputSource xmlFile = new InputSource(fileName);
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc = db.parse(xmlFile);
        NodeList list = doc.getElementsByTagName("PRODUCT");
        
        
        for(int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
             
           if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                System.out.println("ID: " + el.getAttribute("id"));
                System.out.println("Name " + el.getElementsByTagName("NAME").item(0).getTextContent());
            }
        }
        
    }
    
    public static void main(String[] args){
        
        try{
            new XMLReader().readXML("products.xml");
        } catch(IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Look! there was an exception buddy!" + e.getMessage());
        }
        
       
    }
}
