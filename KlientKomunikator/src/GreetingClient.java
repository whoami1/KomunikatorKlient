import sun.applet.Main;

import java.io.*;
import java.net.Socket;

/**
 * Created by Michał Wrzesień on 2015-03-31.
 */
public class GreetingClient
{

    private RejestracjaWindow okno1;
    private LogowanieWindow okno2;

    private String serverIp;
    private Socket client;
    private OutputStream outToServer;
    private InputStream inFromServer;
    private DataOutputStream out;
    private DataInputStream in;


    public GreetingClient(RejestracjaWindow o1)
    {
        this.okno1 = o1;
        System.out.println("wypis1");
    }

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
        //proces czyli czy logowanie czy rejestracja
        int port = 6066;/*Integer.parseInt(args[1]);*/
        this.serverIp = serverIp;

        try
        {
            System.out.println("Łączenie z " + serverIp + " na porcie " + port);
            client = new Socket(serverIp, port);
            System.out.println("Połączono z " + client.getRemoteSocketAddress());
            outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);
            inFromServer = client.getInputStream();
            in = new DataInputStream(inFromServer);
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String userLogin, String userPassword)
    {
        try {
            out.writeUTF("login;" + userLogin + ";" + userPassword);
            String input = in.readUTF();
            if (("login;true").equals(input))
            {
                return true;
            } else //nie udalo sie zalogowac albo nie udalo sie zarejestrowac
            {
                client.close();
                return false;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean register(String userLogin, String userPassword)
    {
        try {
            out.writeUTF("register;" + userLogin + ";" + userPassword);
            String input = in.readUTF();
            client.close();
            if (("register;true").equals(input))
            {
                return true;
            } else //nie udalo sie zalogowac albo nie udalo sie zarejestrowac
            {
                return false;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
