import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClientRead extends Thread{
    private Socket socket;
    public ClientRead(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try
        {
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String echoString = "";
            String response;

            String test = new String();
            while (!test.equals("exit")){
               // if (!echoes.ready()) {
                 //   continue;
                //}
                test = echoes.readLine();
                System.out.println(test);

            }

        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client closed: " + e.getMessage());
        }
    }
}
