import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAX {

    public ArrayList<Gun> list;

    public SAX(){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("C:\\Users\\spery\\OOP_lab2\\lab2\\src\\file.xml"), handler);

        this.list = handler.getList();
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
