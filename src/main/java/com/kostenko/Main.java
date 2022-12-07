package com.kostenko;

import com.kostenko.matrix.MatrixReader;
import com.kostenko.matrix.impl.DefaultMatrixReader;
import com.kostenko.method.CustomMethod;
import com.kostenko.method.impl.JacobiMethod;
import com.kostenko.method.impl.PrMethod;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        MatrixReader matrixReader = new DefaultMatrixReader();

        Double[][] prMatrix = matrixReader.read("src/main/resources/matrix_pr.txt");
        CustomMethod prMethod = new PrMethod();
        String prLog = Arrays.toString(prMethod.calculate(prMatrix));
        log.info(prLog);

        Double[][] jacobiMatrix = matrixReader.read("src/main/resources/matrix_jacobi.txt");
        CustomMethod jacobiMethod = new JacobiMethod();
        String jacobiLog = Arrays.toString(jacobiMethod.calculate(jacobiMatrix));
        log.info(jacobiLog);
    }
}
