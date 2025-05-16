package main.java.objects;

public class Rover {
    private int x;
    private int y;
    private Orientation direction;

    public Rover(int x, int y, Orientation direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;

    }

    public void turnLeft() {
        switch (direction) {
            case N -> direction = Orientation.W;
            case W -> direction = Orientation.S;
            case S -> direction = Orientation.E;
            case E -> direction = Orientation.N;
        }
    }
    public void turnRight() {
        switch (direction) {
            case N -> direction = Orientation.E;
            case E -> direction = Orientation.S;
            case S -> direction = Orientation.W;
            case W -> direction = Orientation.N;
        }
    }
    public void moveForward() {
        switch (direction) {
            case N -> y +=1;
            case S -> y -=1;
            case E -> x +=1;
            case W -> x -=1;
        }
    }

    public void executeCommand(String command) {
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                case 'M' -> moveForward();
                default -> throw new IllegalArgumentException("Invalid command: " + c);
            }
        }
    }

    public String toString() {
        return x + " " + y + " " + direction;
    }
}
