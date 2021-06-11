package hw_05_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Соединение установлено!");
            out.println("Привет! Введи цифру, а я скажу какому числу из ряда Фибоначчи она соответствует. Для выхода введи end");
            while (true) {
                String input = in.readLine();
                if ("end".equals(input)) {
                    break;
                }
                int number = Integer.parseInt(input);
                int result = new RecursionFibonacci().getFibonacciNumber(number);
                out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
