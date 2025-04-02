package Model.bussinessValues;

import java.awt.Color;
import java.util.Arrays;

public enum GameColor {

    RED("Red", new Color(0xF44336), false),
    BLUE("Blue", new Color(0x2196F3), false),
    GREEN("Green", new Color(0x4CAF50), false),
    YELLOW("Yellow", new Color(0xFFEB3B), false),
    CYAN("Cyan", new Color(0x00BCD4), false),
    ORANGE("Orange", new Color(0xFF9800), false),

    BASE_GRAY("Base Gray", new Color(0xB0BEC5), true);

    private final String name;
    private final Color awtColor;
    private final boolean isBase;

    GameColor(String name, Color awtColor, boolean isBase) {
        this.name = name;
        this.awtColor = awtColor;
        this.isBase = isBase;
    }

    public String getName() {
        return name;
    }

    public Color getAwtColor() {
        return awtColor;
    }

    public boolean isBase() {
        return isBase;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(GameColor color) {
        return this.awtColor.equals(color.awtColor);
    }

    public static GameColor[] gameColorsOnly() {
        return Arrays.stream(values())
                .filter(gc -> !gc.isBase())
                .toArray(GameColor[]::new);
    }
}
