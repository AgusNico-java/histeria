package View.Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(new Color(33, 150, 243)); // Azul vibrante
        setForeground(Color.WHITE); // Texto blanco
        setFocusPainted(false);
        setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding interno
        setPreferredSize(new Dimension(120, 45));
    }
}