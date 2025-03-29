package View;

import Controller.BoardController;
import Model.values.EventType;
import Observer.Observer;
import Utils.Texts;

import javax.swing.*;
import java.awt.*;

public class WinView extends BaseView {
    private JLabel winMessage;
    private JButton startButton;
    private BoardController boardController;

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
        winMessage.setFont(new Font("Arial", Font.BOLD, 36));
        winMessage.setBorder(BorderFactory.createEmptyBorder(10, 30, 70, 30));
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(winMessage, gbc);

        startButton = new JButton(Texts.START);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(startButton, gbc);
    }

    public void update(String eventType) {
        switch (EventType.valueOf(eventType)) {
            case WIN -> setVisible(true);
        }
    }
}
