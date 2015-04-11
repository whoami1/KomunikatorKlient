import sun.applet.Main;

import java.io.*;
import java.net.Socket;

/**
 * Created by Michał Wrzesień on 2015-03-31.
 */
public class GreetingClient
{

    //private MainWindow okno1;
    private LogowanieWindow okno2;

    /*public GreetingClient(MainWindow o1)
    {
        this.okno1 = o1;
        System.out.println("wypis1");
    }*/

    public GreetingClient(LogowanieWindow o2)
    {
        this.okno2 = o2;
        System.out.println("wypis2");
    }

    /*public GreetingClient(MainWindow mainwindow, LogowanieWindow logowaniewindow)
    {
        this.okno1 = mainwindow;
        this.okno2 = logowaniewindow;
        System.out.println("wypis3");
    }*/

    public GreetingClient()
    {
    }

    public boolean connect(String serverIp)
    {
        int port = 6066;/*Integer.parseInt(args[1]);*/
        String nick = okno2.getLogin() /*args[2]*/;
        String password = okno2.getHaslo()/*args[3]*/;


        try
        {
            System.out.println("Łączenie z " + serverIp + " na porcie " + port);
            Socket client = new Socket(serverIp, port);
            System.out.println("Połączono z " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("login;" + nick + ";" + password);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            String input = in.readUTF();
            if ("login;true".equals(input))
            {
                return true;
            }
            else //nie udalo sie zalogowac
            {
                client.close();
                return false;
            }
        }
        catch (IOException e)
        {
               e.printStackTrace();
        }
        return false;
    }
}
