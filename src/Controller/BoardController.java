package Controller;

import Model.BoardModel;

public class BoardController {
    private BoardModel boardModel;

    public BoardController(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    //TODO: MANEJAR LOS EVENTOS DE CLIC
    public void cellSellected(int row, int column) {
        System.out.println(row + " " + column);

    }

    public int getGridCells(){
        return boardModel.getGridCells();
    }

}
