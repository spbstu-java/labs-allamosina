package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainApp {
    public static final File inFile
            = new File("./src/Lab2/input.txt");
    public static final File outFile
            = new File("./src/Lab2/output.txt");

    public static void main(String[] args) {
        try {
            int n = getNum(inFile);
            if (n < 1 || n > 1_000_000) {
                throw new NumberLimitException("Number of rows an columns is not between 1 and 1 000 000!");
            }
            Matrix mtx = new Matrix(n);
            mtx.fillRandomly();
            Matrix mtx90 = mtx.rotateBack90().divideByAdjacent();
            mtx90.writeToFile(outFile);
            Matrix mtx180 = mtx.rotateBack180().divideByAdjacent();
            mtx180.writeToFile(outFile);
            Matrix mtx270 = mtx.rotateBack270().divideByAdjacent();
            mtx270.writeToFile(outFile);

        } catch (Exception | OutOfMemoryError e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private static int getNum(File inFile) throws IOException {
        try (Scanner scanner = new Scanner(inFile)) {
            return scanner.nextInt();
        } catch (FileNotFoundException e) {
            throw new NoFileOrAccessException("Problems finding or accessing file!");
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input must be an integer");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Empty file or wrong data!");
        }
    }

}

