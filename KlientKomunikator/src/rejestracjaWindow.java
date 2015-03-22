import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-15.
 */
public class RejestracjaWindow
{
    private JTextField textNick;
    private JTextField textLogin;
    private JPasswordField txtHaslo;
    private JButton zarejestrujButton;
    private JButton anulujButton;
    private JPanel RejestracjaWindow;

    public RejestracjaWindow()
    {
        initComponents();
    }

    private void initComponents()
    {
        //txtNick.setText("Podaj nick"); //testy
        anulujButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(RejestracjaWindow);
                topFrame.dispose();
                MainWindow.getFrames()[0].setVisible(true);
            }
        });
    }

    public static void openRejestracjaWindow()
    {
        JFrame frame = new JFrame("RejestracjaWindow");
        frame.setContentPane(new RejestracjaWindow().RejestracjaWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
