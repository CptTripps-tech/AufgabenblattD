package Erweiterte_Bibliothek;

import java.io.Serializable;

public class Buch extends Medium implements Serializable {
    private int Erscheinungsjahr;
    private String Verlag;
    private String ISBN;
    private String Verfasser;

    /** @param Titel            Der Titel des Buches
     * @param Erscheinungsjahr  Das Erscheinungsjahr des Buches
     * @param Verlag            Der Verlag des Buches
     * @param ISBN              Die ISBN des Buches
     * @param Verfasser         Der Verfasser des Buches*/
    public Buch(String Titel, int Erscheinungsjahr, String Verlag, String ISBN, String Verfasser) {
        super(Titel);
        setVerfasser(Verfasser);
        setErscheinungsjahr(Erscheinungsjahr);
        setVerlag(Verlag);
        setISBN(ISBN);
        checkISBN(ISBN);
    }


    public void setErscheinungsjahr(int Erscheinungsjahr) {
        if (Erscheinungsjahr == 0) {
            throw new IllegalArgumentException("Das Erscheinungsjahr des Buches fehlt!");
        }
        this.Erscheinungsjahr = Erscheinungsjahr;

    }

    /**@return  Erscheinungsjahr*/
    public int getErscheinungsjahr(){
        return this.Erscheinungsjahr;
    }

    public void setVerlag(String Verlag){
        if(Verlag==null){
            throw new IllegalArgumentException("Der Verlag des Buches fehlt!");
        }
        this.Verlag=Verlag;
    }

    public String getVerlag(){
        return this.Verlag;
    }

    public void setISBN(String ISBN) {
        if (ISBN == null) {
            throw new IllegalArgumentException("Die ISBN des Buches fehlt!");
        }
        this.ISBN = ISBN;
    }

    public String getISBN(){
        return this.ISBN;
    }

    public void setVerfasser(String Verfasser) {
        if (Verfasser.equals(null)|| Verfasser.equals("")) {
            throw new IllegalArgumentException("Der Verfasser des Buches fehlt!");
        }
        this.Verfasser = Verfasser;

    }

    /**@return Verfasser des Buches*/
    public String getVerfasser(){
        return this.Verfasser;
    }

    /** Prüfroutine zur Überprüfung, ob die angegebene ISBN eine gültige ISBN ist.*/
    public boolean checkISBN(String ISBN) {
        int[] isbn10 = new int[10];
        int[] isbn13 = new int[13];
        int sum = 0;

        ISBN=ISBN.replaceAll("-","");

        if (ISBN.length() == 10) {
            for (int i = 0; i < 10; i++) {
                isbn10[i] = Integer.parseInt(String.valueOf(ISBN.charAt(i)));
            }
            int zaehler=1;
            for (int j = 0; j < 10; j++) {
                sum += isbn10[j] * zaehler;
                zaehler++;
            }

            if (sum % 11 == 0) {
                return true;
            } else {
                throw new NumberFormatException("Die ISBN-10 ist nicht korrekt!");
            }
        }


        if (ISBN.length() == 13) {
            for (int i = 0; i < 13; i++) {
                isbn13[i] = Integer.parseInt(String.valueOf(ISBN.charAt(i)));
            }
            for (int j = 0; j < 13; j++) {
                if (j % 2 == 0) {
                    sum += isbn13[j] * 3;
                } else {
                    sum += isbn13[j-1];
                }
                int lastdigit = sum % 10;
                int check = (10 - lastdigit) % 10;

                if (isbn13[isbn13.length - 1] == check) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        throw new NumberFormatException("Die ISBN-13 ist nicht korrekt!");
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder bs=new StringBuilder();
        bs.append("Titel:"+getTitel()+"\n");
        bs.append("Erscheinungsjahr:"+Erscheinungsjahr+"\n");
        bs.append("Verlag:"+Verlag+"\n");
        bs.append("ISBN:"+ISBN+"\n");
        bs.append("Verfasser:"+Verfasser+"\n");
        return bs.toString();
    }
}
