package Held;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**Das Programm durchsucht eine XML-Struktur in Form eines Strings nach Informationen über Helden und
 * gibt diese dann geordnet nach Nachname,Vorname und Alias aus.
 * @Author Andy Gahler
 * @since 26.11.2019*/

public class Held_Main {
    public static void main(String[] args) {
        String original = "<team><person><vorname>Norrin</vorname><nachname>Radd</nachname><alias>Silver Surfer</alias></person><person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das Ding</alias></person></team>";

        String info2 = "<team><person><nachname>Radd</nachname> <vorname>Norrin</vorname><alias>Silver Surfer</alias></person> <person><vorname>Ben</vorname><alias>Das Ding</alias><nachname>Grimm</nachname></person></team>";
        String andereFolge = "<team><person><vorname>Ben</vorname><alias>Das Ding</alias><nachname>Grimm</nachname></person><person><nachname>Radd</nachname> <vorname>Norrin</vorname><alias>Silver Surfer</alias></person></team>";
        String fehlerhaft="<team><person><nachname>Radd</nachname><alias>Silver Surfer</alias> <vorname>Norrin</vorname></person> <mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das Ding</alias></person></team> ";
        Held_Info hinfo;
        ArrayList<Held> heroes;

        try {
            hinfo = new Held_Info(original);
            heroes = hinfo.getHelden();

            for (Held h : heroes) {
                System.out.println(h.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}