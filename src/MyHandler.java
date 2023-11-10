import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    private ParseResult result;
    private StringBuilder value;

    private Gun getLastGun() {
        List<Gun> gunList = result.list;
        int lastGun = gunList.size() - 1;
        return gunList.get(lastGun);
    }

    public ArrayList<Gun> getList() {
        return result.list;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (value == null) {
            value = new StringBuilder();
        } else {
            value.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException{
        result = new ParseResult();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case Tags.GUNLIST:
                result.list = new ArrayList<>();
                break;
            case Tags.GUN:
                result.list.add(new Gun());
                break;
            case Tags.TTC:
                break;
            default:
                value = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case Tags.MATERIAL:
                getLastGun().material = value.toString();
                break;
            case Tags.MODEL:
                getLastGun().model = value.toString();
                break;
            case Tags.HANDY:
                getLastGun().handy = Boolean.valueOf(value.toString());
                break;
            case Tags.ORIGIN:
                getLastGun().origin = value.toString();
                break;
            case Tags.RANGE:
                getLastGun().ttc_range = value.toString();
                break;
            case Tags.AIMED:
                getLastGun().ttc_aimed = Integer.valueOf(value.toString());
                break;
            case Tags.CLIP:
                getLastGun().ttc_clip = Integer.valueOf(value.toString());
                break;
            case Tags.SCOPE:
                getLastGun().ttc_scope = Boolean.valueOf(value.toString());
                break;
        }
    }

    @Override
    public void error(SAXParseException e) {
        System.out.println("Рядок" + e.getLineNumber() + ":");
        System.out.println(e.getMessage());
    }

}
