package Erweiterte_Bibliothek;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ElektronischesMedium extends Medium implements Serializable {
    private String URL;

    public ElektronischesMedium(String URL){
        super(URL);
        if(URL == null){
            throw new IllegalArgumentException("Die URL-Adresse fehlt!");
        }
        this.URL=URL;
        checkURL(URL);
    }

    @Override
    public int compareTo(Medium medium) {
        String comparevalue=medium.getTitel();

        int result=0;
        result=this.getTitel().compareTo(medium.getTitel());
        return result;
    }

    public  boolean checkURL(String URL){
        try{
            java.net.URL url= new URL(URL);
            url.toURI();
            return true;
        } catch (MalformedURLException e) {
            System.out.println("Die URL ist nicht gültig!");
            return false;
        } catch (URISyntaxException e) {
            System.out.println("Die URL ist nicht gültig!");
            return false;
        }
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder em=new StringBuilder();
        em.append("URL:"+URL+"\n");
        return em.toString();
    }


}

