package Held;

/**Die Klasse für den Helden*/
public class Held {
    private String nachname;
    private String vorname;
    private String alias;

    /**Der Helden-Konstruktor*/
    public Held(){}

    /**@param nachname Den Nachnamen des Helden setzen*/
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**Den Nachnamen des Helden zurückgeben*/
    public String getNachname(){
        return nachname;
    }

    /**@param vorname Den Vornamen des Helden setzen*/
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**Den Vornamen des Helden zurückgeben*/
    public String getVorname(){
        return vorname;
    }

    /**@param alias Den Alias des Helden setzen*/
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**Den Alias des Helden zurückgeben*/
    public String getAlias(){
        return alias;
    }

    /**Die Heldeninformationen geordnet zurückgeben*/
    public String toString(){
     return ""+nachname+" "+vorname+" - "+alias;
    }

}
