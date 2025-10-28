import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class UrlConnector{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = sc.nextLine();

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            System.out.println("\nProtocol: " + url.getProtocol());
            System.out.println("Content Type: " + connection.getContentType());
            long date = connection.getDate();
            if (date != 0)
                System.out.println("Date: " + new Date(date));
            else
                System.out.println("Date: Not available");

            // 4. Content length
            int length = connection.getContentLength();
            if (length != -1)
                System.out.println("Content Length: " + length + " bytes");
            else
                System.out.println("Content Length: Not available");
            System.out.println("\nFirst few lines of content:\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            for (int i = 0; i < 5; i++) {  
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }

            reader.close();

        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL format.");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect or read from the URL.");
        } finally {
            sc.close();
        }
    }
}
