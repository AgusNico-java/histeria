package View.Components;
import javax.swing.*;
import java.awt.*;


public class CustomTitleLabel extends JLabel {
    public CustomTitleLabel(String text) {
        super(text, SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 32));
        setForeground(new Color(33, 150, 243));
    }
}