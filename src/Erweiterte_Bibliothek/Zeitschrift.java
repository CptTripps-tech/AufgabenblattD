package Erweiterte_Bibliothek;

public class Zeitschrift extends Medium  {
    private String ISSN;
    private int Volume;
    private  int Nummer;

    /**@param Titel  Titel der Zeitschrift
     * @param Nummer Die Ausgabennumer der Zeitschrift
     * @param ISSN   Die ISSN der Zeitschrift
     * @param Volume Die Volume-Nummer der Zeitschrift*/
    public Zeitschrift(String Titel, int Nummer, int Volume, String ISSN){
        super(Titel);
        setNummer(Nummer);
        setVolume(Volume);
        setISSN(ISSN);
    }

    public void setNummer(int Nummer){
        if (Nummer == 0) {
            throw new IllegalArgumentException("Die Nummer der Zeitschrift fehlt!");
        }
        this.Nummer = Nummer;
    }

    /**@return Nummer der Zeitschrift*/
    public int getNummer(){
        return this.Nummer;
    }

    public void setVolume(int Volume){

        if(Volume==0){
            throw new IllegalArgumentException("Die Volume der Zeitschrift fehlt!");
        }
        this.Volume=Volume;
    }

    /**@return Volume der Zeitschrift*/
    public int getVolume(){
        return this.Volume;
    }

    public void setISSN(String ISSN) {

        if (ISSN.equals(null)|| ISSN .equals("")) {
            throw new IllegalArgumentException("Die ISSN der Zeitschrift fehlt!");
        }
        this.ISSN = ISSN;
    }

    /**@return ISSN der Zeitschrift*/
    public String getISSN(){
        return this.ISSN;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder zs=new StringBuilder();
        zs.append("Titel:"+getTitel()+"\n");
        zs.append("Nummer"+Nummer+"\n");
        zs.append("Volume:"+Volume+"\n");
        zs.append("ISSN:"+ISSN+"\n");
        return zs.toString();
    }

}
