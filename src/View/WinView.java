package View;

import Controller.BoardController;
import Model.bussinessValues.EventType;
import Utils.Texts;
import View.Components.CustomButton;
import View.Components.CustomTitleLabel;

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

        winMessage = new CustomTitleLabel(Texts.WIN);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        add(winMessage, gbc);

        clicksCountMessage = new JLabel();
        clicksCountMessage.setFont(new Font("Arial", Font.PLAIN, 17));
        clicksCountMessage.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        add(clicksCountMessage, gbc);

        startButton = startButton = new CustomButton(Texts.START);

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
