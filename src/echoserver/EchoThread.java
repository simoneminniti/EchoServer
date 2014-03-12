package echoserver;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoThread extends Thread {

    private Socket si;

    public EchoThread(Socket si) {

        this.si = si;
    }

    public void run() {
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(si.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(si.getOutputStream()), true);
            
            while (true) {
                String s=in.readLine();
                
                
                if(s.equals("Fine")){
                   out.println("Connessione Chiusa");
                   si.close();
                   
                    break;
                    
                    
                }else{
                out.println(s);
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
