package Person;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {

    private int id;
    private String name;
    private String vorname;
    private Date geburtsdatum;
    private String postleitzahl;
    private String ort;
    private String hobby;
    private String lieblingsgericht;
    private String lieblingsband;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setLieblingsgericht(String lieblingsgericht) {
        this.lieblingsgericht = lieblingsgericht;
    }

    public void setLieblingsband(String lieblingsband) {
        this.lieblingsband = lieblingsband;
    }

    public void addPerson(){
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

            /** Nutzerabfrage, ob er neue Person anlegen möchte oder nicht*/
            String choice;
            Scanner sc= new Scanner(System.in);
            System.out.println("Neue Person anlegen?(y/n)");
            choice=sc.next();

            if(choice.equals("y")){
                Person per=new Person();
                String name,vorname,plz,ort,hobby,liebger,band,gbd;
                Date geburtsdatum;
                int id=0;


                Node personen=doc.getFirstChild();


                Element Person=doc.createElement("person");
                personen.appendChild(Person);

                /**ID der Person setzen*/
                System.out.println("id:");
                id=sc.nextInt();
                per.setId(id);


                Attr ID=doc.createAttribute("id");
                ID.setValue(String.valueOf(id));
                Person.setAttributeNode(ID);

                /** Nachname der Person anlegen*/
                System.out.println("Name:");
                name=sc.next();
                per.setName(name);

                Element Name =doc.createElement("name");
                Name.appendChild(doc.createTextNode(name));
                Person.appendChild(Name);

                /** Vorname der Person anlegen*/
                System.out.println("Vorname:");
                vorname=sc.next();
                per.setVorname(vorname);

                Element Vorname= doc.createElement("vorname");
                Vorname.appendChild(doc.createTextNode(vorname));
                Person.appendChild(Vorname);

                /** Geburtsdatum der Person anlegen*/
                DateFormat format= new SimpleDateFormat("DD.MM.YYYY");
                System.out.println("Geburtsdatum:");
                Element GBD=doc.createElement("geburtsdatum");
                gbd=sc.next();
                geburtsdatum=null;
                try {
                    geburtsdatum = format.parse(gbd);
                    per.setGeburtsdatum(geburtsdatum);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                GBD.appendChild(doc.createTextNode(gbd));
                Person.appendChild(GBD);

                /** Postleitzahl der Person anlegen*/
                System.out.println("PLZ:");
                plz=sc.next();
                per.setPostleitzahl(plz);

                Element PLZ=doc.createElement("postleitzahl");
                PLZ.appendChild(doc.createTextNode(plz));
                Person.appendChild(PLZ);

                /** Ort der Person anlegen*/
                System.out.println("Ort:");
                ort=sc.next();
                per.setOrt(ort);

                Element Ort=doc.createElement("ort");
                Ort.appendChild(doc.createTextNode(ort));
                Person.appendChild(Ort);

                /** Hobby der Person anlegen*/
                System.out.println("Hobby:");
                hobby=sc.next();
                per.setHobby(hobby);

                Element Hobby=doc.createElement("hobby");
                Hobby.appendChild(doc.createTextNode(hobby));
                Person.appendChild(Hobby);

                /** Lieblingsgericht der Person anlegen*/
                System.out.println("Lieblingsgericht:");
                liebger=sc.next();
                per.setLieblingsgericht(liebger);

                Element Gericht=doc.createElement("lieblingsgericht");
                Gericht.appendChild(doc.createTextNode(liebger));
                Person.appendChild(Gericht);

                /** Lieblingsband der Person anlegen*/
                System.out.println("Lieblingsband:");
                band=sc.next();
                per.setLieblingsband(band);

                Element Band=doc.createElement("lieblingsband");
                Band.appendChild(doc.createTextNode(band));
                Person.appendChild(Band);
            }

            if(choice.equals("n")){
                System.exit(0);
            }

            /** Dokument erzeugen*/
            TransformerFactory form = TransformerFactory.newInstance();
            Transformer transformer=form.newTransformer();
            new StreamSource("personen.xml");
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
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

    @Override
    public String toString() {
        return "[[" + this.id + "] ["+ this.name + "] [" + this.vorname + "]" + " [" + this.ort
                + "] [" + this.postleitzahl + "] [" + this.geburtsdatum + " ]" + " [" + this.hobby + "] [" + this.lieblingsgericht + "] [" + this.lieblingsband + "]]";
    }
}

