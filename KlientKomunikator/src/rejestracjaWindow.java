import javax.swing.*;

/**
 * Created by Michał Wrzesień on 2015-03-15.
 */
public class rejestracjaWindow
{
    private JTextField textNick;
    private JTextField textLogin;
    private JPasswordField txtHaslo;
    private JButton zarejestrujButton;
    private JButton anulujButton;
    private JPanel rejestracjaWindow;

    public static void openRejestracjaWindow()
    {
        JFrame frame = new JFrame("rejestracjaWindow");
        frame.setContentPane(new rejestracjaWindow().rejestracjaWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
