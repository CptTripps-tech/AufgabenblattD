package RSS_Feed;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.xml.sax.helpers.XMLReaderFactory.createXMLReader;

/**Das Programm ruft den RSS-Feed einer bestimmten Webseite auf und
 * gibt anschließend die Nachrichten-Überschriften auf der Konsole aus
 *
 * @Author Andy Gahler
 * @since 21.11.2019*/
public class RSS_Main {
    public static void main(String[] args) {
        String site = "http://www.tagesschau.de/xml/rss2";
        ArrayList<String> feed_titel;

        RSS_Parser rss_parser = new RSS_Parser();

        try {
            rss_parser.parse(site);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        feed_titel=rss_parser.getFeed_titel();

        for(int j = 0; j < feed_titel.size(); j++){
        System.out.println(feed_titel.get(j));
        }
    }
}


