package Model;

import Controller.BoardController;
import Observers.Observer;
import View.BoardView;
import enums.Difficulty;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LevelModel {
    private Difficulty dificultadSeleccionada;
    private List<Observer> observers;

    public LevelModel() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void establecerDificultad(Difficulty difficulty) {
        this.dificultadSeleccionada = difficulty;
        notifyObservers();
    }

    public int gridSize() {
        return this.dificultadSeleccionada.getCantidadDeCeldas();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {

            SwingUtilities.invokeLater(() -> {
                //######################### SHOW BOARD ###################

                // 1. Crear el modelo
                BoardModel boardModel = new BoardModel(gridSize());
                // 2. Crear el controlador
                BoardController boardController = new BoardController(boardModel);
                // 3. Crear la vista, inyectando el controlador
                BoardView boardView = new BoardView(boardController);
                // 4. Registrar la vista como observer en el modelo
                boardModel.addObserver(boardView);
                // 5. Mostrar la ventana
                boardView.setVisible(true);

            });
            observer.notificar();
        }
    }
}
