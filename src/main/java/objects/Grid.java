package main.java.objects;

public class Grid {
    private int length_matrix, width_matrix;

    public Grid(int length_matrix, int width_matrix) {
        this.length_matrix = length_matrix;
        this.width_matrix = width_matrix;
    }

    public int getLength() {
        return length_matrix;
    }

    public int getWidth() {
        return width_matrix;
    }
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < length_matrix && y >= 0 && y < width_matrix;
    }
}
