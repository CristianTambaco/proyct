package utils;
import javafx.scene.paint.Color;

public enum Colors {

    RED_LIGHT ("#970000FF"),
    RED_DARK ("#FF0000FF"),
    WHITE("#FFFFFFFF"),
    BLACK("#000000FF");

    private final String hex;
    Colors(String hex) { this.hex = hex; }

    /**
     * Devuelve el color en formato hexadecimal
    */
    public String getHex() { return hex; }

    /**
     * Devuelve el color como un objeto `Color` de JavaFX
    */
    public Color getColor() { return Color.web(hex); }
}