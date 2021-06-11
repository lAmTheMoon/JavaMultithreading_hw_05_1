package hw_05_1;

public class Main {
    public static void main(String[] args) {
        int port = 23444;
        String host = "127.0.0.1";

        new Thread(new Server(port)).start();
        new Thread(new Client(host, port)).start();
    }
}
