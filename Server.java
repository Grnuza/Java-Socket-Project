
package progetto_tps_marzo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    public static void main(String[] args) {
        try {
            
            
            
            System.out.println("Server on");
            ServerSocket s_server = new ServerSocket(8888); //Creazione del socket del server
            
            while(true){ //Creazione di un thread per ogni client che si connette al server
                
            Socket s_client=s_server.accept(); 
            
            
            
            
            ServerThread serverThread = new ServerThread(s_client);
            serverThread.start();
            }
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
