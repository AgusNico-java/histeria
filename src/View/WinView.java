package View;

import Model.values.EventType;
import Observer.Observer;
import javax.swing.*;
import java.awt.*;

public class WinView extends JFrame implements Observer {
    private JLabel winMessage;
    private JButton startButton;

    public WinView() {

        setTitle("Hysteria Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        winMessage = new JLabel("¡Ganaste!");
        winMessage.setFont(new Font("Arial", Font.BOLD, 36));
        winMessage.setBorder(BorderFactory.createEmptyBorder(10, 30, 70, 30));
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(winMessage, gbc);

        startButton = new JButton("Empezar");
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        getContentPane().add(startButton, gbc);
    }

    @Override
    public void update(String eventType) {
        if (eventType.equals(EventType.WIN.name())){
            setVisible(true);
        }
    }
}
