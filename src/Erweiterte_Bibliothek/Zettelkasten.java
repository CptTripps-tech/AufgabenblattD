package Erweiterte_Bibliothek;

import java.io.*;
import java.util.*;

public class Zettelkasten  implements Iterable<Medium>, Comparable<Medium>, HumanReadablePersistency, BinaryPersistency, Serializable {
    private ArrayList<Medium> myZettelkasten;
    private String SORTED = "0";

    /**
     * Erstellt einen Zettelkasten in Form einer Arraylist für die Medien
     */
    public Zettelkasten() {
        myZettelkasten = new ArrayList<Medium>();
    }

    /**
     * @param medium Hinzufügen des Mediums zum Zettelkasten
     * @return false    Medium nicht erfolgreich hinzugefügt
     */
    public boolean addMedium(Medium medium) {
        return myZettelkasten.add(medium);
    }

    /**
     * @param Titel Löschen des Mediums aus dem Zettelkastens anhand des Titels
     * @return false    Medium nicht erfolgreich entfernt
     */
    public boolean dropMedium(String Titel) throws DuplicateEntryException {
         List<Medium> result=findMedium(Titel);
        if(result.size()>1){
            throw new DuplicateEntryException("Mehrfache Einträge");
        }
        else if(result.size()<1){
            return false;
        }
        else{
            return myZettelkasten.remove(result.get(0));
        }
    }

    public boolean dropDuplicate(String Titel){
        int auswahl,index = 0;
        List<Medium> auswahlListe=findMedium(Titel);
        Scanner sc=new Scanner(System.in);
        System.out.println("Art der Löschung: 1-Bestimmte");
        System.out.print("                  2-Alle\n");
        System.out.print("Auswahl:");
        auswahl=sc.nextInt();

        switch (auswahl){
            case 1:
                for (Medium medium : auswahlListe) {
                    index = auswahlListe.indexOf(medium);
                    System.out.print("Eintrag:" + index+"\n");
                    System.out.println("Medium:" + auswahlListe.get(index).calculateRepresentation());
                }
                System.out.println("Nummer des Eintrags:");
                auswahl = sc.nextInt();
                 myZettelkasten.remove(auswahlListe.get(auswahl));
                break;

            case 2:
                for(int i=0;i<auswahlListe.size();i++){
                    myZettelkasten.remove(auswahlListe.get(i));
                }
                break;
        }
        return true;
    }

    /**@param Titel Finden eines Mediums im Zettelkasten anhand des Titels
     * @return      Liefert das gefundene Medium zurück*/
        public List<Medium> findMedium (String Titel) {
            List<Medium> multipleMed = new ArrayList<Medium>();
           for(Medium medium: myZettelkasten){
               if(medium.getTitel().equals(Titel)){
                   multipleMed.add(medium);
                   Collections.sort(multipleMed, Collections.reverseOrder());
               }
           }
            return multipleMed;
          }




        /**Sortieren des Zettelkastens anhand zwei Parameter
         * @param  p        Der erste Sortier-Parameter
         * @return true     Sortieren hat funktioniert
         * @return false    Sortieren hat nicht funktioniert*/
    public boolean sort(String p) {
        if (p=="AZ") {
            if(SORTED.equals("AZ")){
                return false;
            }
                Collections.sort(myZettelkasten);
            SORTED="AZ";
            }
            if (p=="ZA") {
                if(SORTED.equals("ZA")){
                    return false;
                }
                Collections.sort(myZettelkasten, Collections.reverseOrder());
                SORTED="ZA";
            }
            return true;
        }

        public String getSORTED(){
        return SORTED;
        }

    @Override
    public Iterator<Medium> iterator() {
        return myZettelkasten.iterator();
    }


    /**Methode zum Speichern eines Zettelkastens
     * @param zk            Der Name des Zettelkastens
     * @param dateiname     Der Name, unter welcher die Datei
     *                      gepseichert werden soll*/
    public void save(Zettelkasten zk, String dateiname) {
        Zettelkasten sk=new Zettelkasten();
        sk=zk;
        if(dateiname.contains(".txt")) {
            try {
                BufferedWriter save = new BufferedWriter(new FileWriter(dateiname));
                for (Medium med : zk) {
                    save.write(med.calculateRepresentation());
                    save.write("\n");
                }
                save.close();

            } catch (IOException e) {
                System.out.println("Datei konnte nicht eingelesen werden");
            }
        }if(dateiname.contains(".ser")){
            try {
                ObjectOutput saveout=new ObjectOutputStream(new FileOutputStream(dateiname));
                for(Medium medium:zk) {
                    saveout.writeObject(medium);
                }
                saveout.close();
            } catch (FileNotFoundException e) {
                System.out.println("Kein Dateiname für Bibliothek angegeben");
            } catch (IOException e) {
                System.out.println("Bibliothek konnte nicht gespeichert werden");
            }
        }
    }

    /**Methode zum Ladem eines Zettelkastens
     * @param dateiname     Der der Datei die
     *                      geladen werden soll*/
    public Zettelkasten load(String dateiname) throws UnsupportedOperationException {
        Medium loadZettelkasten=null;
        Zettelkasten zk=new Zettelkasten();

        if(dateiname.contains(".txt")) {
            throw new UnsupportedOperationException("Funktion nicht unterstüzt ");
        }
        if(dateiname.contains(".ser")){
            try{
                FileInputStream savefilein=new FileInputStream(dateiname);
                ObjectInputStream in = new ObjectInputStream(savefilein);

               for(Medium medium: this) {
                    loadZettelkasten= (Medium) in.readObject();
                    zk.addMedium(loadZettelkasten);
                }
                in.close();
                savefilein.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return zk;
        }


    @Override
    public int compareTo(Medium o) {
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
}

