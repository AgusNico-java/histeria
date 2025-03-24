package Controller;

import Model.BoardModel;
import Model.Cell;

import java.awt.*;

public class BoardController {
    private BoardModel boardModel;

    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public void updateBoardOnClick(int row, int column){
        //TODO: Generar un color random
        Color color = Color.RED;
        Cell cell = boardModel.getCell(row, column);
        boardModel.updateCellColor(cell, color);
        Boolean cleanCellColor = boardModel.updateColorsAroundCell(cell);
        if (cleanCellColor) {
            boardModel.updateCellColor(cell, Color.GRAY);
        }
    }
}
