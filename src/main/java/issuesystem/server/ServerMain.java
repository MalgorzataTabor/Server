package issuesystem.server;


import issuesystem.server.repository.ClientProcess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {


    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientProcess clientProcess = new ClientProcess(clientSocket);
                clientProcess.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
