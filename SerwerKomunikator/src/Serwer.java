/**
 * Created by Michał Wrzesień on 2015-03-09.
 */
import sun.net.ConnectionResetException;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Serwer
{
    private static final int PORT = 50000;
    static boolean flaga = true;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
   // private static JTextArea txtLog;

    //Moje kombinacje

    private MainWindow okienko;

    public Serwer(MainWindow okno)
    {
        okienko = okno;
    }

    /*public Serwer(JTextArea txtLog)
    {
        this.txtLog = txtLog;
    }*/

    public void log(String text)
    {
        okienko.wpis(System.currentTimeMillis() + "|" + text);
        //txtLog.append(System.currentTimeMillis() + "|" + text);
        System.out.println(System.currentTimeMillis() + "|" + text);
    }

    public void connect()
    {
        serverSocket = null;
        try
        {
            serverSocket = new ServerSocket(PORT);
        }
        catch(IOException e)
        {
            log("Could not listen on port: "+PORT);
            System.exit(1);
        }

        log("Waiting for connection...");

        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    while(flaga)
                    {
                        log(".");
                        Thread.sleep(1000);
                    }
                }
                catch(InterruptedException ie)
                {
                    //
                }

                log("\nClient connected on port " + PORT);
            }
        });
        t.start();

        clientSocket = null;
        try
        {
            clientSocket = serverSocket.accept();
            flaga = false;
        }
        catch(IOException e)
        {
            log("Accept failed.");
            t.interrupt();
            System.exit(1);
        }

        try
        {
            final PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            t = new Thread(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        while(true)
                        {
                            String data = "Ping";
                            writer.println(data);
                            log("WRITE|" + data);

                            String input = reader.readLine();

                            log("READ|" + input);
                            Thread.sleep(2000);
                        }

                    }
                    catch(SocketException e)
                    {
                        if(e.toString().indexOf("Connection reset") != -1)
                        {
                            log("Klient sie rozlaczyl");
                        }
                        else
                            log("wyjatek SocketException: [" + e.toString() + "]");
                    }
                    catch(Exception e)
                    {
                        log("Nieoczekiwany blad");
                    }
                    /*finally
                    {
                        writer.close();
                        reader.close();
                        clientSocket.close();
                    }*/
                }
            });
            t.start();
            writer.close();
            reader.close();
            serverSocket.close();
        }
        catch(IOException ex)
        {
            log("exception: " + ex.toString());
        }
    }
}
