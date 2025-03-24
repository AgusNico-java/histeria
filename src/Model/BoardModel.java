package Model;

import Observer.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardModel implements Board{
    private Cell[][] grid;
    private int gridCells = 5;
    private int gridSize = 1024 ;//TODO: TAMAÑO VENTANA DEL FORM???
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};
    private List<Observer> observers;


    public BoardModel(int gridCells) {
        observers = new ArrayList<Observer>();
        grid = new Cell[gridCells][gridCells];
        this.gridCells = gridCells;
        int buttonSize = gridSize/gridCells;

        //TODO: REVISAR COMO CALCULAR EL TAMAÑANO EN BASE AL TAMAÑA DE LA GRILLA
        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                grid[i][j] = new Cell(i, j, buttonSize);
            }
        }
    }

    //TODO: EL OBSERVADOR PASA LA CELDA CLICKEADA > SE COMPARA ARRIBA, ABAJO,DER E IZQ
    public Boolean updateColorsAroundCell(Cell cell){
        Boolean updateUp = updateColor(cell, cell.getRow() - 1, cell.getColumn());
        Boolean updateDown = updateColor(cell, cell.getRow() + 1, cell.getColumn());
        Boolean updateLeft = updateColor(cell, cell.getRow(), cell.getColumn() - 1);
        Boolean updateRight = updateColor(cell, cell.getRow() , cell.getColumn() + 1);

        return updateUp || updateDown || updateLeft || updateRight;
    }

    public void updateCellColor(Cell cell, Color color){
        cell.setColor(color);
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private Boolean updateColor(Cell cell, int row, int column){
        if (row >= 0 && row < this.gridCells && column >= 0 && column < this.gridCells) {
            if (cell.compareColor(grid[row][column])){
                grid[row][column].setColor(Color.GRAY);
                return true;
            }
        }
        return false;
    }
}
