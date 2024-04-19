import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4999);
        System.out.println("Aguardando conexões...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("\nConexão estabelecida com: " + socket);

            ClientHandler clientThread = new ClientHandler(socket); // Cria Thread nova
            clientThread.start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Erro ao criar fluxos de entrada/saída para o cliente: " + e);
        }
    }

    @Override
    public void run() {
        try {
            String str;
            while ((str = reader.readLine()) != null) {
                if (str.equals("exit")) {
                    System.out.println("\nConexão encerrada pelo cliente: " + socket);
                    break;
                }
                System.out.println("\nCliente (" + socket + "): " + str);

                // Resposta ao cliente
                if (str.equals("emailteste@email.com")) {
                    writer.println("A string está correta! Acesso liberado.");
                } else {
                    writer.println("A string não está correta.");
                }
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler/escrever do cliente: " + e);
        }
    }
}
