import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-08.
 */
public class MainWindow extends JFrame {
    private JComboBox cmbAdresSerwera;
    private JButton logowanieButton;
    private JButton rejestracjaButton;
    private JPanel MainWindow;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        /*btnTest.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Klient klient = new Klient();
                try
                {
                    klient.connect(cmbAdresSerwera.getSelectedItem().toString());
                }
                catch (IOException ex)
                {
                    System.out.println("Blad w connect() - " + ex.toString());
                }
            }
        });*/

        final MainWindow mainWindow = this;

        logowanieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLogowanieWindow(getServerIpAddress());
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainWindow);
                topFrame.dispose();
            }
        });

        rejestracjaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RejestracjaWindow.openRejestracjaWindow();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainWindow);
                topFrame.dispose();
            }
        });
    }

    public static void openLogowanieWindow(String serverIp)
    {
        JFrame frame = new JFrame("Komunikator - Logowanie");
        LogowanieWindow logowanieWindow = new LogowanieWindow(serverIp);
        frame.setContentPane(logowanieWindow.getLogowanieWindow());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String getServerIpAddress() {
        String ipAddress = cmbAdresSerwera.getSelectedItem().toString();
        System.out.println("Obecny adres IP: " + ipAddress);
        return ipAddress;
    }

    public void setCmbAdresSerwera(JComboBox cmbAdresSerwera) {
        this.cmbAdresSerwera = cmbAdresSerwera;
    }

    /*public String adresSerwera()
    {
        String text = cmbAdresSerwera.getSelectedItem().toString();
        System.out.println("Obecny adres IP: " + text);
        return text;
    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("Komunikator");
        MainWindow obj = new MainWindow();
        frame.setContentPane(obj.MainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //GreetinClient c = new GreetinClient(obj);
    }
}

