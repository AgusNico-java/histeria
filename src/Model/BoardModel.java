package Model;

import Observer.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardModel {
    private Cell[][] grid;
    private int gridCells = 5;
    private int gridSize = 1024 ;//TODO: TAMAÑO VENTANA DEL FORM???
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};
    private List<Observer> observers;


    public BoardModel(int gridCells) {
        observers = new ArrayList<Observer>();
        this.gridCells = gridCells;
        grid = new Cell[gridCells][gridCells ];

        int buttonSize = gridSize/gridCells;

        //TODO: REVISAR COMO CALCULAR EL TAMAÑANO EN BASE AL TAMAÑA DE LA GRILLA
        for (int i = 0; i < gridCells; i++) {
            for (int j = 0; j < gridCells; j++) {
                grid[i][j] = new Cell(i, j, buttonSize);
            }
        }
    }

    public int getGridCells(){
        return gridCells;
    }
    //TODO: EL OBSERVADOR PASA LA CELDA CLICKEADA > SE COMPARA ARRIBA, ABAJO,DER E IZQ
    public Boolean compare(Cell cell){
        //ACTUALIZA CELDA

        //
        return  false;

    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public void updateCellColor(int row, int column, Color color) {
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
}
