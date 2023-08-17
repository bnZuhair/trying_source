import java.net.*;
import java.util.*;
import java.io.*;
public class NetworkServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(12345);
        System.out.println("waiting");
        Socket cs = ss.accept();
        System.out.println("connection establised");
        Scanner cin = new Scanner(cs.getInputStream());
        PrintWriter sout = new PrintWriter(cs.getOutputStream(), true);

        String inMessage = cin.nextLine();
        System.out.println("the message from the client is: ");
        System.out.println(inMessage);
        
        System.out.println("Enter your message");
        String outMessage = new Scanner(System.in).nextLine();
        
        sout.println(outMessage);
        System.out.println("message sent");
        
        
        sout.close();
        cin.close();
        cs.close();
        ss.close();

    }
}
