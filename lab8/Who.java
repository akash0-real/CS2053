import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Who {
    public static void main(String[] args) {
        final String WHOIS_SERVER = "whois.internic.net";
        final int WHOIS_PORT = 43;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a domain name (e.g., example.com): ");
            String domain = sc.nextLine().trim();
            try (Socket socket = new Socket(WHOIS_SERVER, WHOIS_PORT)) {
                OutputStream out = socket.getOutputStream();
                out.write((domain + "\r\n").getBytes());
                out.flush();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                System.out.println("\nWHOIS response for " + domain + ":\n");
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown host.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
