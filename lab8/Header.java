import java.net.*;
import java.io.*;
import java.util.*;

public class Header {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = sc.nextLine();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("\nRequest Method: " + connection.getRequestMethod());
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Response Message: " + connection.getResponseMessage());
            System.out.println("\nHTTP Headers:");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                if (key != null)
                    System.out.println(key + ": " + String.join(", ", values));
                else
                    System.out.println("Status: " + String.join(", ", values));
            }

            connection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Error: Invalid URL format.");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect or retrieve data.");
        } finally {
            sc.close();
        }
    }
}
