package Controller;

import Model.Board;
import Model.Cell;

import java.awt.*;

public class BoardController {
    private Board boardModel;

    public BoardController(Board boardModel) {
        this.boardModel = boardModel;
    }

    //TODO: MANEJAR LOS EVENTOS DE CLIC
    public void cellSellected(int row, int column) {
        System.out.println(row + " " + column);

    }

    public int getGridCells(){
        return boardModel.getGridCells();
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
