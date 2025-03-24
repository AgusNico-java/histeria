import Controller.BoardController;
import Controller.LevelController;
import Model.BoardModel;
import Model.LevelModel;
import View.BoardView;
import View.LevelView;
import View.WinView;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            //######################### SHOW LEVELS ###################
            // 1. Crear el modelo
            LevelModel levelModel = new LevelModel();
            // 2. Crear el controlador
            LevelController levelController = new LevelController(levelModel);
            // 3. Crear la vista, inyectando el controlador
            LevelView levelView = new LevelView(levelController);
            // 4. Registrar la vista como observer en el modelo
            levelModel.addObserver(levelView);
            // 5. Mostrar la ventana
            levelView.setVisible(true);

            //TODO: CAPTURAR LA DIFICULTAD -> QUE CANTIDAD DE CELDAS HAY



            //######################### SHOW BOARD ###################

            // 1. Crear el modelo
            BoardModel boardModel = new BoardModel(6);
            // 2. Crear el controlador
            BoardController boardController = new BoardController(boardModel);
            // 3. Crear la vista, inyectando el controlador
            BoardView boardView = new BoardView(boardController);
            // 4. Registrar la vista como observer en el modelo
            boardModel.addObserver(boardView);
            // 5. Mostrar la ventana
            boardView.setVisible(true);

            WinView winView = new WinView();
            boardModel.addObserver(winView);
        });
    }
}