import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // Endereço e porta do servidor

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            String message;
            do {
                System.out.print("Digite uma mensagem (ou !quit para sair): ");
                message = scanner.nextLine();
                output.println(message);

                String response = input.readLine();
                System.out.println("Servidor diz: " + response);
            } while (!message.equals("!quit"));

            socket.close();
            System.out.println("Conexão encerrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
