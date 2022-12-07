package com.kostenko.interpolation;

import com.kostenko.function.CustomFunction;
import com.kostenko.node.NodeService;

import java.util.Arrays;

import static com.kostenko.util.Constants.*;

public class InterpolationFunction implements CustomFunction {
    private final NodeService nodeService;
    private final CustomFunction customFunction;

    public InterpolationFunction(NodeService nodeService, CustomFunction customFunction) {
        this.nodeService = nodeService;
        this.customFunction = customFunction;
    }

    @Override
    public double calculate(double x) {
        double h = (END_RANGE - START_RANGE)/(COUNT_OF_NODES - 1);
        double q = (x - START_RANGE)/h;

        Double[] xArgs = nodeService.getNodes();
        Double[] yArgs = Arrays.stream(xArgs).map(customFunction::calculate).toArray(Double[]::new);

        Double[][] deltaY = new Double[yArgs.length][yArgs.length];
        deltaY[0] = yArgs;
        for (int i = 1; i < yArgs.length; i++) {
            for (int j = 0; j < yArgs.length - i; j++) {
                deltaY[i][j] = deltaY[i-1][j+1] - deltaY[i-1][j];
            }
        }

        double interpolationSum = yArgs[0];
        double summary = interpolationSum;
        for (int i = 1; i < yArgs.length; i++) {
            summary = summary / yArgs[i-1] * yArgs[i] / i * q;
            q--;
            interpolationSum += summary;
        }
        return summary;
    }
}
