import Controller.BoardController;
import Model.BoardModel;
import Model.values.EventType;
import View.BoardView;
import View.LevelView;
import View.WinView;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardModel boardModel = new BoardModel();
            BoardController boardController = new BoardController(boardModel);

            LevelView levelView = new LevelView(boardController);
            levelView.setVisible(true);

            BoardView boardView = new BoardView(boardController);
            boardModel.eventManager.subscribe(EventType.WIN.name(), boardView);
            boardModel.eventManager.subscribe(EventType.UPDATE_BOARD.name(), boardView);
            boardModel.eventManager.subscribe(EventType.START.name(), boardView);

            WinView winView = new WinView();
            boardModel.eventManager.subscribe(EventType.WIN.name(), winView);
        });
    }
}