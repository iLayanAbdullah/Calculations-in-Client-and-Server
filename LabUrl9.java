
import java.io.*;
import java.net.*;

public class LabUrl9 {
    public static void main(String[] args) {
        try {
            ServerSocket sss = new ServerSocket(19099); 
            System.out.println("Server run successfuly");
//server connection
            Socket css = sss.accept();
            System.out.println("Client being connected");
//client connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(css.getInputStream()));
            PrintWriter writer = new PrintWriter(css.getOutputStream(), true);
//sending or recieving from client
            String data;
            while ((data = reader.readLine()) != null) {
                try {
                    String[] symbols = data.split(" ");
                    double n1 = Double.parseDouble(symbols[0]);
                    double n2 = Double.parseDouble(symbols[2]);
                    String factor = symbols[1];
                    double r = 0.0;

                    if (factor.equals("+")) {
                        r = n1 + n2;
                    } else if (factor.equals("-")) {
                        r = n1 - n2;
                    } else if (factor.equals("*")) {
                        r = n1 * n2;
                    }  else if (factor.equals("%")) {
                        r = n1 % n2;
                    }else if (factor.equals("/")) {
                        r = n1 / n2;
                    }
                    writer.println("Result: " + r);
                } catch (Exception ee) {
                    writer.println("uncorrect [n1] [operator] [n2]");
                }}
            css.close();
            sss.close();
        } catch (IOException ff) {
            ff.printStackTrace();
        }
    }
}
