import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1"; 
        final int SERVER_PORT = 5000;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String clientMsg, serverMsg;

            while (true) {
                System.out.print("You: ");
                clientMsg = sc.nextLine();
                output.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Chat ended.");
                    break;
                }

                serverMsg = input.readLine();
                if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverMsg);
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
