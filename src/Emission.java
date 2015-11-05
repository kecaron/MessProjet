import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by caron on 05/11/15.
 */
public class Emission extends Thread {


    public void Envoie(Socket s, String ID, int type) throws Exception {
        String tempo;
        if (ID.contains(":")) throw new CharacterException(s);
        tempo = ":S:" + type + ":" + ID + ":";


        DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
        outToServer.writeBytes(ID);

    }

    public void run() {}

    class CharacterException extends Exception {
        public CharacterException(Socket s) throws IOException {
            PrintWriter outClient = new PrintWriter(s.getOutputStream(), true);
            common.signalErreurToClient(outClient, "Vous essayez de créer un ID possedant le caractere ':' il est interdit de saisir un tel ID !");
        }
    }
}
