package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoService {


    public boolean echo(String ip, int port, String request) {
        // API -> Application Programming Interface
        try {
            Socket socket = new Socket(ip, port);

            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            return sendEchoMessage(request, os, is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    boolean sendEchoMessage(String request, OutputStream os, InputStream is) throws IOException {
        os.write(request.getBytes());
        String response = new String(is.readAllBytes());

        return response.equals(request);
    }


}
