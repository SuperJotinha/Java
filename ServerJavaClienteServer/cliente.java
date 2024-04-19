import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);

        InputStreamReader clientInput = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(clientInput);

        InputStreamReader serverInput = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(serverInput);

        String userInput;

        while (true) {
            System.out.println("\nDigite uma mensagem (ou 'exit' para sair): ");
            System.out.println("Você pode enviar o email para fazer a validação do email.");
            System.out.print("Digite a sua mensagem: ");

            userInput = reader.readLine();
            pr.println(userInput);

            if (userInput.equals("exit")) {
                break;
            }

            String response = bf.readLine();
            System.out.println("\nResposta do Servidor: " + response);
        }

        s.close();
    }
}
