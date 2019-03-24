

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;



public class Echoer extends Thread {
    private Socket socket;
    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String data ="";


            Main.printers[Main.i++]=output;

            while(true) {

                String echoString;
                echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
               if(echoString.equals("exit")) {
                   output.println("exit");
                    break;
                }


                for(int j = 0; j < Main.i; j++) {
                    if(Main.printers[j] != output)

//                   else {
                        Main.printers[j].println("Message received: " +echoString);

//                        Main.printers[j].println("");
//                    }
                }
            }
        } catch(IOException e) {
            System.out.println(  e.getMessage());
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
