
import java.io.*;
import java.net.*;

public class Lab10 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 19099); 
            //client connection
            BufferedReader rr = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter w = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sr = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //reading and writing from console or server
            System.out.println("Enter whatever you want to calculate :");
            
            while (true) {
                String console = rr.readLine();
                w.println(console);

                String serverRespond = sr.readLine();
                System.out.println("Server is  " + serverRespond);
            }
        } catch (IOException ff) {
            ff.printStackTrace();
        }
    }
}