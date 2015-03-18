import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Created by Michał Wrzesień on 2015-03-08.
 */
public class MainWindow extends JFrame
{
    private JComboBox cmbAdresSerwera;
    private JButton btnTest;
    private JButton logowanieButton;
    private JButton rejestracjaButton;
    private JTextField txtTest;
    private JPanel MainWindow;

    public MainWindow()
    {
        initComponents();
    }

    private void initComponents()
    {
        btnTest.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent ae)
            {
                txtTest.setText("test");
                Klient klient = new Klient();
                try
                {
                    klient.connect(cmbAdresSerwera.getSelectedItem().toString());
                }
                catch(IOException ex)
                {
                    System.out.println("Blad w connect() - " + ex.toString());
                }
            }
        });

        logowanieButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

                logowanieWindow.openLogowanieWindow();


            }
        });

        rejestracjaButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                rejestracjaWindow.openRejestracjaWindow();
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().MainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

