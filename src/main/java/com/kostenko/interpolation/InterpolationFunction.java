package com.kostenko.interpolation;

import com.kostenko.function.CustomFunction;
import com.kostenko.node.NodeService;

import java.util.Arrays;

public class InterpolationFunction implements CustomFunction {
    private final NodeService nodeService;
    private final CustomFunction customFunction;

    public InterpolationFunction(NodeService nodeService, CustomFunction customFunction) {
        this.nodeService = nodeService;
        this.customFunction = customFunction;
    }

    @Override
    public double calculate(double x) {
        Double[] xArgs = nodeService.getNodes();
        Double[] yArgs = Arrays.stream(xArgs).map(customFunction::calculate).toArray(Double[]::new);

        Double[] aArgs = new Double[yArgs.length];
        aArgs[0] = yArgs[0];
        for (int i = 1; i < yArgs.length; i++) {
            double partSum = 0;
            double partMult = 1;
            for (int j = 0; j < i; j++) {
                partSum += aArgs[j]*partMult;
                partMult *= xArgs[i] - xArgs[j];
            }
            aArgs[i] = (yArgs[i] - partSum) / partMult;
        }

        double result = 0;
        double partMult = 1;
        for (int i = 0; i < yArgs.length; i++) {
            result += aArgs[i]*partMult;
            partMult *= x - xArgs[i];
        }

        return result;
    }
}
