package Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {
    public static void main(String[] args) {
        boolean choice;
        try {
            // XMLReader erzeugen
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            // Pfad zur XML Datei

            String path="personen.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = (Document) docBuilder.parse(path);

            // DTD kann optional übergeben werden
            // inputSource.setSystemId("X:\\personen.dtd");

            // PersonenContentHandler wird übergeben
            xmlReader.setContentHandler(new PersonenContentHandler());

            // Parsen wird gestartet
            xmlReader.parse(path);

            Scanner sc= new Scanner(System.in);
            System.out.println("Neue Person anlegen ?");
            choice=sc.nextBoolean();

            if(choice==true){
                Person per=new Person();
                String name,vorname,ort,plz,hobby,liebger,band;
                String geburtsdatum;
                int id=0;


                System.out.println("id:");
                id=sc.nextInt();

                Element rootElement=doc.createElement("person");
                doc.appendChild(rootElement);

                Element ID = doc.createElement("id");
                rootElement.appendChild(ID);


                System.out.println("Name:");
                name=sc.next();
                Element Name =doc.createElement("name");
                doc.appendChild(doc.createAttribute(name));


                System.out.println("Vorname:");
                vorname=sc.next();
                Element Vorname= doc.createElement("vorname");
                doc.appendChild(doc.createAttribute(vorname));

                System.out.println("Ort:");
                ort=sc.next();
                Element Ort=doc.createElement("ort");
                doc.appendChild(doc.createAttribute(ort));

                System.out.println("PLZ:");
                plz=sc.next();
                Element PLZ=doc.createElement("postleitzahl");
                doc.appendChild(doc.createAttribute(plz));

                DateFormat format= new SimpleDateFormat("DD.MM.YYYY");
                System.out.println("Geburtsdatum:");
                Element GBD=doc.createElement("geburtsdatum");
                Date date= null;
                try {
                    date = format.parse(sc.next());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                GBD.appendChild(doc.createAttribute(String.valueOf(date)));

                System.out.println("Hobby:");
                hobby=sc.next();
                Element Hobby=doc.createElement("hobby");
                Hobby.appendChild(doc.createAttribute(hobby));

                System.out.println("Lieblingsgericht:");
                liebger=sc.next();
                Element Gericht=doc.createElement("lieblingsgericht");
                Gericht.appendChild(doc.createAttribute(liebger));

                System.out.println("Lieblingsband:");
                band=sc.next();
                Element Band=doc.createElement("leiblingsband");
                Band.appendChild(doc.createAttribute(band));

            }

            if(choice==false){
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
