package Model;

import java.awt.*;

public interface Board {

    public Boolean updateColorsAroundCell(Cell cell);
    Cell getCell(int row, int column);
    void updateCellColor(Cell cell, Color color);

}
