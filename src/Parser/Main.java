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
import javax.xml.transform.TransformerConfigurationException;
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


                Node personen=doc.getFirstChild();

                Element root=doc.createElement("personen");
                personen.appendChild(root);

                System.out.println("id:");
                id=sc.nextInt();
                Element Person=doc.createElement("person");
                Person.se("person id=",""+id);
                personen.appendChild(Person);

                System.out.println("Name:");
                name=sc.next();
                Element Name =doc.createElement("name");
                Name.setAttribute("name",""+name);
                Person.appendChild(Name);


                System.out.println("Vorname:");
                vorname=sc.next();
                Element Vorname= doc.createElement("vorname");
                Vorname.setAttribute("vorname",""+vorname);
                Person.appendChild(Vorname);

                DateFormat format= new SimpleDateFormat("DD.MM.YYYY");
                System.out.println("Geburtsdatum:");
                Element GBD=doc.createElement("geburtsdatum");
                Date date= null;
                try {
                    date = format.parse(sc.next());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                GBD.setAttribute("geburtsdatum",""+date);
                Person.appendChild(GBD);

                System.out.println("PLZ:");
                plz=sc.next();
                Element PLZ=doc.createElement("postleitzahl");
                PLZ.setAttribute("postleitzahl",""+plz);
                Person.appendChild(PLZ);

                System.out.println("Ort:");
                ort=sc.next();
                Element Ort=doc.createElement("ort");
                Ort.setAttribute("ort",""+ort);
                Person.appendChild(Ort);

                System.out.println("Hobby:");
                hobby=sc.next();
                Element Hobby=doc.createElement("hobby");
                Hobby.setAttribute("hobby",""+hobby);
                Person.appendChild(Hobby);

                System.out.println("Lieblingsgericht:");
                liebger=sc.next();
                Element Gericht=doc.createElement("lieblingsgericht");
                Gericht.setAttribute("lieblingsgericht",""+liebger);
                Person.appendChild(Gericht);

                System.out.println("Lieblingsband:");
                band=sc.next();
                Element Band=doc.createElement("leiblingsband");
                Band.setAttribute("lieblingsband",""+band);
                Person.appendChild(Band);
            }

            if(choice==false){
                System.exit(0);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
