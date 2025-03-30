import Controller.BoardController;
import Model.BoardModel;
import Model.bussinessValues.EventType;
import View.BoardView;
import View.LevelView;
import View.WinView;

import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoardModel boardModel = new BoardModel();
            BoardController boardController = new BoardController(boardModel);

            LevelView levelView = new LevelView(boardController);
            levelView.setVisible(true);
            boardModel.eventManager.subscribe(EventType.REPLAY.name(), levelView);

            BoardView boardView = new BoardView(boardController);
            boardModel.eventManager.subscribe(EventType.WIN.name(), boardView);
            boardModel.eventManager.subscribe(EventType.UPDATE_BOARD.name(), boardView);
            boardModel.eventManager.subscribe(EventType.START.name(), boardView);

            WinView winView = new WinView(boardController);
            boardModel.eventManager.subscribe(EventType.WIN.name(), winView);
        });
    }
}