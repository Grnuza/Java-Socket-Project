
package progetto_tps_marzo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Calendar;



public class ServerThread extends Thread {
   
    Socket client;

    public ServerThread(Socket client) {
        this.client = client;
    }

    
    public void run(){
        try{
        
        //Indirizzo del client    
        InetSocketAddress addr = (InetSocketAddress) client.getRemoteSocketAddress();

        System.out.println("Il client " + addr+" si è connesso il: " + Calendar.getInstance().getTime());   
        String scelta, messaggio,hash;  
        
        //Dichiarazione dei vari Stream di input e output
        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
          
        
        boolean infinito=true;
        
          while(infinito){
          
         //Visualizzazione del menu
          out.writeBytes("-----------------------------------------------------\n");   
          out.writeBytes( "Codificatore tramite funzioni di Hash \n");
          out.writeBytes("Scegli la codifica: \n");
          out.writeBytes("1: MD5 \n");
          out.writeBytes("2: SHA-1 \n");
          out.writeBytes("3: SHA-256 \n");
          out.writeBytes("4: SHA-512 \n");
          out.writeBytes("Premi E per uscire \n");
          out.writeBytes("-----------------------------------------------------\n");   
          
          scelta=in.readLine();
          
          switch (scelta){
             
            //Codifica in MD5  
            case "1":
            out.writeBytes("Inserisci il messaggio che vuoi codificare in MD5: \n");    
            messaggio=in.readLine();
            hash=FunzioniHash.cripta(messaggio,"MD5");
            out.writeBytes(hash+"\n");
            
            break;
            
            //Codifica in SHA-1  
            case "2": 
            out.writeBytes("Inserisci il messaggio che vuoi codificare in SHA-1: \n");    
            messaggio=in.readLine();      
            
            hash=FunzioniHash.cripta(messaggio,"SHA-1");
            out.writeBytes(hash+"\n");
            break;
            
            //Codifica in SHA-256  
            case "3": 
            out.writeBytes("Inserisci il messaggio che vuoi codificare in SHA-256: \n");    
            messaggio=in.readLine();      
            
            hash=FunzioniHash.cripta(messaggio,"SHA-256");
            out.writeBytes(hash+"\n");
            break;
           
             //Codifica in SHA-512  
            case "4": 
            out.writeBytes("Inserisci il messaggio che vuoi codificare in SHA-512: \n");    
            messaggio=in.readLine();      
            hash=FunzioniHash.cripta(messaggio,"SHA-512");
            out.writeBytes(hash+"\n");
            break;
            
            //Disconnessione dal server
            case "e":
                out.writeBytes("\n");
                out.writeBytes("Disconnessione...\n");
                infinito=false;
                System.out.println("Il client " + addr+" si è disconnesso il: " + Calendar.getInstance().getTime());   
                break;
                
            //Scelta errata
            default: 
                out.writeBytes("\n");
                out.writeBytes("Scelta errata\n");
                break;
            
          }
            
            
 }
            
                
            

        }catch(IOException ex){}
    }
}
