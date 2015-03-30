/**
 * Created by Michał Wrzesień on 2015-03-09.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klient {
    private static final int PORT = 50000;
    Socket socket = null;

    public Klient() {

    }

    public void connect(String host) throws IOException {
        try {
            socket = new Socket(host, PORT);
        } catch (Exception e) {
            System.err.println("Nie można połączyć się z " + host + ":" + PORT);
            System.exit(1);
        }

        final PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread t = new Thread(new Runnable() {
            public void run() {
                //long start = System.currentTimeMillis();

                while (true) {
                    try {
                        String read = reader.readLine();

                        if (read != null) {
                            System.out.println(System.currentTimeMillis() + " Server: " + read);
                        }

                        if (read.equals("Ping")) {
                            writer.println("Pong"); //odpowiadamy 'Pong'
                            System.out.println(System.currentTimeMillis() + " Client: Pong");
                        }
                    } catch (IOException ioe) {
                        //
                    }
                }
            }
        });
        t.start();
        t.run();
        System.out.println("przed writer/read close");
        writer.close();
        reader.close();
        System.out.println("po writer/read close");
        socket.close();
        System.out.println("po socket close");
    }
}
