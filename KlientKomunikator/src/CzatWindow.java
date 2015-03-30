import javax.swing.*;

/**
 * Created by Michał Wrzesień on 2015-03-24.
 */
public class CzatWindow {
    private JPanel CzatWindow;
    private JTextArea txtCzat;
    private JTextField txtWiadomosc;
    private JButton wyslijButton;

    public CzatWindow() {
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Komunikator - Czat");
        frame.setContentPane(new CzatWindow().CzatWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
