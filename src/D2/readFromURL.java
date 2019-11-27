package D2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class readFromURL {
    public readFromURL(String site) {
        try {
            URL url = new URL(site);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
            String line = "";
            while ((line = input.readLine()) != null)
                System.out.println(line);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
