package Model.values;

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

    @Override
    public String toString() {
        return value;
    }
}