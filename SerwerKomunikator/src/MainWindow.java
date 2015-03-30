import javax.swing.*;
        import java.awt.event.InputMethodEvent;
        import java.awt.event.InputMethodListener;

/**
 * Created by Michał Wrzesień on 2015-03-09.
 */
public class MainWindow
{
    private JPanel MainWindow;
    private JTextArea txtLog;

    public MainWindow()
    {

    }

    public void wpis(String text)
    {
        txtLog.append(text);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("MainWindow");
        MainWindow obj = new MainWindow ();
        frame.setTitle("Michał Wrzesień - komunikator - serwer");
        frame.setContentPane(obj.MainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Serwer serw = new Serwer(obj);
        serw.connect();
    }

}
