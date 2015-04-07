import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-10.
 */
public class LogowanieWindow extends JFrame
{
    private JPasswordField txtHaslo;
    private JTextField txtLogin;
    private JPanel LogowanieWindow;
    private JButton anulujButton;
    private JButton zalogujButton;
    private JLabel lblStanLogowania;
    private String serverIp;

    public LogowanieWindow(String serverIp)
    {
        this.serverIp = serverIp;
        initComponents();
    }

    private void initComponents()
    {
        final LogowanieWindow logowanieWindow = this;
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

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GreetinClient c = new GreetinClient(logowanieWindow);
                //c.connect(serverIp);

                if (c.connect(serverIp) == false)
                {
                    JOptionPane.showMessageDialog(LogowanieWindow, "Incorrect login or password", "Autenthication Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    KontaktyWindow kontaktyWindow = new KontaktyWindow();
                    kontaktyWindow.show();
                    ((JFrame)SwingUtilities.getWindowAncestor(LogowanieWindow)).setVisible(false);
                }
                //
            }
        });
    }

    public String getLogin()
    {
        String text = txtLogin.getText().toString();
        System.out.println("Login: " + text);
        return text;
    }

    public String getHaslo()
    {
        String text = txtHaslo.getText().toString();
        System.out.println("Haslo: " + text);
        return text;
    }

    public void setTxtHaslo(JPasswordField txtHaslo)
    {
        this.txtHaslo = txtHaslo;
    }

    public void setTxtLogin(JTextField txtLogin)
    {
        this.txtLogin = txtLogin;
    }

    public JPanel getLogowanieWindow() {
        return LogowanieWindow;
    }
}
