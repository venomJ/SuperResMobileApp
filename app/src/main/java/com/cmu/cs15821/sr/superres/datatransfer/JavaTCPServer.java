package com.cmu.cs15821.sr.superres.datatransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cem on 10/28/2015.
 * Test Java server.
 */
public class JavaTCPServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket welcomeSocket = new ServerSocket(8888);
        Socket connectionSocket = welcomeSocket.accept();
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        byte[] imageData = javax.xml.bind.DatatypeConverter.parseHexBinary("ffffffff");

        //Send 2 images
        for(int i = 0; i< 2;i++) {
            outToClient.writeInt(4);
            outToClient.write(imageData);
            Thread.sleep(500);
        }

        //Receive images
        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
        int imageSize = inFromClient.readInt();
        byte[] receivedData = new byte[imageSize];
        inFromClient.read(receivedData);

        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(receivedData));
        outToClient.close();
        inFromClient.close();
        connectionSocket.close();
    }
}
