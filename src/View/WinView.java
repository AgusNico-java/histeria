package View;

import Controller.BoardController;
import Model.bussinessValues.EventType;
import Utils.Texts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinView extends BaseView {
    private BoardController boardController;
    private JLabel winMessage;
    private JLabel clicksCountMessage;
    private JButton startButton;
    private int clicks = 0;


    public WinView(BoardController boardController) {
        this.boardController = boardController;
        setLayout(new GridBagLayout());
        initComponents();
        initializeListeners();
    }

    private void initializeListeners() {
        startButton.addActionListener(e -> {
            boardController.replay();
            setVisible(false);
        });
    }

    private void initComponents(){
        GridBagConstraints gbc = new GridBagConstraints();

        winMessage = new JLabel(Texts.WIN);
        winMessage.setFont(new Font("Arial", Font.BOLD, 32));
        winMessage.setForeground(new Color(33, 150, 243));
        winMessage.setBorder(BorderFactory.createEmptyBorder(10, 30, 70, 30));
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(winMessage, gbc);

        clicksCountMessage = new JLabel();
        clicksCountMessage.setFont(new Font("Arial", Font.PLAIN, 17));
        clicksCountMessage.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(clicksCountMessage, gbc);

        startButton = new JButton(Texts.START);
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(33, 150, 243)); // Azul vibrante
        startButton.setForeground(Color.WHITE); // Texto blanco
        startButton.setFocusPainted(false);
        startButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding interno
        startButton.setPreferredSize(new Dimension(120, 45));

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(startButton, gbc);
    }

    public void update(String eventType) {
        switch (EventType.valueOf(eventType)) {
            case WIN -> {
                setVisible(true);
                clicks = boardController.getClicksCount();
                clicksCountMessage.setText(Texts.CLICKS_COUNT + clicks);
            }
        }
    }
}
