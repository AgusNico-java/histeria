package View;

import Controller.BoardController;
import Model.bussinessValues.EventType;

import javax.swing.*;
import java.awt.*;

public class BoardView extends BaseView {
    private final BoardController boardController;
    private final JPanel gridPanel;
    private JButton[][] gridButtons;

    public BoardView(BoardController boardController) {
        this.boardController = boardController;

        gridPanel = new JPanel();
        add(gridPanel);
    }

    private void buildGrid() {
        gridPanel.removeAll();

        int gridCells = boardController.getGridCells();
        gridPanel.setLayout(new GridLayout(gridCells, gridCells));
        gridButtons = new JButton[gridCells][gridCells];

        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                JButton cell = new JButton();
                cell.setOpaque(true);
                cell.setBorderPainted(true);
                cell.setBackground(Color.WHITE);
                initCellListener(cell, i, j);
                gridButtons[i][j] = cell;
                gridPanel.add(cell);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void initCellListener(JButton cell, int x, int y) {
        cell.addActionListener(e -> boardController.updateBoardOnClick(x, y));
    }

    private void updateColors() {
        int gridCells = boardController.getGridCells();

        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                Color modelColor = boardController.getCellColor(i, j);
                gridButtons[i][j].setBackground(modelColor);
            }
        }
    }

    @Override
    public void update(String eventType) {
        switch (EventType.valueOf(eventType)) {
            case START -> {
                buildGrid();
                updateColors();
                setVisible(true);
            }
            case UPDATE_BOARD -> updateColors();
            case WIN -> setVisible(false);
        }
    }
}
