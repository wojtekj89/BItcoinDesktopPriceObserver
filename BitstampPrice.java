import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Getting actual price list of bitcoin by bitstamp ticker, parsing HTML data into the class.
 * Created by J on 2017-07-12.
 */
public class BitstampPrice {
 public static Bitcoin getPrices() {
     String tmp = "";
     InputStream is = null;
     BufferedReader br;
     String line;

     try {
         URL url = new URL("https://www.bitstamp.net/api/ticker/");
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
             tmp += line + "\n";
         }
     } catch (MalformedURLException mue) {
         mue.printStackTrace();
     } catch (IOException ioe) {
         ioe.printStackTrace();
     } finally {
         try {
             if (is != null) is.close();
         } catch (IOException ioe) {
             // nothing to see here
         }
     }

     Double min, max, open, current;
     tmp = tmp.replaceAll("[^0-9.,]", "");
     String[] tokens = tmp.split(",");
     open = Double.parseDouble(tokens[8]);
     min = Double.parseDouble(tokens[6]);
     max = Double.parseDouble(tokens[0]);
     current = Double.parseDouble(tokens[1]);
     return new Bitcoin("Bitstamp", open, max, min, current);
 }
}
