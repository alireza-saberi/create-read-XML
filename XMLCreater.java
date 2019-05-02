/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author alans
 */



public class XMLCreater {
    
    public void create() throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        
        Element products = doc.createElement("PRODUCTS");
        doc.appendChild(products);
        
//        creating series of products
//      Product 1
        Element product1 = doc.createElement("PRODUCT");
        Attr product1Attr = doc.createAttribute("id");
        product1Attr.setValue("1");
        product1.setAttributeNode(product1Attr);
        
        Element name1 = doc.createElement("NAME");
        name1.appendChild(doc.createTextNode("BANANA"));

//      Product 2
        Element product2 = doc.createElement("PRODUCT");
        Attr product2Attr = doc.createAttribute("id");
        product2Attr.setValue("2");
        product2.setAttributeNode(product2Attr);
        
        Element name2 = doc.createElement("NAME");
        name2.appendChild(doc.createTextNode("APPLE"));
        
        
        products.appendChild(product1);
        products.appendChild(product2);
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer t = tFactory.newTransformer();
        
        DOMSource inputDoc = new DOMSource(doc);
        
        StreamResult outputFile = new StreamResult("productions.xml");
        
//        t.setOutputProperties(OutputKeys.INDENT, "yes");
        t.transform(inputDoc, outputFile);
        
    }
    
}
