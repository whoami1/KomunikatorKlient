import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-10.
 */
public class logowanieWindow extends JFrame
{
    private JPasswordField txtHaslo;
    private JTextField txtNick;
    private JPanel logowanieWindow;
    private JButton anulujButton;
    private JButton zalogujButton;

    public logowanieWindow()
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
                anulujButtonActionPerformed(e);
            }
        });
    }

    private void anulujButtonActionPerformed(ActionEvent e)
    {
        //this.getFrames()[0].setVisible(false);
        //MainWindow.getFrames()[0].setVisible(true);
        this.setVisible(false);
        //MainWindow
        //this.anulujButton.setText("test");
        //MainWindow mainwindow = new MainWindow();
    }

    public static void openLogowanieWindow()
    {
        JFrame frame = new JFrame("logowanieWindow");
        frame.setContentPane(new logowanieWindow().logowanieWindow);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
