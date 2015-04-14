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
                GreetingClient c = new GreetingClient(logowanieWindow);
                if(c.connect(serverIp))
                {
                    if(c.login(getLogin(), getHaslo()))
                    {
                        KontaktyWindow kontaktyWindow = new KontaktyWindow();
                        kontaktyWindow.showKontaktyWindow();
                        ((JFrame)SwingUtilities.getWindowAncestor(LogowanieWindow)).setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(LogowanieWindow, "Nieprawidłowy login albo hasło...", "Błąd uwierzytelniania", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(LogowanieWindow, "Nie udało się połączyć", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
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
