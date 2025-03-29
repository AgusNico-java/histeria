package Model;

import Model.values.EventType;
import Observer.EventManager;

import java.awt.Color;
import java.util.Random;

public class BoardModel {
    private Cell[][] grid;
    private int gridCells = 5;
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};
    public EventManager eventManager;
    private int totalGrayCells;
    private int clicks = 0;

    public BoardModel(){
        this.eventManager = new EventManager();
    }

    public void initBoard(int gridCells) {
        this.gridCells = gridCells;
        grid = new Cell[gridCells][gridCells];

        //Inicializa los valores de los atributos fila y columna de cada celda
        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }

        this.totalGrayCells = gridCells * gridCells;
        eventManager.notify(EventType.START.name());
    }

    public int getGridCells(){
        return gridCells;
    }

    public Boolean updateColorsAroundCell(int row, int column){
        Cell cell = getCell(row, column);
        Boolean updateUp = updateColor(cell, cell.getRow() - 1, cell.getColumn());
        Boolean updateDown = updateColor(cell, cell.getRow() + 1, cell.getColumn());
        Boolean updateLeft = updateColor(cell, cell.getRow(), cell.getColumn() - 1);
        Boolean updateRight = updateColor(cell, cell.getRow() , cell.getColumn() + 1);

        return updateUp || updateDown || updateLeft || updateRight;
    }

    public void updateCellColor(int row, int column, Color color){
        Cell cell = getCell(row, column);

        if (color.equals(Color.GRAY)) {
            this.totalGrayCells += 1;
        }
        if (cell.getColor().equals(Color.GRAY)){
            this.totalGrayCells -= 1;
        }
        cell.setColor(color);
        checkWin();
        eventManager.notify(EventType.UPDATE_BOARD.name());
    }

    public void generateCellColor(int row, int column) {
        Color newColor = possibleColors[new Random().nextInt(6)];
        updateCellColor(row,column, newColor);
    }

    private Boolean updateColor(Cell cell, int row, int column){
        if (row >= 0 && row < this.gridCells && column >= 0 && column < this.gridCells) {
            if (cell.compareColor(grid[row][column])){
                updateCellColor(row, column, Color.GRAY);
                return true;
            }
        }
        return false;
    }

    private Cell getCell(int row, int column) {
        return grid[row][column];
    }
    
    private void checkWin(){
        if (totalGrayCells == 0){
            eventManager.notify(EventType.WIN.name());
        }
    }

    public Color getCellColor(int i, int j) {
        return grid[i][j].getColor();
    }

    public void click(){
        this.clicks += 1;
    }

    public int getClicks() {
        return this.clicks;
    }

    public void replay() {
        this.eventManager.notify(EventType.REPLAY.name());
    }
}
