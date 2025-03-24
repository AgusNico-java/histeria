import Controller.LevelController;
import Model.LevelModel;
import Observer.Observer;
import View.LevelView;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
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
        });
    }
}