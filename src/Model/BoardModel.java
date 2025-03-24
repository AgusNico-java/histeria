package Model;

import Observers.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardModel implements Board{
    private Cell[][] grid;
    private int gridCells = 5;
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};
    private List<Observer> observers;


    public BoardModel(int gridCells) {
        observers = new ArrayList<Observer>();
        this.gridCells = gridCells;
        grid = new Cell[gridCells][gridCells];


        //TODO: REVISAR COMO CALCULAR EL TAMAÑANO EN BASE AL TAMAÑA DE LA GRILLA
        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public int getGridCells(){
        return gridCells;
    }

    //TODO: EL OBSERVADOR PASA LA CELDA CLICKEADA > SE COMPARA ARRIBA, ABAJO,DER E IZQ
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
        cell.setColor(color);
    }

    private Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public void generateCellColor(int row, int column) {
        Color newColor = possibleColors[new Random().nextInt(6)];
        grid[row][column].setColor(newColor);

        // Verificar vecinos
        //if (hayConflicto(x, y)) {
        //   apagarCeldaYVecinos(x, y);
        //}

        //setChanged();          // Marca que hubo un cambio
        //notifyObservers();     // Notifica a la vista

    }

    public boolean hasSameColorNeighbor(Cell cell) {
        int row = cell.getRow();
        int column = cell.getColumn();

        // Array que representa las celdas vecinas: {deltaFila, deltaColumna}
        int[][] directions = {
                {-1, 0},  // Arriba
                {1, 0},   // Abajo
                {0, -1},  // Izquierda
                {0, 1}    // Derecha
        };

        for (int[] direction : directions) {
            int neighborRow = row + direction[0];
            int neighborCol = column + direction[1];

            if (neighborRow >= 0 && neighborRow < gridCells && neighborCol >= 0 && neighborCol < gridCells) {
                Cell neighborCell = getCell(neighborRow, neighborCol);

                if (cell.compareColor(neighborCell)) {
                    return true;
                }
            }
        }

        return false;  // Si ninguna vecina tiene el mismo color
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
