import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class NetworkClient {
    public static void main(String[] args) throws Exception{
        Socket con = new Socket("localhost", 12345);
        Scanner sin = new Scanner(con.getInputStream());
        PrintWriter cout = new PrintWriter(con.getOutputStream(), true);
        
        System.out.println("enter a message to send");
        String message = new Scanner(System.in).nextLine();
        cout.println(message);
        
        System.out.println("server respond :");
        message = sin.nextLine();
        System.out.println(message);
        
        cout.close();
        sin.close();
        con.close();



        }
}
