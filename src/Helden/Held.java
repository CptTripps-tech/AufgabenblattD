package Helden;

public class Held {
    private String nachname;
    private String vorname;
    private String alias;
    private String heldinfo;

    public Held(){}

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname(){
        return nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getVorname(){
        return vorname;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias(){
        return alias;
    }

    public StringBuilder sb=new StringBuilder();



}
