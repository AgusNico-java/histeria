package View;

import Controller.BoardController;
import Model.values.EventType;
import Observer.Observer;

import javax.swing.*;
import java.awt.*;

public class LevelView extends JFrame implements Observer {
    private JButton button1;
    private JPanel panel1;
    private JButton jugarButton;
    private JComboBox<String> comboBox1;
    private BoardController boardController;

    public LevelView(BoardController boardController) {
        this.boardController = boardController;

        setTitle("Hysteria Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        $$$setupUI$$$();  // Inicializar componentes GUI generados

        getContentPane().add(panel1);

        CardLayout cardLayout = (CardLayout) panel1.getLayout();
        cardLayout.show(panel1, "Card2");

        initializeListeners();  // Inicialización de listeners aquí
    }

    private void initializeListeners() {
        jugarButton.addActionListener(e -> {
            String nivelSeleccionado = comboBox1.getSelectedItem().toString();
            boardController.startGame(nivelSeleccionado);
            setVisible(false);
        });
    }

    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new CardLayout(0, 0));
        button1 = new JButton();
        button1.setText("Button");
        panel1.add(button1, "Card1");
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel1.add(panel2, "Card2");
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(spacer1, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Seleccione un nivel:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label1, gbc);
        jugarButton = new JButton();
        jugarButton.setText("Jugar");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(jugarButton, gbc);
        comboBox1 = new JComboBox<>();
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Facil", "Medio", "Dificil"}));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel2.add(comboBox1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Bienvenido a Histeria!");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label2, gbc);
    }

    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    @Override
    public void update(String eventType) {
        switch (EventType.valueOf(eventType)) {
            default -> throw new IllegalArgumentException("Evento desconocido: " + eventType);
        }
    }
}
