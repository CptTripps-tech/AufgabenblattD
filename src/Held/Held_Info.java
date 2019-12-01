package Held;

import com.sun.deploy.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**Die Klasse, um die Heldeninfomrationen zu verarbeiten*/
public class Held_Info {
    private String heldinfo;
    private String data;
    private int indexfirst, indexlast;
    private Held held;

    private ArrayList<Held> helden=new ArrayList<Held>();
    private ArrayList<String> name=new ArrayList<String>();
    private ArrayList<String> vorname=new ArrayList<String>();
    private ArrayList<String> alias=new ArrayList<String>();

    /** Der Konstruktor für die Heldeninformationen
     * @param heldinfo  Der zu durchsuchende String*/
    public Held_Info(String heldinfo) {
        this.heldinfo = heldinfo;
        setInfo();
    }

    /** Methode um die Helden-Infomrationen zu setzen*/
    public void setInfo(){

        /** Der String wird in einzelne Personen aufgeteilt*/
        String [] info=heldinfo.split(Pattern.quote("</person>"));

        int count=0;

        int i=0;
        while(i<info.length){
            data=info[i];
            /**Überprüfen ob die Tags vorhanden sind*/

            if(data.equals("</team>")){
                break;
            }

            if(!(data.contains("<person>"))){
                throw new IllegalArgumentException("Der Person-Tag fehlt!");
            }
            if(!(data.contains("<vorname>"))){
                throw new IllegalArgumentException("Der Vorname-Tag fehlt!");
            }
            if(!(data.contains("<nachname>"))){
                throw new IllegalArgumentException("Der Nachname-Tag fehlt!");
            }
            if(!(data.contains("<alias>"))){
                throw new IllegalArgumentException("Der Alias-Tag fehlt fehlt!");
            }


            /** Überprüfen ob die  Tags doppelt vorhanden sind */
            for(int j=0;j<info.length;j++){
                if("<alias>".equals(info[j])){
                    count++;
                }
                if(count>1){
                    count=0;
                    throw new IllegalArgumentException("Der Alias-Tag ist doppelt vorhanden!");
                }
                if("<nachname>".equals(info[j])){
                    count++;
                }
                if(count>1){
                    count=0;
                    throw new IllegalArgumentException("Der Nachname-Tag ist doppelt vorhanden!");
                }
                if("<vorname>".equals(info[j])){
                    count++;
                }
                if(count>1){
                    count=0;
                    throw new IllegalArgumentException("Der Vorname-Tag ist doppelt vorhanden!");
                }
            }

            /** Einen neuen Helden erstellen*/
            held=new Held();

            /**Den String nach den Vornamen durchsuchen*/
            indexfirst=data.indexOf("<vorname>");
            indexlast=data.indexOf("</vorname>" );

            if(!(data.contains("<person>"))){
                break;
            }

            /**Den Vornamen rausfiltern*/
            String tmp=data.substring(indexfirst,indexlast);
            tmp=tmp.replaceFirst("<vorname>","");


            /**Überprüfen ob ein Wert vorhanden ist*/
            if(tmp.equals("")){
                throw new IllegalArgumentException("Der Vorname fehlt!");
            }

            /**Überprüfen ob ein ungewolltes Zeichen enthalten ist*/
            if(!(tmp.matches("^[ A-Za-z]+$"))){
                throw new IllegalArgumentException("Vorname enthält fehlerhaftes Zeichen!");
            }

            /** Überprüfen ob der Vorname doppelt vorhanden ist */
            for(int j=0;j<info.length;j++){
                if(tmp.equals(info[j])){
                    count++;
                }
                if(count>1){
                    throw new IllegalArgumentException("Der Vorname ist doppelt vorhanden!");
                }
            }

            /** Den Vornamen setzen*/
            held.setVorname(tmp);

            /**Den String nach den Nachnamen durchsuchen*/
            indexfirst=data.indexOf("<nachname>");
            indexlast=data.indexOf("</nachname>");

            /**Den Nachnamen rausfiltern*/
            tmp=data.substring(indexfirst,indexlast);
            tmp=tmp.replaceFirst("<nachname>","");

            /**Überprüfen ob ein Wert vorhanden ist*/
            if(tmp.equals("")){
                throw new IllegalArgumentException("Der Nachname fehlt!");
            }

            /**Überprüfen ob ein ungewolltes Zeichen enthalten ist*/
            if(!(tmp.matches("^[ A-Za-z]+$"))){
                throw new IllegalArgumentException("Nachname enthält fehlerhaftes Zeichen!");
            }

            /** Überprüfen ob der Nachname doppelt vorhanden ist */
            for(int j=0;j<info.length;j++){
                if(tmp.equals(info[j])){
                    count++;
                }
                if(count>1){
                    count=0;
                    throw new IllegalArgumentException("Der Nachname ist doppelt vorhanden!");
                }
            }

            /**Den Nachname setzen*/
            held.setNachname(tmp);

            /**Den String nach den Alias durchsuchen*/
            indexfirst=data.indexOf("<alias>");
            indexlast=data.indexOf("</alias>");

            /** Den Alias rausfiltern*/
            tmp=data.substring(indexfirst,indexlast);
            tmp=tmp.replaceFirst("<alias>","");

            /**Überprüfen ob ein Wert vorhanden ist*/
            if(tmp.equals("")){
                System.out.println("Der Alias fehlt!");
            }

            /**Überprüfen ob ein ungewolltes Zeichen enthalten ist*/
            if(!(tmp.matches("^[ A-Za-z]+$"))){
                throw new IllegalArgumentException("Alias enthält fehlerhaftes Zeichen!");
            }

            /** Überprüfen ob der Alias doppelt vorhanden ist */
            for(int j=0;j<info.length;j++){
                if(tmp.equals(info[j])){
                    count++;
                }
                if(count>1){
                    throw new IllegalArgumentException("Der Alias ist doppelt vorhanden!");
                }
            }

            /**Den Alias stzen*/
            held.setAlias(tmp);

            /**Den Held abschließend zur Liste hinzufügen*/
            helden.add(held);
            i++;
        }
    }

    /**Die Liste der Helden zurückgeben*/
    public ArrayList<Held> getHelden(){
        return helden;
    }
}