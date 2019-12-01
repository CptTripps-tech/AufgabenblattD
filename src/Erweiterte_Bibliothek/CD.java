package Erweiterte_Bibliothek;

import java.io.Serializable;

public class CD extends Medium implements Serializable {
    private String Label;
    private String Kuenstler;

    /**@param Titel         Der Titel der CD
     * @param Kuenstler     Der Kuenstler der CD
     * @param Label         Das Label der CD*/
    public CD(String Titel, String Kuenstler, String Label){
        super(Titel);
        setKuenstler(Kuenstler);
        setLabel(Label);
    }

    /**@return Label der CD*/
    public String getLabel(){
        return Label;
    }

    public void setLabel(String Label) {

        if (Label.equals(null)|| Label.equals("")) {
            throw new IllegalArgumentException("Das Label der CD fehlt!");
        }
        this.Label = Label;
    }

    /**@return Kuenstler der CD*/
    public String getKuenstler(){
        return Kuenstler;
    }

    public void setKuenstler(String Kuenstler) {

        if (Kuenstler.equals(null)|| Kuenstler.equals("")) {
            throw new IllegalArgumentException("Der Name des Künstlers der CD fehlt!");
        }
        this.Kuenstler = Kuenstler;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder cd=new StringBuilder();
        cd.append("Titel:"+getTitel()+"\n");
        cd.append("Künstler:"+Kuenstler+"\n");
        cd.append("Label:"+Label+"\n");
        return cd.toString();
    }

}
