package issuesystem.server.repository;

import issuesystem.dto.DataTransferObject;
import issuesystem.server.process.ProcessFactory;
import issuesystem.server.process.ProcessInterface;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientProcess extends Thread {

    Socket clientSocket;

    public ClientProcess(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        System.out.println(" New Connection");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                DataTransferObject dto = (DataTransferObject) objectInputStream.readObject();
                System.out.println(dto);
                if (dto == null) {
                    break;
                }

                ProcessInterface processImplementation = ProcessFactory.getProcess(dto);
                DataTransferObject response = processImplementation.process(dto.getObject());
                objectOutputStream.reset();
                objectOutputStream.writeObject(response);
                objectOutputStream.flush();

            }
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
