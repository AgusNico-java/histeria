package Model;

import java.awt.*;

public class BoardModel {
    private Cell[][] grid;
    private int columns = 5;
    private int gridSize = 1024 ;//TODO: TAMAÑO VENTANA DEL FORM???
    private Color[] possibleColors = {Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.CYAN, Color.ORANGE};

    public BoardModel() {
        grid = new Cell[columns][columns];
        //TODO: REVISAR COMO CALCULAR EL TAMAÑANO EN BASE AL TAMAÑA DE LA GRILLA
        int buttonSize = gridSize / columns;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = new Cell(i, j, buttonSize);
            }
        }
    }

    //TODO: EL OBSERVADOR PASA LA CELDA CLICKEADA > SE COMPARA ARRIBA, ABAJO,DER E IZQ
    public Boolean compare(Cell cell){
        //ACTUALIZA CELDA

        //



    }



}
