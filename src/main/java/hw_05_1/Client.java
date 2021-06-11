package hw_05_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try (Socket clientSocket = new Socket(Inet4Address.getByName(host), port);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {
            System.out.println("Клиент подключается к серверу...");
            System.out.println("Server say: " + in.readLine());
            System.out.println("Server say: " + in.readLine());
            while (true) {
                String input = sc.nextLine();
                out.println(input);
                if ("end".equals(input)) {
                    break;
                }
                System.out.println("Server say: " + in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
