package br.eduprivate.effective.c11.item77.enumsingleton;

// Enum singleton - the preferred approach - Page 311
import java.util.Arrays;

public enum Elvis {
    INSTANCE;
    private final String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}