package Model.values;

import Utils.GameConfig;

import java.util.Arrays;

public enum Level {
    FACIL("Facil", GameConfig.EASY),
    MEDIO("Medio", GameConfig.MEDIUM),
    DIFICIL("Dificil", GameConfig.HARD);

    private final String value;
    private final int size;

    Level(String value, int size) {
        this.value = value;
        this.size = size;
    }

    public int getGridSize() {
        return size;
    }

    public String getValue() {
        return value;
    }

    public static Level fromString(String text) {
        for (Level level : Level.values()) {
            if (level.getValue().equalsIgnoreCase(text)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Nivel inválido: " + text);
    }

    public static String[] getLabels() {
        return Arrays.stream(values())
                .map(Level::getValue)
                .toArray(String[]::new);
    }

    @Override
    public String toString() {
        return value;
    }
}