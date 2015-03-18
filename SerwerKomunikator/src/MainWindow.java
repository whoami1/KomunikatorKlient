import javax.swing.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

/**
 * Created by Michał Wrzesień on 2015-03-09.
 */
public class MainWindow
{
    private JPanel MainWindow;
    private JTextArea txtLog; //private było
    private JScrollPane scrollPane;

    public MainWindow()
    {
        txtLog.append("testtetsy");
    }

     public void wpis(String text)
    {
        txtLog.append(text);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("MainWindow");
        frame.setTitle("Michał Wrzesień - komunikator - serwer");
        frame.setContentPane(new MainWindow().MainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        MainWindow obj = new MainWindow ();
        Serwer serw = new Serwer(obj);
        serw.connect();
    }

}

