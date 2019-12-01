package D2;


import Erweiterte_Bibliothek.Bibliothek;
import RSS_Feed.*;

public class D2 {
public static void main(String[] args) {
    String site="http://www.tagesschau.de/xml/rss2";
    Feed feed=new Feed();

    openURLConnection open;
    readFromURL read;
    writeToURL writeURL;

    open=new openURLConnection(site);
    read=new readFromURL(site);


}
}
