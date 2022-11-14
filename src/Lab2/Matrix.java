package Lab2;

import javax.swing.event.DocumentEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Matrix {
    private double[][] data = null;
    private int rows = 0;
    private int cols = 0;

    public Matrix(double[][] data, int rows, int cols) {
        this.data = data;
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Invalid number of rows and columns : " + n);
        }
        this.cols = n;
        this.rows = n;
        data = new double[rows][cols];
    }

    public Matrix(int r, int c){
        if (r < 0) {
            throw new IllegalArgumentException("Invalid number of rows: " + r);
        }
        if (c < 0) {
            throw new IllegalArgumentException("Invalid number of columns : " + c);
        }
        this.rows = r;
        this.cols = c;
        data = new double[rows][cols];
    }

    void fillRandomly() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Math.random();
            }
        }
    }

    void writeToFile(File outFile) throws IOException {
        try (FileWriter writer = new FileWriter(outFile, true)) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(String.format("%.2f", data[i][j]));
                    writer.write("\t");
                }
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            throw new IOException("Problems while writing to file");
        }

    }

    public Matrix rotateBack90() {
        Matrix mtx90 = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mtx90.data[i][j] = data[j][data.length - i - 1];
            }
        }
        return mtx90;
    }

    public Matrix rotateBack180() {
        Matrix mtx180 = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mtx180.data[i][j] = data[data.length - i - 1][data.length - j - 1];
            }
        }
        return mtx180;
    }

    public Matrix rotateBack270() {
        Matrix mtx270 = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mtx270.data[i][j] = data[data.length - j - 1][i];
            }
        }
        return mtx270;
    }

    public Matrix divideByAdjacent () throws DivisionByZeroException {
        Matrix mtx = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = 0.0;
                if (i > 0) {
                    sum += data[i-1][j];
                }
                if (i < cols - 1) {
                    sum += data[i+1][j];
                }
                if (j > 0) {
                    sum += data[i][j-1];
                }
                if (j < rows - 1) {
                    sum += data[i][j+1];
                }
                if (sum == 0) {
                    throw new DivisionByZeroException("You tried to divide by 0!");
                }
                mtx.data[i][j] = this.data[i][j] / sum;
            }
        }
        return mtx;
    }

}
