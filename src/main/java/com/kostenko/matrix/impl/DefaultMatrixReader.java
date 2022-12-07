package com.kostenko.matrix.impl;

import com.kostenko.matrix.MatrixReader;
import com.kostenko.matrix.exceptions.MatrixNotFound;

import java.io.*;
import java.util.Arrays;

public class DefaultMatrixReader implements MatrixReader {
    @Override
    public Double[][] read(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            return bufferedReader.lines()
                    .map(line -> line.split(" "))
                    .map(strings -> Arrays.stream(strings)
                            .map(Double::parseDouble)
                            .toArray(Double[]::new))
                    .toArray(Double[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MatrixNotFound(e);
        }
    }
}
