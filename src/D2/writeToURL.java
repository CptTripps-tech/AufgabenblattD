package D2;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class writeToURL {
    public writeToURL(String site){

        try {
            URL url = new URL(site);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStream outStream = connection.getOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(outStream);
            objectStream.writeInt(54367);
            objectStream.writeObject("Hello there");
            objectStream.writeObject(new Date());
            objectStream.flush();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
