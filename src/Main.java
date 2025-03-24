import View.BoardView;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Crear el modelo
            //Calculator model = new Calculator();

            // 2. Crear el controlador
            //CalculatorController controller = new CalculatorController(model);

            // 3. Crear la vista, inyectando el controlador
            BoardView view = new BoardView(controller);

            // 4. Registrar la vista como observer en el modelo
            //model.addObserver(view);

            // 5. Mostrar la ventana
            view.setVisible(true);
        });
    }
}