/**
 * Created by caron on 05/11/15.
 */
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Reception extends Thread {

    public void Recoit(Socket s) throws Exception {
        String mess;
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        mess = inFromServer.readLine();


        String[] parts = mess.split(":");int nack = Integer.parseInt(parts[1]);
        String who = parts[2];
        String result = parts[3];
        if(nack==0)
        {
             common.affTrace("Erreur de l'envoi vers" + who);
        }
        if(nack==3)
        {
            if(result.isEmpty()) common.affTrace(" Message du " + who );
            else common.affTrace(" Message de " + who +'\n' + result );
        }




    }
    public void run()
    {
        // Definition de la socket et du thread pour envoyer les infos (ct en haut et pour Emission Java
    }
}
