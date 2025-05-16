package test.java;

import main.java.RoverApp;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoverAppTest {

    @Test
    public void testMainWithValidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String filePath = "src/test/resources/input.txt";
        String[] args = { filePath };

        RoverApp.main(args);

        System.setOut(originalOut);

        String expectedOutput = "1 3 N\n5 1 E\n";
        assertEquals(expectedOutput, outputStream.toString().replace("\r\n", "\n"));
    }

    @Test
    public void testMainWithEmptyInputFile() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        String filePath = "src/test/resources/empty.txt";
        String[] args = { filePath };

        RoverApp.main(args);

        System.setOut(originalOut);

        String expectedOutput = "Input file is empty\n";
        assertEquals(expectedOutput, outputStream.toString().replace("\r\n", "\n"));
    }
}