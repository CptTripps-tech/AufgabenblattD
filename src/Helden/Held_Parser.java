package Helden;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Held_Parser {
    private ArrayList<Held> alleHelden;



    public Held_Parser(){
        super();
    }
    public void parse(String file){
        try {
            File in=new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            //XMLReader xr= saxParser.getXMLReader();
            HeldenHandler handler=new HeldenHandler();

            saxParser.parse(in,handler);


            this.alleHelden=handler.getAlleHelden();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Held> getHelden(){
        return alleHelden;
    }

}
