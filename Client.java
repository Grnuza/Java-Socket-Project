
package progetto_tps_marzo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Client {

   
    public static void main(String[] args){
       try {
            String scelta, messaggio;
            

            System.out.println("Client on");
           
            Socket s_client= new Socket("localhost",8888); //Creazione socket del client
            
            //Dichiarazione dei vari Stream di input e output
            BufferedReader input_tastiera= new BufferedReader( new InputStreamReader(System.in));
            BufferedReader input= new BufferedReader(new InputStreamReader(s_client.getInputStream()));
            DataOutputStream output = new DataOutputStream(s_client.getOutputStream());
           
            boolean infinito=true;
            while(infinito){
                
            //Visualizzazione del menu   
            System.out.println(input.readLine());  
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            System.out.println(input.readLine());
            
            //Scelta tra le opzioni
            scelta=input_tastiera.readLine();
            output.writeBytes(scelta+"\n");
            
            //Inserimento del messaggio da codificare
            
            System.out.println(input.readLine());  
            
            //Utilizzato per escludere i campi di uscita e di scelta errata dall'inserimento del messaggio
            if("1".equals(scelta) || "2".equals(scelta) || "3".equals(scelta) || "4".equals(scelta)){ 
                
            messaggio=input_tastiera.readLine();
            output.writeBytes(messaggio+"\n");
            }
            
            //Risposta dal server
            String risposta;
            risposta=input.readLine();
            System.out.println(risposta);
            
            //Disconnessione del client data la risposta
            if("Disconnessione...".equals(risposta)){    
             break;
            }
            
            }
           
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
