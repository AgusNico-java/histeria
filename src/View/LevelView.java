package View;

import Controller.BoardController;
import Model.bussinessValues.EventType;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import Utils.Texts;

public class LevelView extends BaseView {
    private JLabel welcomeMessage;
    private JLabel selectionMessage;
    private JComboBox<String> levelSelection;
    private JButton startGameButton;

    private BoardController boardController;

    public LevelView(BoardController boardController) {
        this.boardController = boardController;
        initComponents();
        initializeListeners();
    }

    private void initializeListeners() {
        startGameButton.addActionListener(e -> {
            String selectedLevel = levelSelection.getSelectedItem().toString();
            boardController.startGame(selectedLevel);
            setVisible(false);
        });
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(20, 40, 20, 40);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        welcomeMessage = new JLabel(Texts.WELCOME, SwingConstants.CENTER);
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeMessage.setForeground(new Color(33, 150, 243));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(welcomeMessage, gbc);

        selectionMessage = new JLabel(Texts.LEVEL_SELECTION);
        selectionMessage.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(selectionMessage, gbc);

        levelSelection = new JComboBox<>(boardController.getAvailableLevels());
        levelSelection.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.insets = new Insets(20, 0, 20, 40);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(levelSelection, gbc);

        startGameButton = new JButton(Texts.PLAY);
        startGameButton.setFont(new Font("Arial", Font.BOLD, 16));
        startGameButton.setBackground(new Color(33, 150, 243)); // Azul vibrante
        startGameButton.setForeground(Color.WHITE); // Texto blanco
        startGameButton.setFocusPainted(false);
        startGameButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding interno
        startGameButton.setPreferredSize(new Dimension(120, 45));


        gbc.insets = new Insets(20, 40, 20, 40);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(startGameButton, gbc);
    }

    @Override
    public void update(String eventType) {
        switch (EventType.valueOf(eventType)) {
            case REPLAY -> setVisible(true);
        }
    }
}
