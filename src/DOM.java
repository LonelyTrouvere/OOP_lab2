
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ranges.Range;
import org.xml.sax.SAXException;

public class DOM {
    private File file;
    private Document document;

    public DOM(){
        file = new File("C:\\Users\\spery\\OOP_lab2\\lab2\\src\\file.xml");
        var schema = new File("C:\\Users\\spery\\OOP_lab2\\lab2\\src\\file.xsd");

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = null;
        
        try{
            s = sf.newSchema(schema);
        } catch(SAXException e) {e.printStackTrace();}

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setSchema(s);
        DocumentBuilder builder = null;
        try{
            builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new MyErrorHandler());
        } catch (ParserConfigurationException e) {e.printStackTrace();}

        try{
            document = builder.parse(file);
        } catch(SAXException e) {e.printStackTrace();}
          catch(IOException e) {e.printStackTrace();}
    }

    public ArrayList<Gun> getGuns(){
        var nodes = document.getElementsByTagName("Gun");
       
        ArrayList<Gun> guns = new ArrayList<>();
        for(int i=0; i<nodes.getLength(); i++){
            String model = document.getElementsByTagName("model").item(i).getTextContent();
            Boolean handy = Boolean.valueOf(document.getElementsByTagName("handy").item(i).getTextContent());
            String origin = document.getElementsByTagName("origin").item(i).getTextContent();
            String material = document.getElementsByTagName("material").item(i).getTextContent();
            String range = document.getElementsByTagName("range").item(i).getTextContent();
            int aimed = Integer.valueOf(document.getElementsByTagName("aimed").item(i).getTextContent());
            int clip = Integer.valueOf(document.getElementsByTagName("clip").item(i).getTextContent());
            Boolean scope = Boolean.valueOf(document.getElementsByTagName("scope").item(i).getTextContent());

            Gun gun = new Gun(model, handy, origin, material, range, aimed, clip, scope);
            guns.add(gun);
        }

        return guns;
    }
}
