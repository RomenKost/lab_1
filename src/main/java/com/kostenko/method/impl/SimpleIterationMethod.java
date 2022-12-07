package com.kostenko.method.impl;

import com.kostenko.function.CustomFunction;
import com.kostenko.method.CustomMethod;
import com.kostenko.method.dto.ResultDto;

import java.util.logging.Logger;

import static com.kostenko.util.Constants.*;

public class SimpleIterationMethod implements CustomMethod {
    public final CustomFunction customFunction;
    public final Logger log = Logger.getLogger(SimpleIterationMethod.class.getName());

    public SimpleIterationMethod(CustomFunction customFunction) {
        this.customFunction = customFunction;
    }

    @Override
    public ResultDto calculate() {
        int i = 0;
        double x = START_POINT;
        log(x, i);
        while (Math.abs(customFunction.calculate(x)) >= EPS) {
            x = nextX(x);
            i++;

            log(x, i);
        }
        return new ResultDto(i, x);
    }

    private double nextX(double x) {
        return customFunction.calculate(x)*teta() + x;
    }

    private double teta() {
        return -0.01;
    }

    private void log(double x, int i) {
        String logInfo = "iteration: " + i + ", x: " + x;
        log.info(logInfo);
    }
}
