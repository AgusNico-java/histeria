package Model;

import Model.bussinessValues.EventType;
import Observer.EventManager;

import java.awt.*;
import java.util.Random;

public class BoardModel {
    private Cell[][] grid;
    private int gridCells = 5;
    private final GameColor[] possibleColors = GameColor.gameColorsOnly();
    public EventManager eventManager;
    private int totalGrayCells;
    private int clicks = 0;

    public BoardModel(){
        this.eventManager = new EventManager();
    }

    public void initBoard(int gridCells) {
        this.gridCells = gridCells;
        grid = new Cell[gridCells][gridCells];

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

    public boolean updateColorsAroundCell(int row, int column) {
        Cell cell = getCell(row, column);
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        boolean updated = false;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            if (updateColor(cell, newRow, newCol)) {
                updated = true;
            }
        }

        return updated;
    }

    public void updateCellColor(int row, int column, GameColor color){
        Cell cell = getCell(row, column);
        updateTotalGrays(color, cell);
        cell.setColor(color);
        checkWin();
        eventManager.notify(EventType.UPDATE_BOARD.name());
    }

    private  void updateTotalGrays(GameColor color, Cell cell) {
        if (color.equals(GameColor.BASE_GRAY)) {
            this.totalGrayCells += 1;
        }
        if (cell.getColor().equals(GameColor.BASE_GRAY.getAwtColor())){
            this.totalGrayCells -= 1;
        }
    }

    public void generateCellColor(int row, int column) {
        GameColor newColor = possibleColors[new Random().nextInt(6)];
        updateCellColor(row,column, newColor);
    }

    private Boolean updateColor(Cell cell, int row, int column){
        if (row >= 0 && row < this.gridCells && column >= 0 && column < this.gridCells) {
            if (cell.compareColor(grid[row][column])){
                updateCellColor(row, column, GameColor.BASE_GRAY);
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
        this.clicks = 0;
    }
}
