package main.java;

import main.java.objects.Grid;
import main.java.objects.Orientation;
import main.java.objects.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoverApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar rover.jar <input_file_path>");
            return;
        }

        String filePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line == null) {
                System.out.println("Input file is empty");
                return;
            }
            // Read grid dimensions
            String[] dimensions = line.split(" ");
            int gridWidth, gridHeight;
            try {
                gridWidth = Integer.parseInt(dimensions[0]);
                gridHeight = Integer.parseInt(dimensions[1]);
            } catch (NumberFormatException e) {
                System.err.println("Error: Grid dimensions must be integers.");
                return;
            }

            Grid grid = new Grid(gridWidth, gridHeight);
            List<String> output = new ArrayList<>();

            // Process each rover
            while ((line = br.readLine()) != null) {
                String[] roverData = line.split(" ");
                if (roverData.length != 3) {
                    System.err.println("Error: Rover position and orientation must have exactly three components.");
                    continue;
                }

                int x, y;
                Orientation orientation;
                try {
                    x = Integer.parseInt(roverData[0]);
                    y = Integer.parseInt(roverData[1]);
                    orientation = Orientation.valueOf(roverData[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Rover coordinates must be integers.");
                    continue;
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: Invalid orientation. Valid values are: " + java.util.Arrays.toString(Orientation.values()));
                    continue;
                }

                Rover rover = new Rover(x, y, orientation);

                String instructions = br.readLine();
                if (instructions == null || instructions.trim().isEmpty()) {
                    System.err.println("Error: Instructions for rover are missing or empty.");
                    continue;
                }

                rover.executeCommand(instructions);
                output.add(rover.toString());
            }

            // Output final positions
            for (String lineOutput : output) {
                System.out.println(lineOutput);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
