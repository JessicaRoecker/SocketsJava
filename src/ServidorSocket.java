import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Porta do servidor

            System.out.println("Aguardando conexões...");

            Socket clientSocket = serverSocket.accept(); // Aguarda uma conexão

            System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;

            do {
                message = input.readLine();
                System.out.println("Cliente diz: " + message);
                output.println("Servidor recebeu: " + message);
            } while (!message.equals("!quit"));

            serverSocket.close();
            System.out.println("Conexão encerrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
