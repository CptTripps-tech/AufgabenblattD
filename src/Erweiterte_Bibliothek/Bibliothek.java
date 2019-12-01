package Erweiterte_Bibliothek;

/**Das Programm Bibliothek kann verwendet werden, um eine virtuelle Bibliothek zu erstellen, die verschiedene Medien
 * speichern kann. Diese Bibliothek kann auf Wunsch in eine Textdatei gespeichert werden.
 *
 * Desweiterin kann ein Buch in Wikibooks  gesucht und anschließend im Zettelkasten gespeichert werden.
 *
 * @Author Andy Gahler
 * @since 03.11.2019
 **/
public class Bibliothek{

    public static void main(String[] args) {

        //Parameter übergeben
        String key=args[0];

        Zettelkasten zettelkasten = new Zettelkasten();

        zettelkasten.addMedium(new CD("Live at Wembley", "Queen", "Parlophone (EMI)"));
        zettelkasten.addMedium(new ElektronischesMedium("http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new Buch("Duden 01.Die deutsche Rechtschreibung", 2004,
                "Bibliographisches Institut, Mannheim", "3-411-04013-0", "-"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel", 6, 54, "0038-7452"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel", 7, 55, "0038-7453"));
        zettelkasten.addMedium(new Wikibook("Java_Standard"));

        zettelkasten.sort("AZ");


        Wikibook java=new Wikibook("Java_Standard");

        System.out.println(java.WikipediaBooksContributorRequest(key));


    /*
        for(Medium medium: zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }

        zettelkasten.save(zettelkasten,"bib.txt");

*/


    }
}
