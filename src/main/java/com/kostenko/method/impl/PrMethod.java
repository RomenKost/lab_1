package com.kostenko.method.impl;

import com.kostenko.method.CustomMethod;

import java.util.stream.IntStream;

public class PrMethod implements CustomMethod {
    @Override
    public Double[] calculate(Double[][] matrix) {
        int size = matrix.length;
        Double[] aVars = IntStream.range(1, size).mapToObj(i -> matrix[i][i - 1]).toArray(Double[]::new);
        Double[] cVars = IntStream.range(0, size).mapToObj(i -> - matrix[i][i]).toArray(Double[]::new);
        Double[] bVars = IntStream.range(1, size).mapToObj(i -> matrix[i - 1][i]).toArray(Double[]::new);
        Double[] fVars = IntStream.range(0, size).mapToObj(i -> - matrix[i][size]).toArray(Double[]::new);

        Double[] alphaVars = new Double[size];
        Double[] betaVars = new Double[size];
        Double[] zVars = new Double[size];

        alphaVars[1] = bVars[0]/cVars[0];
        betaVars[1] = fVars[0]/cVars[0];

        for(int i = 1; i < size - 1; i++) {
            zVars[i] = cVars[i] - aVars[i - 1]*alphaVars[i];
            alphaVars[i + 1] = bVars[i] / zVars[i];
            betaVars[i + 1] = (fVars[i] + aVars[i - 1]*betaVars[i]) / zVars[i];
        }

        Double[] result = new Double[size];
        result[size - 1] = (fVars[size - 1] + aVars[size - 2] * betaVars [size - 1])
                / (cVars[size - 1] - aVars[size - 2] * alphaVars[size - 1]);

        for (int i = size - 2; i >= 0; i--) {
            result[i] = alphaVars[i + 1] * result[i + 1] + betaVars[i + 1];
        }
        return result;
    }
}
