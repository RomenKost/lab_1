package com.kostenko.method.impl;

import com.kostenko.function.CustomFunction;
import com.kostenko.method.CustomMethod;
import com.kostenko.method.dto.ResultDto;

import java.util.logging.Logger;

import static com.kostenko.unil.Constants.*;

public class DichotomyMethod implements CustomMethod {
    public final CustomFunction customFunction;
    public final Logger log = Logger.getLogger(DichotomyMethod.class.getName());

    public DichotomyMethod(CustomFunction customFunction) {
        this.customFunction = customFunction;
    }

    @Override
    public ResultDto calculate() {
        int i = 0;
        double x = START_POINT;
        double a = START_RANGE;
        double b = END_RANGE;
        while (Math.abs(customFunction.calculate(x)) > EPS) {
            if (Math.signum(customFunction.calculate(x)) == Math.signum(customFunction.calculate(b))) {
                b = x;
            }
            if (Math.signum(customFunction.calculate(x)) == Math.signum(customFunction.calculate(a))) {
                a = x;
            }

            x = (a + b) / 2;
            i++;

            log(x, i);
        }
        return new ResultDto(i, x);
    }

    private void log(double x, int i) {
        String logInfo = "iteration: " + i + ", x: " + x;
        log.info(logInfo);
    }
}
