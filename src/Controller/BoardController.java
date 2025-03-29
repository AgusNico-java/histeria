package Controller;

import Model.BoardModel;
import Model.values.Level;
import java.awt.Color;

public class BoardController {
    private BoardModel boardModel;

    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public int getGridCells(){
        return boardModel.getGridCells();
    }

    public void startGame(String levelText) {
        Level level = Level.fromString(levelText);
        switch (level) {
            case FACIL -> boardModel.initBoard(4);
            case MEDIO -> boardModel.initBoard(6);
            case DIFICIL -> boardModel.initBoard(8);
        }
    }

    public void updateBoardOnClick(int row, int column){
        click();
        boardModel.generateCellColor(row, column);
        Boolean cleanCellColor = boardModel.updateColorsAroundCell(row, column);
        if (cleanCellColor) {
            boardModel.updateCellColor(row, column, Color.GRAY);
        }
    }

    private void click(){
        boardModel.click();
        System.out.println(boardModel.getClicks());
    }

    public Color getCellColor(int i, int j) {
        return boardModel.getCellColor(i, j);
    }

    public void replay() {
        boardModel.replay();
    }
}
