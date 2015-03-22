import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-10.
 */
public class LogowanieWindow extends JFrame
{
    private JPasswordField txtHaslo;
    private JTextField txtNick;
    private JPanel LogowanieWindow;
    private JButton anulujButton;
    private JButton zalogujButton;

    public LogowanieWindow()
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
                JFrame topFrame = (JFrame)SwingUtilities.getWindowAncestor(LogowanieWindow);
                topFrame.dispose();
                MainWindow.getFrames()[0].setVisible(true);
            }
        });
    }

    public static void openLogowanieWindow()
    {
        JFrame frame = new JFrame("LogowanieWindow");
        frame.setContentPane(new LogowanieWindow().LogowanieWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
