package Model;

import java.awt.*;

public class Cell {
    private Color color;
    private int row;
    private int Column;
    private int size ;


    //TODO: DEBERIA PONER UN COLOR POR DEFECTO? O ESO YA ES LOGICA?
    public Cell(int row, int column, int size) {
        this.color = Color.gray;
        this.row = row;
        this.Column = column;
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
        return Column;
    }

    public boolean compareColor(Cell cell){
        return this.color == cell.color;
    }

}
