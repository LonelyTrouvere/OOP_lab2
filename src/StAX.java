import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAX {
    public ArrayList<Gun> list = new ArrayList<Gun>();
    
    public StAX(){
        try{    
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("C:\\\\Users\\\\spery\\\\OOP_lab2\\\\lab2\\\\src\\\\file.xml"));
        
        Gun gun = new Gun();
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case Tags.GUN:
                        gun = new Gun();
                        break;
                    case Tags.MATERIAL:
                        nextEvent = reader.nextEvent();
                        gun.material = nextEvent.asCharacters().getData();
                        break;
                    case Tags.ORIGIN:
                        nextEvent = reader.nextEvent();
                        gun.origin = nextEvent.asCharacters().getData();
                        break;
                    case Tags.MODEL:
                        nextEvent = reader.nextEvent();
                        gun.model = nextEvent.asCharacters().getData();
                        break;
                    case Tags.HANDY:
                        nextEvent = reader.nextEvent();
                        gun.handy = Boolean.valueOf(nextEvent.asCharacters().getData());
                        break;
                    case Tags.RANGE:
                        nextEvent = reader.nextEvent();
                        gun.ttc_range = nextEvent.asCharacters().getData();
                        break;
                    case Tags.AIMED:
                        nextEvent = reader.nextEvent();
                        gun.ttc_aimed = Integer.valueOf(nextEvent.asCharacters().getData());
                        break;
                    case Tags.CLIP:
                        nextEvent = reader.nextEvent();
                        gun.ttc_clip = Integer.valueOf(nextEvent.asCharacters().getData());
                        break;
                    case Tags.SCOPE:
                        nextEvent = reader.nextEvent();
                        gun.ttc_scope = Boolean.valueOf(nextEvent.asCharacters().getData());
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("Gun")) {
                    list.add(gun);
                }
            }
        }

        } catch(FileNotFoundException e){e.printStackTrace();}
            catch(XMLStreamException e){e.printStackTrace();}
    }

}
