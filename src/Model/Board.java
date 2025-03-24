package Model;

import java.awt.*;

public interface Board {

    int getGridCells();
    Boolean updateColorsAroundCell(int row, int column);
    void updateCellColor(int row, int column, Color color);
    void generateCellColor(int row, int column);

}
