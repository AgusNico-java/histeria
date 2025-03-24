package Controller;

import Model.Board;
import Model.Cell;

import java.awt.*;

public class BoardController {
    private Board boardModel;

    public BoardController(Board boardModel) {
        this.boardModel = boardModel;
    }


    public int getGridCells(){
        return boardModel.getGridCells();
    }

    public void updateBoardOnClick(int row, int column){
        System.out.println(row + " " + column);
        //TODO: Generar un color random
        Color color = boardModel.getRandomColor();
        Cell cell = boardModel.getCell(row, column);
        boardModel.updateCellColor(cell, color);
        Boolean cleanCellColor = boardModel.updateColorsAroundCell(cell);
        if (cleanCellColor) {
            boardModel.updateCellColor(cell, Color.GRAY);
        }
    }
}
