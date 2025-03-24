package enums;

public enum Difficulty {
    FACIL(5),
    MEDIO(8),
    DIFICIL(10);

    private int cantidadDeCeldas;

    Difficulty(int celdas) {
        this.cantidadDeCeldas = celdas;
    }

    public int getCantidadDeCeldas() {
        return cantidadDeCeldas;
    }

}
