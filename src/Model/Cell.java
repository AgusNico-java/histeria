package Model;

import java.awt.*;

public class Cell {
    private Color color;
    private int row;
    private int column;

    public Cell(int row, int column) {
        //TODO: VALIDAR QUE NO SE PASE MENOR A CERO
        this.color = Color.gray;
        this.row = row;
        this.column = column;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public boolean compareColor(Cell cell) {
        return this.color.equals(cell.color);
    }



}
