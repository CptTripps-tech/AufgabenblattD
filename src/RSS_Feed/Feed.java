package RSS_Feed;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**Die Klasse für den Feed*/
public class Feed {
    private String title;
    private String description;
    private String link;
    private String author;
    private String language;
    private String copyright;

/**Der Feed-Konstruktor*/
    public Feed(){
    }

    /**@param title Den Titel setzen*/
    public void setTitle(String title){
        this.title=title;
    }
    /** Den Titel abfragen*/
    public String getTitle(){
        return title;
    }
    /**@param description Die Description setzen*/
    public void setDescription(String description){
        this.description=description;
    }
    /** Die Description abfragen*/
    public String getDescription(){
        return description;
    }
    /**@param link Den Link setzen*/
    public void setLink(String link){
        this.link=link;
    }

    /** Den Link abfragen*/
    public String getLink(){
        return link;
    }

    /**@param author Den Autor setzen*/
    public void setAuthor(String author){
        this.author=author;
    }

    /** Den Autor abfragen*/
    public String getAuthor(){
        return author;
    }

    /**@param language Die Language setzen*/
    public void setLanguage(String language){
        this.language=language;
    }

    /** DIe Language abfragen*/
    public String getLanguage(){
        return language;
    }

    /**@param copyright Den Copyright setzen*/
    public void setCopyright(String copyright){
        this.copyright=copyright;
    }

    /** Den Copyright abfragen*/
    public String getCopyright(){
        return copyright;
    }

    /** Den Feed in lesbaren Text umwandeln*/
    public String toString(){
       return  "[[" + this.title + "] ["+ this.link + "] [" + this.author + "]" + " [" + this.language
                + "] [" + this.copyright + "] [" + this.description + "]]";
    }
}
