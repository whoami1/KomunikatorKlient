import java.io.*;
import java.net.Socket;

/**
 * Created by Michał Wrzesień on 2015-03-31.
 */
public class GreetinClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        String nick = args[2];
        String password = args[3];

        try {
            System.out.println("Connecting to " + serverName
                    + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out =
                    new DataOutputStream(outToServer);

            out.writeUTF(nick + ";" + password);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            String input = in.readUTF();
            if ("true".equals(input)) {
                System.out.println("Zalogowano");
            } else if ("false".equals(input)) {
                System.out.println("Niestety nie zalogowano");
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
