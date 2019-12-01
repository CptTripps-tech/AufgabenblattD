package RSS_Feed;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**Der Parser um die Webseiteninfomrationen zu verarbeiten*/
public class RSS_Parser {
    private URL url;
    private ArrayList<String> feed_titel;

    /**Konstruktor für den Parser*/
    public RSS_Parser(){

    }
    /**@param site Die URL-Adresse als String*/
    public void parse (String site) throws ParserConfigurationException, SAXException, IOException {
            url=new URL(site);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            RSSContentHandler handler = new RSSContentHandler();
            xr.setContentHandler(handler);
            xr.parse(new InputSource(url.openStream()));

            feed_titel=handler.getFeed_titel();
    }
    /**Die Liste der Nachrichten-Feeds abfragen*/
    public ArrayList<String> getFeed_titel(){
        return feed_titel;
    }
}
