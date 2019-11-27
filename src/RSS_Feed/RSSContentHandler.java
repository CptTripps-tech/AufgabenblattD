package RSS_Feed;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.ArrayList;

public class RSSContentHandler implements ContentHandler {
    private Feed feed;
    private String currentvalue;
    private ArrayList<String> feeds;
    private ArrayList<String> feed_titel;
    private String site;

    public RSSContentHandler() {
        feeds = new ArrayList<String>();
        feed_titel=new ArrayList<String>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentvalue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equalsIgnoreCase("channel")) {
            feed = new Feed();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //Titel setzen
        if (qName.equals("title")) {
            feed.setTitle(currentvalue);
        }

        //Description setzen
        if (qName.equals("descritpion")) {
            feed.setDescription(currentvalue);
        }

        //Link setzen
        if (qName.equals("link")) {
            feed.setLink(currentvalue);
        }

        //Autor setzen
        if (qName.equals("author")) {
            feed.setAuthor(currentvalue);
        }

        //Language setzen
        if (qName.equals("language")) {
            feed.setLanguage(currentvalue);
        }

        //Copyright setzen
        if (qName.equals("copyright")) {
            feed.setCopyright(currentvalue);
        }
        if (qName.equals("title")) {
            System.out.println(feed.getTitle());
        }
        if(currentvalue.equals(feed.getTitle())) {
            parseTitle(currentvalue);
        }
        feeds.add(currentvalue);
    }

    public void parseTitle(String value) {
        if (value != null) {
            feed_titel.add(value);
        }


    }
    public ArrayList<String> getFeeds()
    {
        return this.feeds;
    }

    public ArrayList<String> getFeed_titel(){
        return this.feed_titel;
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
