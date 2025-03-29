package View;

import Controller.BoardController;
import Model.BoardModel;
import Model.values.EventType;
import Observer.Observer;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame implements Observer {
    private final BoardController boardController;
    private final JPanel gridPanel;
    private JButton[][] gridButtons;

    public BoardView(BoardController boardController) {
        this.boardController = boardController;

        setTitle("Hysteria Game");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel contenedor para la grilla
        gridPanel = new JPanel();
        add(gridPanel);
    }

    private void buildGrid() {
        gridPanel.removeAll(); // Limpia grilla previa

        int gridCells = boardController.getGridCells();
        gridPanel.setLayout(new GridLayout(gridCells, gridCells));
        gridButtons = new JButton[gridCells][gridCells];

        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                JButton cell = new JButton();
                cell.setOpaque(true);
                cell.setBorderPainted(true);
                cell.setBackground(Color.WHITE); // Default
                int x = i, y = j;
                cell.addActionListener(e -> boardController.updateBoardOnClick(x, y));
                gridButtons[i][j] = cell;
                gridPanel.add(cell);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
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
            default -> throw new IllegalArgumentException("Evento desconocido: " + eventType);
        }
    }
}
