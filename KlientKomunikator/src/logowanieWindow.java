import javax.swing.*;

/**
 * Created by Michał Wrzesień on 2015-03-10.
 */
public class logowanieWindow
{
    private JPasswordField txtHaslo;
    private JTextField txtNick;
    private JPanel logowanieWindow;
    private JButton anulujButton;
    private JButton zalogujButton;


    public static void openLogowanieWindow()
    {
        JFrame frame = new JFrame("logowanieWindow");
        frame.setContentPane(new logowanieWindow().logowanieWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
