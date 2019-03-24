
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public final static int max_user = 100;
    public static PrintWriter[] printers = new PrintWriter[max_user];
    //public static ArrayList<PrintWriter> printers=new ArrayList<PrintWriter>();
    static int i=0;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                Socket socket = serverSocket.accept(); //blocks until a client is connected
                Echoer echoer = new Echoer(socket);
                System.out.println("Client connected");
                echoer.start();
            }

        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
