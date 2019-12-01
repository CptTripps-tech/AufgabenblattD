package Erweiterte_Bibliothek;

public  interface BinaryPersistency extends Persistency {
    /**@param zk            Name des Zettelkastens
     * @param dateiname     Name der Datei*/
    @Override
    public void save(Zettelkasten zk, String dateiname);

    /**@param dateiname     Name der Datei*/
    @Override
    public Zettelkasten load(String dateiname);
}