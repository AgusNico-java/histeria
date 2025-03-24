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
        boardModel.generateCellColor(row, column);
        Boolean cleanCellColor = boardModel.updateColorsAroundCell(row, column);
        if (cleanCellColor) {
            boardModel.updateCellColor(row, column, Color.GRAY);
        }
    }
}
