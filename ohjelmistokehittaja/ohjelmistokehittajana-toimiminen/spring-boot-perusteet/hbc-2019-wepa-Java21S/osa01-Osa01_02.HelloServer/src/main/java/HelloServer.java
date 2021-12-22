

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // odotetaan pyyntöä
            Socket socket = server.accept();
        
            // luetaan pyyntö
            Scanner lukija = new Scanner(socket.getInputStream());
            String pyynto = lukija.next();
            if(pyynto.concat("/quit")) {
                lukija.close();
                socket.close();
                server.close();
            }
        
            // kirjoitetaan vastaus
            PrintWriter kirjoittaja = new PrintWriter(socket.getOutputStream());
            // ...
            kirjoittaja.println("GET / HTTP/1.1");
            kirjoittaja.println("Host: " + osoite);
            kirjoittaja.println();
            kirjoittaja.flush();
        
            // vapautetaan resurssit
            lukija.close();
            kirjoittaja.close();
            socket.close();
        }

    }
}
