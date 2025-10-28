import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ip {
    public static void main(String[] args) {
        try {
           
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Your computer's IP address: " + localHost.getHostAddress());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a domain name (e.g., www.google.com): ");
            String domain = sc.nextLine();
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("IP addresses for " + domain + ":");
            for (InetAddress addr : addresses) {
                System.out.println(addr.getHostAddress());
            }

            sc.close();
        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve host.");
        }
    }
}
