package RSS_Feed;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.ArrayList;

/**Die Klasse um den vom Parser gelieferten RSS-Feed zu verarbeiten*/
public class RSSContentHandler implements ContentHandler {
    private Feed feed;
    private String currentvalue;
    private ArrayList<String> feed_titel;
    private String site;

    /**Der Konstruktor für den Contenthandler*/
    public RSSContentHandler() {
        feed_titel=new ArrayList<String>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentvalue = new String(ch, start, length);
    }

    /**Sobald der Pasrer auf einen Channel-Tag stößt,wird ein neuer Feed erzeugt.*/
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equalsIgnoreCase("channel")) {
            feed = new Feed();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        /**Den Titel setzen*/
        if (qName.equals("title")) {
            feed.setTitle(currentvalue);
        }

        /**Die Description setzen*/
        if (qName.equals("descritpion")) {
            feed.setDescription(currentvalue);
        }

        /**Den Link setzen*/
        if (qName.equals("link")) {
            feed.setLink(currentvalue);
        }

        /**Den Autor setzen*/
        if (qName.equals("author")) {
            feed.setAuthor(currentvalue);
        }

        /**Die Language setzen*/
        if (qName.equals("language")) {
            feed.setLanguage(currentvalue);
        }

        /**Das Copyright setzen*/
        if (qName.equals("copyright")) {
            feed.setCopyright(currentvalue);
        }

        /**Wenn der End-Tag erreicht wird, soll der aktuelle Titel
         * zur Liste hinzugefügt werden*/
        if (qName.equals("title")) {
            feed_titel.add(currentvalue);
        }
    }
        /**Die Liste mit den Titel abrufen*/
         public ArrayList<String> getFeed_titel(){
             return feed_titel;
    }




    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {}
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {}
    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {}
    @Override
    public void processingInstruction(String target, String data) throws SAXException {}
    @Override
    public void skippedEntity(String name) throws SAXException {}
    @Override
    public void setDocumentLocator(Locator locator) {}
    @Override
    public void startDocument() throws SAXException {}
    @Override
    public void endDocument() throws SAXException {}
}
