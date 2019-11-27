package Helden;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class HeldenHandler extends DefaultHandler {
    private ArrayList<Held> alleHelden = new ArrayList<Held>();
    private String currentValue;
    private Held held;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if(qName.equals("person")){
            /** Neuer Held erzeugen */
            held=new Held();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        /** Vorname setzen */
        if(qName.equals("vorname")){
                held.setVorname(currentValue);
            }

        /** Nachname setzen */
        if(qName.equals("nachname")){
            held.setNachname(currentValue);
        }

        /** Alias setzen */
        if(qName.equals("alias")){
            held.setAlias(currentValue);
        }

        /** Alle Helden in Arraylist speichern, falls End-tag erreicht wird */
        if(qName.equals("person")){
            alleHelden.add(held);
        }

    }

    public ArrayList<Held> getAlleHelden(){
        return alleHelden;
    }


    @Override
    public void skippedEntity(String name) throws SAXException {}
    @Override
    public void processingInstruction(String target, String data) throws SAXException {}
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}
    @Override
    public void startDocument() throws SAXException {}
    @Override
    public void endDocument() throws SAXException {}
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {}
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {}
    @Override
    public void setDocumentLocator(Locator locator) {}
}
