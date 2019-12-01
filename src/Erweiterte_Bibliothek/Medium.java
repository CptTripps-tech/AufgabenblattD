package Erweiterte_Bibliothek;

import java.io.Serializable;

public abstract class Medium implements Comparable<Medium>, Serializable {
    private String Titel;

    /**@param titel Titel des Mediums*/
    public Medium(String titel) {
        if (titel == "" || titel == null) {
            throw new IllegalArgumentException("Titel fehlt!");
        } else {
           setTitel(titel);
        }
    }
    public void setTitel(String titel) {
        this.Titel=titel;
    }

    /**@return Titel des Mediums*/
    public String getTitel() {
        return Titel;
    }

    /**@param medium Das Medium mit dem verglichen wird*/
    public int compareTo(Medium medium){
        return this.getClass().getName().compareTo(medium.getClass().getName());
    }

    public abstract String calculateRepresentation();
}
