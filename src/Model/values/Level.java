package Model.values;

import java.util.Arrays;

public enum Level {
    FACIL("Facil"),
    MEDIO("Medio"),
    DIFICIL("Dificil");

    private final String value;

    Level(String value) {
        this.value = value;
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