
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.xml.sax.SAXException;

public class DOM {
    private File file;
    private Document document;

    public DOM(){
        file = new File("C:\\Users\\spery\\dp_lab\\lab7\\Task1\\file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
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

    public void saveXml(){
        Source domSource = new DOMSource(document);
        Result fileResult = new StreamResult(new File("C:\\Users\\spery\\dp_lab\\lab7\\Task1\\file.xml"));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transform = null;
        try{
             transform = tf.newTransformer();
        } catch(TransformerConfigurationException e) {e.printStackTrace();}

        try{
            DocumentType documentType = document.getDoctype();
            if (documentType != null) {
                transform.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, documentType.getSystemId());
            }
        
            transform.transform(domSource, fileResult);
        } catch (TransformerException e) {e.printStackTrace();}
        
    }
}
