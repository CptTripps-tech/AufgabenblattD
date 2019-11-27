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

public class Feed {
    private String title;
    private String description;
    private String link;
    private String author;
    private String language;
    private String copyright;


    public Feed(){
    }

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public void setLink(String link){
        this.link=link;
    }

    public String getLink(){
        return link;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public String getAuthor(){
        return author;
    }

    public void setLanguage(String language){
        this.language=language;
    }

    public String getLanguage(){
        return language;
    }

    public void setCopyright(String copyright){
        this.copyright=copyright;
    }

    public String getCopyright(){
        return copyright;
    }

    public String toString(){
       return  "[[" + this.title + "] ["+ this.link + "] [" + this.author + "]" + " [" + this.language
                + "] [" + this.copyright + "] [" + this.description + "]]";
    }
}
