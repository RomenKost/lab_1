package com.kostenko.method.impl;

import com.kostenko.method.CustomMethod;

import java.util.Arrays;

public class JacobiMethod implements CustomMethod {
    private static final double EPS = 0.000000001;
    private static final int LAST_ITERATION = 1000;

    @Override
    public Double[] calculate(Double[][] matrix) {
        int iteration = 0;
        int size = matrix.length;

        Double[] x = new Double[size];
        Double[] p = new Double[size];
        Arrays.fill(x, 0.0);
        Arrays.fill(p, 0.0);

        while (true) {
            for (int i = 0; i < size; i++) {
                Double sum = matrix[i][size];

                for (int j = 0; j < size; j++) {
                    if (j != i) {
                        sum -= matrix[i][j] * p[j];
                    }
                }
                x[i] = 1/matrix[i][i] * sum;
            }

            if (iteration++ == LAST_ITERATION) {
                return x;
            }

            for (int i = 0; i < size; i++)
                if (Math.abs(x[i] - p[i]) > EPS) {
                    break;
                }

            p = x.clone();
        }
    }
}
