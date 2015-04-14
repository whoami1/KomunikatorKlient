import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał Wrzesień on 2015-03-22.
 */
public class KontaktyWindow {
    private JButton historiaButton;
    private JButton dodajKontaktButton;
    private JTable Użytkownicy;
    private JPanel KontaktyWindow;
    private JButton oAplikacjiButton;
    private JLabel lblUruchomionyUzytkownik;

    public KontaktyWindow()
    {
        initComponents();
    }

    private void initComponents()
    {
        lblUruchomionyUzytkownik.setText("uruchomiony użytkownik");
        oAplikacjiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OAplikacjiDialog.openOAplikacjiDialog();
            }
        });

        dodajKontaktButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DodajKontaktDialog.openDodajKontaktyDialog();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnNames = {"Nick", "Status"};
        Object[][] data = {{"Admin", "niedostępny"}};
        Użytkownicy = new JTable(data, columnNames);
        Użytkownicy.setFillsViewportHeight(true);

    }

    /*public static void main(String[] args)
    {
        JFrame frame = new JFrame("Komunikator - Kontakty");
        JPanel kontaktyWindow = new KontaktyWindow().KontaktyWindow;
        frame.setContentPane(kontaktyWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/

    public void showKontaktyWindow() {
        JFrame frame = new JFrame("Komunikator - Kontakty");
        JPanel kontaktyWindow = new KontaktyWindow().KontaktyWindow;
        frame.setContentPane(kontaktyWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}