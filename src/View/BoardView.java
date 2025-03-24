package View;

import Controller.BoardController;
import Observers.Observer;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame implements Observer {

    private BoardController boardController;

    public BoardView (BoardController boardController) {
        this.boardController = boardController;
        int gridCells = boardController.getGridCells();
        JButton[][] gridButtons = new JButton[gridCells][gridCells];

        // Configurar el JFrame

        setTitle("Hysteria Game");
        setLayout(new GridLayout(gridCells, gridCells));
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Initialize the grid of buttons
        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                gridButtons[i][j] = new JButton();
                gridButtons[i][j].setBackground(Color.WHITE);
                int x = i, y = j;
                gridButtons[i][j].addActionListener(e -> boardController.updateBoardOnClick(x,y));
                add(gridButtons[i][j]);
            }
        }
    }

    @Override
    public void notificar() {

    }

}
