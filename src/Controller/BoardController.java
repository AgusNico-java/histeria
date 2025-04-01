package Controller;

import Model.BoardModel;
import Model.bussinessValues.Level;
import Model.GameColor;

import java.awt.*;


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
        boardModel.initBoard(level.getGridSize());
    }

    public void updateBoardOnClick(int row, int column){
        click();
        boardModel.generateCellColor(row, column);
        Boolean cleanCellColor = boardModel.updateColorsAroundCell(row, column);
        if (cleanCellColor) {
            boardModel.updateCellColor(row, column, GameColor.BASE_GRAY);
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

    public String[] getAvailableLevels() {
        return Level.getLabels();
    }

    public int getClicksCount() {
        return boardModel.getClicks();
    }
}
