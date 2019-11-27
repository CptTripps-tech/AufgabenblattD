package D2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class openURLConnection {
public openURLConnection(String site){
     try {
        URL url = new URL(site);
        URLConnection connection = url.openConnection();

    } catch (MalformedURLException e) {
        System.out.println(e.toString());
    } catch (IOException e) {
        e.printStackTrace();
            }
        }
    }
