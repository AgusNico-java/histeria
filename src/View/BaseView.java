package View;

import Observer.Observer;

import javax.swing.*;

public class BaseView extends JFrame implements Observer {
    private String title = "Hysteria Game";

    public BaseView(){
        setTitle(title);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(String eventType) {
        throw new IllegalArgumentException("Evento desconocido: " + eventType);
    }
}
