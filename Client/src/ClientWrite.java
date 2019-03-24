import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class ClientWrite extends Thread{
    private Socket socket;

    public ClientWrite(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try

        {
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String echoString = "";

            while (!echoString.equals("exit")){

                //System.out.println("Enter message: ");
                echoString=scanner.nextLine();
                stringToEcho.println(echoString);

                    if(echoString.equals("exit")){
                        break;
                    }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client writer Error: " + e.getMessage());
        }
    }
}

