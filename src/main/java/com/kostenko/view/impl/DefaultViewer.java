package com.kostenko.view.impl;

import com.kostenko.function.CustomFunction;
import com.kostenko.view.Viewer;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class DefaultViewer extends Canvas implements Viewer {
    private List<CustomFunction> customFunctions;
    private List<Color> colors = Arrays.asList(Color.BLACK, Color.RED, Color.BLUE);

    @Override
    public void paint(Graphics g) {
        double h = 12.0/1000.0;
        Double[] x = IntStream.range(0, 1000)
                .mapToObj(i -> -6 + h * i)
                .toArray(Double[]::new);

        int j = 0;
        for (CustomFunction customFunction : customFunctions) {
            int[] y = Arrays.stream(x).map(customFunction::calculate).mapToInt(i -> 300 - (int) (20 * i)).toArray();
            int[] xP = Arrays.stream(x).mapToInt(i -> (int) (100 * i) + 500).toArray();
            g.setColor(colors.get(j));
            g.drawPolyline(xP, y, 1000);
            j++;
        }
    }

    @Override
    public void setFunction(List<CustomFunction> customFunctions) {
        this.customFunctions = customFunctions;
    }
}
