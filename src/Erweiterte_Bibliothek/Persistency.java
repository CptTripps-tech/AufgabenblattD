package Erweiterte_Bibliothek;

public interface Persistency {
    /**@param zk            Name des Zettelkastens
     * @param dateiname     Name der Datei*/
    public void save(Zettelkasten zk, String dateiname);

    /**@param dateiname     Name der Datei*/
     public Zettelkasten load(String dateiname);
}
